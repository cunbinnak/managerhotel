package com.manager.ctrl;

import com.manager.config.StringUtil;
import com.manager.dto.SearchCustomerRequest;
import com.manager.dto.SearchServiceRequest;
import com.manager.entity.Customer;
import com.manager.serviceImpl.StaffServiceImpl;
import com.manager.serviceImpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet({"/customers", "/customer_detail", "/customer_update", "/customer_insert"})
public class CustomerCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        try {
            String url = request.getServletPath();
            if(url.endsWith("customers")){
                SearchCustomerRequest req = new SearchCustomerRequest();
                req.setName(StringUtil.checkValidString(session.getAttribute("name").toString()));
                req.setPhone(StringUtil.checkValidString(session.getAttribute("phone").toString()));
                req.setEmail(StringUtil.checkValidString(session.getAttribute("email").toString()));
                request.setAttribute("serviceList", userService.findAllCustomers(req));
                request.getRequestDispatcher("/views/user/service_list.jsp").forward(request, response);
                session.removeAttribute("nameService");
            }
            if(url.endsWith("customer_detail")){
                Customer customer = userService.findCustomerById(request.getParameter("customerId"));
                request.setAttribute("customerDetail", customer);
                request.getRequestDispatcher( "/views/user/detailCustomer.jsp").forward(request, response);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserServiceImpl userService = new UserServiceImpl();
            String url = request.getServletPath();
            Customer customer = new Customer();
            if(url.endsWith("customer_update")){
                customer = userService.findCustomerById(request.getParameter("customerId"));
                if(customer == null){
                    request.setAttribute("message", "Không tồn tại user");
                    request.getRequestDispatcher("/views/user/updateCustomer.jsp").forward(request, response);
                }
                String name = request.getParameter("name");

                Date birthDay = null;
                if(request.getParameter("birthDay") != null && !request.getParameter("birthDay").isEmpty()){
                    birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("birthDay"));
                }

                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                customer.setId(customer.getId());
                customer.setName(name);
                customer.setBirthDay(birthDay);
                customer.setAddress(address);
                customer.setEmail(email);
                customer.setId(customer.getId());
                customer.setPhone(phone);
                customer.setType(customer.getType());
                userService.updateCustomer(customer);
            };
            if(url.endsWith("customer_insert")){
                String customerId = String.valueOf(UUID.randomUUID());
                String name = request.getParameter("name");
                Date birthDay = null;
                if(request.getParameter("birthDay") != null && !request.getParameter("birthDay").isEmpty()){
                    birthDay = new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("birthDay"));
                }
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String type = "2";
                customer.setName(name);
                customer.setBirthDay(birthDay);
                customer.setAddress(address);
                customer.setEmail(email);
                customer.setId(customerId);
                customer.setPhone(phone);
                customer.setType(type);
                userService.createCustomer(customer);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
