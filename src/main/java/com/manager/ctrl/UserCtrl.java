package com.manager.ctrl;

import com.manager.dto.SearchRoomRequest;
import com.manager.serviceImpl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({ "/user/add-to-cart","/user" })
public class UserCtrl extends HttpServlet {

    public UserCtrl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        RoomServiceImpl roomService = new RoomServiceImpl();
        String url = req.getServletPath();
        req.setAttribute("userName",userName);
        if(url.equalsIgnoreCase("/user")){
            try {
                req.setAttribute("rooms", roomService.findAllRoom(new SearchRoomRequest()));
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(url.equalsIgnoreCase("/user/add-to-cart")){
            String msg = "Đặt phòng thành công";
            req.setAttribute("msg", msg);
//            resp.sendRedirect("");

            req.getRequestDispatcher("/views/web/room_detail.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);

        String url = req.getServletPath();
        String idroom = req.getParameter("idroom");
        if(url.equalsIgnoreCase("/user/add-to-cart")){
            String msg = "Đặt phòng thành công";
            req.setAttribute("msg", msg);
            resp.sendRedirect("");
            return;
        }

    }
}
