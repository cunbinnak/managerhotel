package com.manager.ctrl;

import com.manager.config.StringUtil;
import com.manager.dto.SearchServiceRequest;
import com.manager.serviceImpl.StaffServiceImpl;
import com.manager.serviceImpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/search/service"})
public class ServiceCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String url = req.getServletPath();
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName",userName);
        UserServiceImpl userService = new UserServiceImpl();
        try {
            if (url.equalsIgnoreCase("search/service")) {
                SearchServiceRequest request = new SearchServiceRequest();
                request.setName(StringUtil.checkValidString(session.getAttribute("nameService").toString()));
                StaffServiceImpl staffService = new StaffServiceImpl();
                req.setAttribute("serviceList", staffService.findAllService(request));
                req.getRequestDispatcher("/views/user/service_list.jsp").forward(req, response);
                session.removeAttribute("nameService");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
                String url = req.getServletPath();
                HttpSession session = req.getSession();
                String userName = session.getAttribute("username").toString();
                req.setAttribute("userName",userName);
                UserServiceImpl userService = new UserServiceImpl();
                try {
                    if (url.equalsIgnoreCase("search/service")) {
                        session.setAttribute("nameService", StringUtil.checkValidString(req.getParameter("nameService")));
                        response.sendRedirect("search/service");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
}
