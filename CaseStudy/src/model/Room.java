package model;

public class Room {
    private long idRoom;
    private String nameRoom;
    private boolean statusRoom;
    private int priceRoom;
    private int priceElectric;
    private int priceWater;
    private int priceInternet;

    public Room() {
    }

    public Room(long idRoom, String nameRoom, boolean statusRoom, int priceRoom, int priceElectric, int priceWater, int priceInternet) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.statusRoom = statusRoom;
        this.priceRoom = priceRoom;
        this.priceElectric = priceElectric;
        this.priceWater = priceWater;
        this.priceInternet = priceInternet;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public boolean isStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(boolean statusRoom) {
        this.statusRoom = statusRoom;
    }

    public int getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(int priceRoom) {
        this.priceRoom = priceRoom;
    }

    public int getPriceElectric() {
        return priceElectric;
    }

    public void setPriceElectric(int priceElectric) {
        this.priceElectric = priceElectric;
    }

    public int getPriceWater() {
        return priceWater;
    }

    public void setPriceWater(int priceWater) {
        this.priceWater = priceWater;
    }

    public int getPriceInternet() {
        return priceInternet;
    }

    public void setPriceInternet(int priceInternet) {
        this.priceInternet = priceInternet;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s\n", this.idRoom, this.nameRoom, this.statusRoom, this.priceRoom, this.priceElectric, this.priceWater, this.priceInternet);
    }
}
