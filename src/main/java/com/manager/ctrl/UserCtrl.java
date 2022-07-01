package com.manager.ctrl;

import com.manager.dto.SearchRoomRequest;
import com.manager.entity.Room;
import com.manager.serviceImpl.RoomServiceImpl;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.UUID;

@WebServlet({"/user/add-to-cart", "", "/rooms", "/room_detail", "/insert_room", "/update_room"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserCtrl extends HttpServlet {
    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public UserCtrl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            String userName = session.getAttribute("username").toString();
            req.setAttribute("userName", userName);
        }
        String uri = req.getServletPath();
        RoomServiceImpl roomService = new RoomServiceImpl();
        try {
            if (uri.isEmpty()) {
                req.setAttribute("rooms", roomService.findAllRoom(new SearchRoomRequest()));
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            if (uri.equalsIgnoreCase("/rooms")) {
                SearchRoomRequest rq = new SearchRoomRequest();
                if (session.getAttribute("roomRequest") != null) {
                    rq = (SearchRoomRequest) session.getAttribute("roomRequest");
                }
                req.setAttribute("rooms", roomService.findAllRoom(rq));
                req.getRequestDispatcher("/views/staff/room_list.jsp").forward(req, resp);
                session.removeAttribute("rooms");
            }
            if (uri.equalsIgnoreCase("/room_detail")) {
                req.getRequestDispatcher("/views/web/room_detail.jsp").forward(req, resp);
            }
            if (uri.equalsIgnoreCase("/insert_room")) {
                req.getRequestDispatcher("/views/staff/createRoom.jsp").forward(req, resp);
            }
            if (uri.equalsIgnoreCase("/update_room")) {
                detailRoomGet(req, resp);
                session.removeAttribute("roomDetail");
            }
            if (uri.equalsIgnoreCase("/user/add-to-cart")) {
                String msg = "Đặt phòng thành công";
                req.setAttribute("msg", msg);

                req.getRequestDispatcher("/views/web/room_detail.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RoomServiceImpl roomService = new RoomServiceImpl();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName", userName);
        String uri = req.getServletPath();
        try {
            if (uri.equalsIgnoreCase("/rooms")) {
                searchRoom(req, resp, session);
            }
            if (uri.equalsIgnoreCase("/insert_room")) {
                insertRoom(req, resp);
            }
            if (uri.equalsIgnoreCase("/user/add-to-cart")) {
                String idroom = req.getParameter("idroom");
                String msg = "Đặt phòng thành công";
                req.setAttribute("msg", msg);
                resp.sendRedirect("");
                return;
            }
            if (uri.equalsIgnoreCase("/update_room")) {
                updateRoom(req, resp);
            }
        } catch (ExportException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchRoom(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        RoomServiceImpl roomService = new RoomServiceImpl();
        SearchRoomRequest rq = new SearchRoomRequest();
        if (req.getParameter("searchRoomByName") != null) {
            rq.setName(String.valueOf(req.getParameter("searchRoomByName")));
        }
        if (req.getParameter("searchRoomByPrice") != null) {
            rq.setPrice(String.valueOf(req.getParameter("searchRoomByPrice")));
        }
        if (req.getParameter("searchRoomByBed") != null) {
            rq.setBedNumber(String.valueOf(req.getParameter("searchRoomByBed")));
        }
        if (req.getParameter("searchRoomByPeople") != null) {
            rq.setPeopleNumber(String.valueOf(req.getParameter("searchRoomByPeople")));
        }
        if (req.getParameter("searchRoomByStatus") != null) {
            rq.setStatus(String.valueOf(req.getParameter("searchRoomByStatus")));
        }
        session.setAttribute("roomRequest", rq);
        resp.sendRedirect("/rooms");
        session.removeAttribute("roomRequest");
    }

    private void insertRoom(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        RoomServiceImpl roomService = new RoomServiceImpl();
        Room room = new Room();
        if (req.getParameter("roomName") != null) {
            room.setName(String.valueOf(req.getParameter("roomName")));
        }
        if (req.getParameter("price") != null) {
            room.setPrice(String.valueOf(req.getParameter("price")));
        }
        if (req.getParameter("discountPrice") != null) {
            room.setDiscountPrice(String.valueOf(req.getParameter("discountPrice")));
        }
        if (req.getParameter("square") != null) {
            room.setSquare(String.valueOf(req.getParameter("square")));
        }
        if (req.getParameter("bedNumber") != null) {
            room.setBedNumber(String.valueOf(req.getParameter("bedNumber")));
        }
        if (req.getParameter("peopleNumber") != null) {
            room.setPeopleNumber(String.valueOf(req.getParameter("peopleNumber")));
        }
        if (req.getParameter("description") != null) {
            room.setDescription(String.valueOf(req.getParameter("description")));
        }
        if (req.getParameter("status") != null) {
            room.setStatus(String.valueOf(req.getParameter("status")));
        }
        if (req.getParameter("status") != null) {
            room.setStatus(String.valueOf(req.getParameter("status")));
        }
        String imagePath = uploadFile(req, resp);
        if (imagePath != null && !imagePath.isEmpty()) {
            room.setImage(imagePath);
        }
        room.setId(UUID.randomUUID().toString());
        room.setIsDeleted(Boolean.FALSE);
        roomService.create(room);
        resp.sendRedirect("/rooms");
    }

    private void detailRoomGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        Room room = new Room();
        RoomServiceImpl roomService = new RoomServiceImpl();
        String id = req.getParameter("idroom");
        // FIX value
//        String id = "1";
        room = roomService.getRoomDetail(id);
        req.setAttribute("roomDetail", room);
        req.getRequestDispatcher("views/staff/updateRoom.jsp").forward(req, resp);
    }

    private void updateRoom(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        RoomServiceImpl roomService = new RoomServiceImpl();
        Room room = new Room();
        if (req.getParameter("name") != null) {
            room.setName(String.valueOf(req.getParameter("name")));
        }
        if (req.getParameter("price") != null) {
            room.setPrice(String.valueOf(req.getParameter("price")));
        }
        if (req.getParameter("discountPrice") != null) {
            room.setDiscountPrice(String.valueOf(req.getParameter("discountPrice")));
        }
        if (req.getParameter("square") != null) {
            room.setSquare(String.valueOf(req.getParameter("square")));
        }
        if (req.getParameter("bedNumber") != null) {
            room.setBedNumber(String.valueOf(req.getParameter("bedNumber")));
        }
        if (req.getParameter("peopleNumber") != null) {
            room.setPeopleNumber(String.valueOf(req.getParameter("peopleNumber")));
        }
        String imagePath = uploadFile(req, resp);
        if (imagePath != null && !imagePath.isEmpty()) {
            room.setImage(imagePath);
        }
        if (req.getParameter("description") != null) {
            room.setDescription(String.valueOf(req.getParameter("description")));
        }
        if (req.getParameter("status") != null) {
            room.setStatus(String.valueOf(req.getParameter("status")));
        }
        String roomId = req.getParameter("roomId");
        room.setId(roomId);
        roomService.updateRoom(room);
        resp.sendRedirect("/rooms");
    }

    private String uploadFile(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Part part = request.getPart("fileimage");
        String fileName = extractFileName(part);
        if (part !=null && part.getSubmittedFileName() != null &&  !part.getSubmittedFileName().isEmpty() ){

            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();

            String realPath = request.getServletContext().getRealPath("/images");
//        String nameFile = part.getSubmittedFileName();
            String nameFile = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectory(Paths.get(realPath));

            }
            part.write(realPath+"/"+nameFile);
            return  nameFile;
        }

//        part.write(this.getFolderUpload(request).getAbsolutePath() + File.separator + fileName);

//        return this.getFolderUpload(request).getAbsolutePath() + File.separator + fileName;
        return null;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload(HttpServletRequest req) {
        String path = "views/image/room";
        String imagePath = req.getServletContext().getRealPath(path);
        File folderUpload = new File(imagePath);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        System.out.println(imagePath);
        return folderUpload;
    }
}
