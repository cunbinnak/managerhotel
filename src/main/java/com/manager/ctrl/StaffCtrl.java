package com.manager.ctrl;

import com.manager.dto.SearchRoomRequest;
import com.manager.entity.Room;
import com.manager.serviceImpl.RoomServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet( {"/staff","/staff_create_room","/add_room"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class StaffCtrl extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RoomServiceImpl roomService = new RoomServiceImpl();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);
        String url = req.getServletPath();
        if (url.equalsIgnoreCase("/staff")){
            req.setAttribute("rooms", roomService.findAllRoom(new SearchRoomRequest()));
            req.getRequestDispatcher("/views/staff/room_list.jsp").forward(req, resp);
        }
        if (url.equalsIgnoreCase("/staff_create_room")){
            req.getRequestDispatcher("/views/staff/createRoom.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);
        String uri = req.getServletPath();
        if (uri.equalsIgnoreCase("/add_room")) {
            try {
                insertRoom(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        RoomServiceImpl roomService = new RoomServiceImpl();
        Room room = new Room();
        if (req.getParameter("roomName") != null) {
            room.setName(String.valueOf(req.getParameter("roomName")));
        }
        if (req.getParameter("price") != null) {
            room.setPrice(String.valueOf(req.getParameter("price")));
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

//        Part filePart = req.getPart("fileimage");
//        ServletContext context = getServletContext();
//        URL resourceUrl  = context.getResource("/image");
//        String path = resourceUrl.toString();
////                req.getServletContext().getRealPath("/image");
//        String  fileName = filePart.getSubmittedFileName();
//        room.setImage(fileName);
//        for (Part part : req.getParts()) {
//            part.write(path + fileName);
//        }

        room.setId(UUID.randomUUID().toString());
        room.setIsDeleted(Boolean.FALSE);
        roomService.create(room);
        resp.sendRedirect("/rooms");
    }
}
