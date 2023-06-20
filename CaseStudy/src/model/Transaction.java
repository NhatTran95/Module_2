package model;

import utils.DateUtils;

import java.time.LocalDate;

public class Transaction {
    private long id;
    private long idRenter;
    private int roomBill;
    private int electricBill;
    private int waterBill;
    private  int internetBill;
    private int totalBill;
    private String month;
    private String year;
    private LocalDate createAt;

    public Transaction() {
    }

    public Transaction(long id, long idRenter, int roomBill, int electricBill, int waterBill, int internetBill, int totalBill, String month, String year, LocalDate createAt) {
        this.id = id;
        this.idRenter = idRenter;
        this.roomBill = roomBill;
        this.electricBill = electricBill;
        this.waterBill = waterBill;
        this.internetBill = internetBill;
        this.totalBill = totalBill;
        this.month = month;
        this.year = year;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRenter() {
        return idRenter;
    }

    public void setIdRenter(long idRenter) {
        this.idRenter = idRenter;
    }

    public int getRoomBill() {
        return roomBill;
    }

    public void setRoomBill(int roomBill) {
        this.roomBill = roomBill;
    }

    public int getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(int electricBill) {
        this.electricBill = electricBill;
    }

    public int getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(int waterBill) {
        this.waterBill = waterBill;
    }

    public int getInternetBill() {
        return internetBill;
    }

    public void setInternetBill(int internetBill) {
        this.internetBill = internetBill;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", this.id, this.idRenter, this.roomBill, this.electricBill, this.waterBill, this.internetBill, this.totalBill, this.month, this.year, DateUtils.formatLocalDate(this.createAt));
    }
}
