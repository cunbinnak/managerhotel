package com.manager.ctrl;

import com.manager.dto.SearchRoomRequest;
import com.manager.serviceImpl.RoomServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/staff")
public class StaffCtrl extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RoomServiceImpl roomService = new RoomServiceImpl();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);
        req.setAttribute("rooms", roomService.findAllRoom(new SearchRoomRequest()));
        req.getRequestDispatcher("/views/staff/room_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);

        super.doPost(req, resp);
    }
}
