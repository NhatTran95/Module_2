package model;

import utils.DateUtils;

import java.time.LocalDate;

public class Renter {
    private long idRenter;
    private long idRoom;
    private String nameRenter;
    private String dateOfBirth;
    private String citizenIdentification;
    private String hometown;
    private String phone;
    private LocalDate dateRent;
    private int deposist;

    public Renter() {
    }

    public Renter(long idRenter, long idRoom, String nameRenter, String dateOfBirth,  String phone, String hometown,String citizenIdentification, LocalDate dateRent, int deposist) {
        this.idRenter = idRenter;
        this.idRoom = idRoom;
        this.nameRenter = nameRenter;
        this.dateOfBirth = dateOfBirth;
        this.citizenIdentification = citizenIdentification;
        this.hometown = hometown;
        this.phone = phone;
        this.dateRent = dateRent;
        this.deposist = deposist;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public long getIdRenter() {
        return idRenter;
    }

    public void setIdRenter(long idRenter) {
        this.idRenter = idRenter;
    }

    public String getNameRenter() {
        return nameRenter;
    }

    public void setNameRenter(String nameRenter) {
        this.nameRenter = nameRenter;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateRent() {
        return dateRent;
    }

    public void setDateRent(LocalDate dateRent) {
        this.dateRent = dateRent;
    }

    public int getDeposist() {
        return deposist;
    }

    public void setDeposist(int deposist) {
        this.deposist = deposist;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", this.idRenter, this.idRoom, this.nameRenter,this.dateOfBirth, this.phone,this.hometown, this.citizenIdentification, DateUtils.formatLocalDate(this.dateRent),this.deposist);
    }
}
