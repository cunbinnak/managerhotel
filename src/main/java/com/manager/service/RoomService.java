package com.manager.service;

import com.manager.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {

    void create(Room room) throws SQLException;

    List<Room> findAllRoom() throws SQLException;

    Room getRoomDetail(String id) throws SQLException;
}
