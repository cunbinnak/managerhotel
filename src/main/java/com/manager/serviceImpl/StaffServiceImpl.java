package com.manager.serviceImpl;

import com.manager.DAOImpl.ServiceDAOImpl;
import com.manager.dto.SearchServiceRequest;
import com.manager.entity.Service;
import com.manager.service.StaffService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
