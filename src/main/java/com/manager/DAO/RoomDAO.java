package com.manager.DAO;

import com.manager.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {

    public void createRoom(Room room) throws SQLException;

    public List<Room> getAllRoom() throws SQLException;

    public Room updateRoom(Room room);

    public void deleteRoom(List<String> ids) throws SQLException;

    public Room getRoomDetail(String id) throws SQLException;
}
