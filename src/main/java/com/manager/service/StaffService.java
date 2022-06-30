package com.manager.service;

import com.manager.dto.SearchServiceRequest;
import com.manager.entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface StaffService {
    void create(Service service) throws SQLException;

    List<Service> findAllService(SearchServiceRequest rq) throws SQLException;

    Service getServiceDetail(String id) throws SQLException;
}
