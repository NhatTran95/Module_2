package service;

import config.Config;
import model.Renter;
import utils.DateUtils;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RenterService implements IRenterService{
    private final String pathRenter = "F:\\Module2\\CaseStudy\\data\\renter.csv";
    @Override
    public List<Renter> getAllRenter() {
        return FileUtils.readFile(pathRenter, Config.TYPE_RENTER);
    }

    @Override
    public Renter findRenterById(long idRenter) {
        List<Renter> renters = FileUtils.readFile(pathRenter, Config.TYPE_RENTER);
        for(Renter renter : renters){
            if(renter.getIdRenter()==idRenter){
                return renter;
            }
        }
        return null;
    }

    @Override
    public void addRenter(Renter renter) {
        List<Renter> renters = FileUtils.readFile(pathRenter, Config.TYPE_RENTER);
        renters.add(renter);
        FileUtils.writeFile(renters,pathRenter);
    }

    @Override
    public void updateRenterById(long idRenter, Renter renter) {
        List<Renter> renters = FileUtils.readFile(pathRenter, Config.TYPE_RENTER);
        for(Renter r : renters){
            if(r.getIdRenter() == idRenter){
                r.setNameRenter(renter.getNameRenter());
                r.setDateOfBirth(renter.getDateOfBirth());
                r.setHometown(renter.getHometown());
                r.setPhone(renter.getPhone());
                r.setCitizenIdentification(renter.getCitizenIdentification());
                r.setDateRent(renter.getDateRent());
                r.setDeposist(renter.getDeposist());
            }
        }
        FileUtils.writeFile(renters,pathRenter);
    }

    @Override
    public void deleteRenterById(long idRenter) {
        List<Renter> renters = FileUtils.readFile(pathRenter, Config.TYPE_RENTER);
        for(int i = 0; i < renters.size(); i++){
            if(renters.get(i).getIdRenter() == idRenter){
                renters.remove(i);
                break;
            }
        }
        FileUtils.writeFile(renters,pathRenter);
    }

    public List<Renter> searchRenterByName(String keyName) {
        List<Renter> renters = getAllRenter();
        List<Renter> results = new ArrayList<>();

        for (Renter r : renters) {
            if (r.getNameRenter().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(r);
            }
        }
        return results;
    }

    @Override
    public List<Renter> searchRenterByRangeDate(LocalDate d1, LocalDate d2) {
        List<Renter> renters = getAllRenter();
        List<Renter> results = new ArrayList<>();
        for(Renter r : renters){
            if(DateUtils.isDateInRange(r.getDateRent(), d1, d2)){
                results.add(r);
            }
        }
        return results;
    }
}
