package com.manager.ctrl;

import com.manager.dto.SearchRoomRequest;
import com.manager.entity.Room;
import com.manager.serviceImpl.RoomServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/rooms", "/room_detail", ""})
public class RoomCtrl extends HttpServlet {

    private static final String PATH = "/authen/";
    private static final String PATH_JSP = "/views/staff/";

    public RoomCtrl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getServletPath();
        RoomServiceImpl roomService = new RoomServiceImpl();
        HttpSession session = req.getSession();
        try {
            if(  uri.isEmpty()){
                req.setAttribute("rooms", roomService.findAllRoom(new SearchRoomRequest()));
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            if (uri.equalsIgnoreCase("/rooms")) {

                SearchRoomRequest rq = new SearchRoomRequest();
                if (session.getAttribute("roomRequest") != null) {
                    rq = (SearchRoomRequest) session.getAttribute("roomRequest");
                }
                req.setAttribute("rooms", roomService.findAllRoom(rq));
                req.getRequestDispatcher(PATH_JSP + "room_list.jsp").forward(req, resp);
            }
            if(uri.equalsIgnoreCase("/room_detail")){
                String idr = req.getParameter("idroom");
                req.setAttribute("roomdetail", roomService.getRoomDetail(req.getParameter("idroom")));
                req.getRequestDispatcher("/views/web/room_detail.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uri = req.getServletPath();
        if (uri.equalsIgnoreCase("/rooms")) {
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
        }

    }


}
