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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
                    bill.setId(session.getAttribute("billIdSearch").toString());
                }
                if(session.getAttribute("billStatus") != null){
                    bill.setStatus(session.getAttribute("billStatus").toString());
                }
                req.setAttribute("billDetail", staffService.getAllBill(bill));
                req.getRequestDispatcher("/views/staff/bill_list.jsp").forward(req, response);
                session.removeAttribute("customerIdSearchBill");
                session.removeAttribute("billIdSearch");
                session.removeAttribute("billStatus");
            }
            if(url.endsWith("update_bill")){

            }
            if(url.endsWith("create_bill")){
                req.getRequestDispatcher("/views/staff/create_bill.jsp").forward(req, response);
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
                request.setCheckinDate(Timestamp.valueOf(req.getParameter("checkInDate")+ " 00:00:00"));
                request.setCheckoutDate(Timestamp.valueOf(req.getParameter("checkOutDate")+ " 00:00:00"));
                request.setInvoiceDate(Timestamp.valueOf(req.getParameter("invoiceDate")+ " 00:00:00"));
                if (req.getParameter("orderId")!=null){
                    request.setOrderId(req.getParameter("orderId"));
                }
                if (req.getParameter("customerId")!=null){
                    request.setCustomerId(req.getParameter("customerId"));
                }
                request.setId(String.valueOf(UUID.randomUUID()));

                if(req.getParameter("orderId")!=null){
                    request.setOrderId(req.getParameter("orderId"));
                }
                if(req.getParameter("customerId")!=null){
                    request.setCustomerId(req.getParameter("customerId"));
                }
                request.setId(String.valueOf(UUID.randomUUID()));
                staffService.createBill(request);
                session.setAttribute("billIdSearch", request.getId());
                response.sendRedirect("/search_bill");

            }
            if(url.endsWith("update_bill")){
                Bill bill = new Bill();
                if (req.getParameter("billId")!=null){
                    bill = staffService.getBillById(req.getParameter("billId"));
                }
                if(bill!=null && req.getParameter("status")!=null && !req.getParameter("status").equalsIgnoreCase(bill.getStatus())){

                    bill.setStatus(req.getParameter("status"));
                    staffService.updateBill(bill);
                }
                response.sendRedirect("/search_bill");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
