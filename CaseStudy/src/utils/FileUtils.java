package utils;

import config.Config;
import model.LogIn;
import model.Renter;
import model.Room;
import model.Transaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readFile(String pathFile, String type){
        List<T> datas = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] items = line.split(",");
                switch (type){
                    case Config.TYPE_ROOM:
                        long idRoom = Long.parseLong(items[0]);
                        boolean statusRoom = Boolean.parseBoolean(items[2]);
                        int roomPrice = Integer.parseInt(items[3]);
                        int electricityPrice = Integer.parseInt(items[4]);
                        int waterPrice = Integer.parseInt(items[5]);
                        int internetPrice = Integer.parseInt(items[6]);
                        Room room = new Room(idRoom, items[1],statusRoom, roomPrice, electricityPrice, waterPrice, internetPrice);
                        datas.add((T) room);
                        break;
                    case Config.TYPE_RENTER:
                        long idRenter = Long.parseLong(items[0]);
                        long idRooms = Long.parseLong(items[1]);
                        int deposits = Integer.parseInt(items[8]);
                        LocalDate createAt = DateUtils.parseStrLocalDate(items[7]);
                        Renter renter = new Renter(idRenter,idRooms, items[2],items[3],items[4],items[5],items[6],createAt, deposits);
                        datas.add((T) renter);
                        break;
                    case Config.TYPE_TRANSACTION:
                        long id = Long.parseLong(items[0]);
                        long idRenters = Long.parseLong(items[1]);
                        int roomBill = Integer.parseInt(items[2]);
                        int electBill = Integer.parseInt(items[3]);
                        int waterBill = Integer.parseInt(items[4]);
                        int interBill = Integer.parseInt(items[5]);
                        int totalBill = Integer.parseInt(items[6]);
                        LocalDate createAtt = DateUtils.parseStrLocalDate(items[9]);
                        Transaction transaction = new Transaction(id, idRenters, roomBill, electBill, waterBill, interBill, totalBill, items[7], items[8],createAtt );
                        datas.add((T) transaction);
                        break;

                    case Config.TYPE_LOGIN:
                        LogIn logIn = new LogIn(items[0], items[1]);
                        datas.add((T) logIn);
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    public static <T> void writeFile(List<T> datas, String pathFile){
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(T item : datas){
                bufferedWriter.write(item.toString());
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
