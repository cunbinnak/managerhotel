package com.manager.serviceImpl;

import com.manager.DAO.OrderDao;
import com.manager.DAOImpl.*;
import com.manager.dto.CreateBillRequest;
import com.manager.dto.SearchServiceRequest;
import com.manager.entity.*;
import com.manager.service.StaffService;

import java.sql.SQLException;
import java.util.*;

public class StaffServiceImpl implements StaffService {

    @Override
    public void create(Service service) throws SQLException {
        ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
        serviceDAO.createService(service);
    }

    @Override
    public List<Service> findAllService(SearchServiceRequest rq) throws SQLException {
        ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
        Map<String, String> spec = new HashMap<>();
        if (rq != null) {
            if (rq.getName() != null && !rq.getName().isEmpty()) {
                spec.put("name", "'%" + rq.getName() + "%'");
            }
        }
        return serviceDAO.getAllService(spec);
    }

    @Override
    public Service getServiceDetail(String id) throws SQLException {
        ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
        return serviceDAO.getServiceDetail(id);
    }

    @Override
    public void updateService(Service service) throws SQLException {
        ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
        Map<String, String> spec = new HashMap<>();
        if (service != null) {
            if (service.getName() != null && !service.getName().isEmpty()) {
                spec.put("name", "'" + service.getName() + "'");
            }
            if (service.getDescription() != null && !service.getDescription().isEmpty()) {
                spec.put("description", "'" + service.getDescription() + "'");
            }
            if (service.getPrice() != null) {
                spec.put("price", "'" + service.getPrice() + "'");
            }
            if (service.getImage() != null) {
                spec.put("image", "'" + service.getImage() + "'");
            }
            if (service.getUnit() != null) {
                spec.put("unit", "'" + service.getUnit() + "'");
            } else {
                return;
            }
            serviceDAO.updateService(spec, service.getId());
        }
    }

    @Override
    public void createBill(CreateBillRequest request) throws SQLException {
    //Get order and orderDetail by order
        BillDAOImpl billDAO = new BillDAOImpl();
        BillDetailDAOImpl billDetailDAO = new BillDetailDAOImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();
        Order order = orderDao.getOrder(request.getOrderId());
        if(order != null){
            List<OrderDetails> orderDetails = orderDetailDao.getOrderDetailByOrderId(request.getOrderId());

            //Create bill
            Bill bill = new Bill();
            String billId = UUID.randomUUID().toString();
            bill.setCustomerId(order.getCustomerId());
            bill.setInvoiceDate(request.getInvoiceDate());
            bill.setCheckinDate(request.getCheckinDate());
            bill.setCheckoutDate(request.getCheckoutDate());
            bill.setCreatedUser(request.getCreatedUser());
            bill.setIsDeleted(Boolean.FALSE);
            bill.setCheckinMonth(String.valueOf(bill.getCheckinDate().getMonth() + 1));
            bill.setCheckoutMonth(String.valueOf(bill.getCheckoutDate().getMonth() + 1));
            bill.setCheckinYear(String.valueOf(bill.getCheckinDate().getYear() + 1900));
            bill.setCheckoutYear(String.valueOf(bill.getCheckoutDate().getYear() + 1900));
            bill.setId(billId);
            billDAO.newBill(bill);

            //creted billDetail
            List<BillDetails> billDetails = new ArrayList<>();
            for(OrderDetails orderDetail :orderDetails){
                BillDetails billDetail = new BillDetails();
                billDetail.setBillId(billId);
                billDetail.setAmount(orderDetail.getAmount());
                billDetail.setRefId(orderDetail.getRefId());
                billDetail.setNameRef(orderDetail.getNameRef());
                billDetail.setPriceRef(orderDetail.getPriceRef());
                billDetail.setRefType(orderDetail.getRefType());
                billDetail.setCreatedUser(orderDetail.getCreatedUser());
                billDetail.setId(UUID.randomUUID().toString());

                billDetails.add(billDetail);
            }
            if(!billDetails.isEmpty()){
                billDetailDAO.newBillDetail(billDetails);
            }

        }
    }

}
