package com.manager.ctrl;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/room")
public class RoomCtrl extends HttpServlet {

    private static final String PATH = "/authen/";
    private static final String PATH_JSP = "/views/authen/";

    public RoomCtrl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getServletPath();
        if (uri.equalsIgnoreCase(PATH + "login")) {
            req.getRequestDispatcher(PATH_JSP + "login.jsp").forward(req, resp);
        }
        if (uri.equalsIgnoreCase(PATH + "register")) {
            req.getRequestDispatcher(PATH_JSP + "register.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uri = req.getServletPath();
//        if(uri.equalsIgnoreCase(PATH + "login")){
//            login(req, resp, session);
//        }
//        if(uri.equalsIgnoreCase(PATH + "register")){
//            register(req, resp, session);
//        }

    }


}
