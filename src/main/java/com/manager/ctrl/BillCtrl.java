package com.manager.ctrl;

import com.manager.config.StringUtil;
import com.manager.dto.CreateBillRequest;
import com.manager.dto.SearchServiceRequest;
import com.manager.entity.Bill;
import com.manager.entity.Service;
import com.manager.serviceImpl.StaffServiceImpl;
import com.manager.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

@WebServlet({"/search_bill", "/detail_bill", "/update_bill","/create_bill"})
public class BillCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String url = req.getServletPath();
        HttpSession session = req.getSession();
        String userName = session.getAttribute("username").toString();
        req.setAttribute("userName", userName);
        StaffServiceImpl staffService = new StaffServiceImpl();
        try {
            if (url.endsWith("search_bill")) {
                Bill bill = new Bill();
                if(session.getAttribute("customerIdSearchBill") != null){
                    bill.setCustomerId(session.getAttribute("customerIdSearchBill").toString());
                }
                if(session.getAttribute("billIdSearch") != null){
                    bill.setCustomerId(session.getAttribute("billIdSearch").toString());
                }
                if(session.getAttribute("billStatus") != null){
                    bill.setCustomerId(session.getAttribute("billStatus").toString());
                }
                req.setAttribute("billDetail", staffService.getAllBill(bill));
                req.getRequestDispatcher("/staff/bill_list.jsp").forward(req, response);
                session.removeAttribute("customerIdSearchBill");
                session.removeAttribute("billIdSearch");
                session.removeAttribute("billStatus");
            }
            if(url.endsWith("update_bill")){

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
        req.setAttribute("userName", userName);
        UserServiceImpl userService = new UserServiceImpl();
        StaffServiceImpl staffService = new StaffServiceImpl();
        try {
            if (url.endsWith("search_bill")) {
                session.setAttribute("customerIdSearchBill", req.getParameter("customerIdSearchBill"));
                session.setAttribute("billIdSearch", req.getParameter("billIdSearch"));
                session.setAttribute("billStatus", req.getParameter("billStatus"));
                response.sendRedirect("/search_bill");
            }
            if(url.endsWith("create_bill")){
                CreateBillRequest request = new CreateBillRequest();
                request.setCreatedUser(session.getAttribute("username").toString());
                request.setStatus("pending");
                request.setCheckinDate(Timestamp.valueOf(session.getAttribute("checkInDate").toString()));
                request.setCheckoutDate(Timestamp.valueOf(session.getAttribute("checkOutDate").toString()));
                request.setInvoiceDate(Timestamp.valueOf(session.getAttribute("invoiceDate").toString()));
                request.setOrderId(session.getAttribute("orderId").toString());
                request.setId(String.valueOf(UUID.randomUUID()));
                staffService.createBill(request);
                session.setAttribute("billIdSearch", request.getId());
                response.sendRedirect("/search_bill");
            }
            if(url.endsWith("update_bill")){

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
