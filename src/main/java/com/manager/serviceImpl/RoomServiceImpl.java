package com.manager.serviceImpl;

import com.manager.DAOImpl.RoomDAOImpl;
import com.manager.entity.Room;
import com.manager.service.RoomService;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    @Override
    public void create(Room room) throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        roomDAO.createRoom(room);
    }

    @Override
    public List<Room> findAllRoom() throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        return roomDAO.getAllRoom();
    }

    @Override
    public Room getRoomDetail(String id) throws SQLException {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        return roomDAO.getRoomDetail(id);
    }

}
