package service;

import model.Renter;

import java.time.LocalDate;
import java.util.List;

public interface IRenterService {
    public List<Renter> getAllRenter();
    Renter findRenterById(long idRenter);
    void addRenter(Renter renter);
    void updateRenterById(long idRenter, Renter renter);
    void deleteRenterById(long idRenter);
    List<Renter> searchRenterByName(String keyName);

    List<Renter> searchRenterByRangeDate(LocalDate d1, LocalDate d2);
}
