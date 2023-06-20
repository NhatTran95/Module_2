package service;

import model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRoom();
    Room findRoomById(long idRoom);
    void updateStatusRoomById(long idRoom);
    void updatePriceRoomById(long idRoom, Room room);
}
