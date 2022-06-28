package com.manager.serviceImpl;

import com.manager.DAOImpl.RoomDAOImpl;
import com.manager.DAOImpl.UserDAOImpl;
import com.manager.dto.SearchRoomRequest;
import com.manager.entity.Room;
import com.manager.service.RoomService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomServiceImpl implements RoomService {

    @Override
    public void create(Room room) throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        roomDAO.createRoom(room);
    }

    @Override
    public List<Room> findAllRoom(SearchRoomRequest rq) throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        Map<String, String> spec = new HashMap<>();
        if (rq != null) {
            if (rq.getName() != null && !rq.getName().isEmpty()) {
                spec.put("name", "'%" + rq.getName() + "%'");
            }
            if (rq.getPrice() != null && !rq.getPrice().isEmpty()) {
                spec.put("price", "'%" + rq.getPrice() + "%'");
            }
            if (rq.getBedNumber() != null && !rq.getBedNumber().isEmpty()) {
                spec.put("bed_number", "'%" + rq.getBedNumber() + "%'");
            }
            if (rq.getPeopleNumber() != null && !rq.getPeopleNumber().isEmpty()) {
                spec.put("people_number", "'%" + rq.getPeopleNumber() + "%'");
            }
            if (rq.getStatus() != null && !rq.getStatus().isEmpty()) {
                spec.put("status", "'%" + rq.getStatus() + "%'");
            }
        }
        return roomDAO.getAllRoom(spec);
    }

    @Override
    public Room getRoomDetail(String id) throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        return roomDAO.getRoomDetail(id);
    }


}
