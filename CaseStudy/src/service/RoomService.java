package service;

import config.Config;
import model.Room;
import utils.FileUtils;

import java.util.List;

public class RoomService implements IRoomService{
    private final String pathRoom = "F:\\Module2\\CaseStudy\\data\\room.csv";
    @Override
    public List<Room> getAllRoom() {
        return FileUtils.readFile(pathRoom, Config.TYPE_ROOM);
    }

    @Override
    public Room findRoomById(long idRoom) {
        List<Room> rooms = FileUtils.readFile(pathRoom, Config.TYPE_ROOM);
        for(Room room : rooms){
            if(room.getIdRoom() == idRoom){
                return room;
            }
        }
        return null;
    }

    @Override
    public void updateStatusRoomById(long idRoom) {
        List<Room> rooms = FileUtils.readFile(pathRoom, Config.TYPE_ROOM);
        for(Room room : rooms){
            if(room.getIdRoom() == idRoom){
                if(room.isStatusRoom()== true) room.setStatusRoom(false);
                else room.setStatusRoom(true);
            }
        }
        FileUtils.writeFile(rooms,pathRoom);
    }

    @Override
    public void updatePriceRoomById(long idRoom, Room room) {
        List<Room> rooms = FileUtils.readFile(pathRoom, Config.TYPE_ROOM);
        for(Room r : rooms){
            if(r.getIdRoom() == idRoom){
               r.setPriceRoom(room.getPriceRoom());
               r.setPriceElectric(room.getPriceElectric());
               r.setPriceWater(room.getPriceWater());
               r.setPriceInternet(room.getPriceInternet());
            }
        }
        FileUtils.writeFile(rooms,pathRoom);
    }

}
