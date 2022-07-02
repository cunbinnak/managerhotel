package com.manager.ctrl;

import com.manager.dto.DetailOrder;
import com.manager.dto.SearchRoomRequest;
import com.manager.entity.*;
import com.manager.serviceImpl.RoomServiceImpl;
import com.manager.serviceImpl.StaffServiceImpl;
import com.manager.serviceImpl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({"/user/add-to-cart", "", "/rooms", "/room_detail", "/insert_room", "/update_room",
        "/create_order", "/update_order", "/order_list", "/insert_service"})
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
            if (uri.endsWith("/create_order")) {
                createOrder(req, resp, session);
            }
            if (uri.endsWith("/order_list")) {
                getListOrder(req, resp, session);
            }
            if (uri.equalsIgnoreCase("/insert_service")){
                req.getRequestDispatcher("/views/staff/insert_service.jsp").forward(req,resp);
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
            if (uri.equalsIgnoreCase("/create_order")) {
                createOrder(req, resp, session);
            }
            if (uri.equalsIgnoreCase("/update_order")) {
                updateOrder(req, resp);
            }

            if (uri.equalsIgnoreCase("/update_order_detail")) {
                updateOrderDetail(req, resp);
            }
            if (uri.equalsIgnoreCase("/insert_service")) {
                insertService(req, resp);
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
        if (part !=null && part.getSubmittedFileName() != null &&  !part.getSubmittedFileName().isEmpty() ){
            String realPath = request.getServletContext().getRealPath("/images");
            String nameFile = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectory(Paths.get(realPath));
            }
            part.write(realPath+"/"+nameFile);
            return  nameFile;
        }
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

    private void createOrder(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException, ServletException, IOException {
        String customerId = "";
        UserServiceImpl userService = new UserServiceImpl();
        if (request.getParameter("customerId") != null) {
            customerId = request.getParameter("customerId");
        }
        if (session.getAttribute("role") != null && session.getAttribute("role").toString().equalsIgnoreCase("USER")) {
            User user = userService.findByUserName(session.getAttribute("username").toString());
            if (user.getCustomerId() != null && !user.getCustomerId().isEmpty()) {
                Customer customer = userService.findCustomerById(user.getCustomerId());
                customerId = customer.getId();
            } else {
                request.setAttribute("message", "Tài khoản mật khẩu không chính xác");
                request.getRequestDispatcher("").forward(request, response);
            }
        }
        Order order = new Order();
        order.setCustomerId(customerId);

        order.setCustomerId(customerId);
        order.setStatus("pending");

        if (request.getParameter("roomId") != null) {
            order.setOrderType("0");
        } else {
            order.setOrderType("1");
        }
        userService.createOrder(order);
        List<OrderDetails> orderDetails = new ArrayList<>();

        OrderDetails details = new OrderDetails();
        if(Integer.valueOf(request.getParameter("amount") ) < 1){
            request.setAttribute("message", "Số lượng phải lớn hơn 0");
            request.getRequestDispatcher("").forward(request, response);
        }
        details.setAmount(request.getParameter("amount"));
        details.setUnit(request.getParameter("unit"));
        details.setRefType(request.getParameter("refType"));
        details.setRefId(request.getParameter("refId"));
        details.setOrderId(order.getId());
        details.setPriceRef(Double.valueOf(request.getParameter("priceRef")));
        details.setNameRef(request.getParameter("nameRef"));
        details.setAmount(request.getParameter("amount"));
        details.setId(String.valueOf(UUID.randomUUID()));
        orderDetails.add(details);

        userService.createOrderDetail(orderDetails);
    }

    private List<DetailOrder> getListOrder(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
        List<DetailOrder> detailOrders = new ArrayList<>();
        UserServiceImpl userService = new UserServiceImpl();
        String status = request.getParameter("statusOrder");
        String orderType = request.getParameter("orderType");
        Order order = new Order();
        List<Order> orders = new ArrayList<>();
        order.setOrderType(orderType);
        order.setStatus(status);
        if (request.getParameter("orderId") != null) {
            order.setId(request.getParameter("orderId"));
            order = userService.getOrderById(order.getId());
            orders.add(order);
        } else {
            orders = userService.getAllOrder(order);
        }
        for (Order order1 : orders) {
            DetailOrder detailOrder = new DetailOrder();
            if (order1.getOrderType().equalsIgnoreCase("0")) {
                detailOrder.setOrderName("Đặt phòng");
            } else {
                detailOrder.setOrderName("Dịch vụ");
            }
            detailOrder.setOrderType(order1.getOrderType());
            detailOrder.setOrderDetails(userService.getOrderDetailByOrderId(order1.getId()));
            detailOrders.add(detailOrder);
        }
        return detailOrders;
    }

    private void updateOrder(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        UserServiceImpl userService = new UserServiceImpl();
        if(req.getParameter("orderId") == null){
            req.setAttribute("message", "Chưa chọn order nào");
            req.getRequestDispatcher("").forward(req, resp);
        }
        Order order = userService.getOrderById(req.getParameter("orderId"));
        if(order == null){
            req.setAttribute("message", "Chưa chọn order nào");
            req.getRequestDispatcher("").forward(req, resp);
        }
        if (req.getParameter("statusOrder") != null) {
            order.setStatus(String.valueOf(req.getParameter("statusOrder")));
        }
        userService.updateOrder(order);
        resp.sendRedirect("/orders");
    }

    private void updateOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        if(req.getParameter("orderId") == null){
            req.setAttribute("message", "Chưa chọn order nào");
            req.getRequestDispatcher("").forward(req, resp);
        }
        Order order = userService.getOrderById(req.getParameter("orderId"));
        if(order == null && !order.getStatus().equalsIgnoreCase("pending")){
            req.setAttribute("message", "không thể sửa bản ghi này");
            req.getRequestDispatcher("").forward(req, resp);
        }
        OrderDetails orderDetails = userService.getOrderDetailById(req.getParameter("orderDetailId"));
        if(orderDetails != null ){
            req.setAttribute("message", "Chưa có trong order");
            req.getRequestDispatcher("").forward(req, resp);
        }
        if(Integer.valueOf(req.getParameter("amount")) < 1){
            userService.deleteOrderDetailById(orderDetails.getId());
            resp.sendRedirect("/orders");
        }
        orderDetails.setAmount(req.getParameter("amount"));
        userService.updateOrderDetail(orderDetails);
        resp.sendRedirect("/orders");
    }


    private void insertService(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        StaffServiceImpl staffService = new StaffServiceImpl();
        Service service = new Service();
        if (req.getParameter("serviceName") != null) {
            service.setName(String.valueOf(req.getParameter("serviceName")));
        }
        if (req.getParameter("price") != null) {
            service.setPrice(Double.valueOf(req.getParameter("price")));
        }
        if (req.getParameter("amount") != null) {
            service.setAmount(req.getParameter("amount"));
        }
        if (req.getParameter("description") != null) {
            service.setDescription(req.getParameter("description"));
        }
        if (req.getParameter("unit") != null) {
            service.setUnit(req.getParameter("unit"));
        }
        String imagePath = uploadFileService(req, resp);
        if (imagePath != null && !imagePath.isEmpty()) {
            service.setImage(imagePath);
        }
        service.setId(UUID.randomUUID().toString());
        service.setIsDeleted(Boolean.FALSE);
        staffService.create(service);
        resp.sendRedirect("/search_service");
    }

    private void updateService(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, SQLException, ServletException {
        StaffServiceImpl staffService = new StaffServiceImpl();
        Service service = new Service();
        if (req.getParameter("name") != null) {
            service.setName(req.getParameter("name"));
        }
        if (req.getParameter("description") != null) {
            service.setDescription(req.getParameter("description"));
        }
        if (req.getParameter("price") != null) {
            service.setPrice(Double.valueOf(req.getParameter("price")));
        }
        String imagePath = uploadFileService(req, resp);
        if (imagePath != null && !imagePath.isEmpty()) {
            service.setImage(imagePath);
        }
        if (req.getParameter("amount") != null) {
            service.setAmount(String.valueOf(req.getParameter("amount")));
        }
        if (req.getParameter("unit") != null) {
            service.setUnit(String.valueOf(req.getParameter("unit")));
        }
        String serviceId = req.getParameter("serviceId");
        service.setId(serviceId);
        staffService.updateService(service);
        resp.sendRedirect("/search_service");
    }

    private String uploadFileService(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Part part = request.getPart("fileimage");
        if (part !=null && part.getSubmittedFileName() != null &&  !part.getSubmittedFileName().isEmpty() ){
            String realPath = request.getServletContext().getRealPath("/images");
            String nameFile = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectory(Paths.get(realPath));
            }
            part.write(realPath+"/"+nameFile);
            return  nameFile;
        }
        return null;
    }

    private String extractFileNameService(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUploadService(HttpServletRequest req) {
        String path = "views/image/service";
        String imagePath = req.getServletContext().getRealPath(path);
        File folderUpload = new File(imagePath);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        System.out.println(imagePath);
        return folderUpload;
    }
}
