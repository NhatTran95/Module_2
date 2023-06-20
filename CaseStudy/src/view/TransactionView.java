package view;

import model.Renter;
import model.Room;
import model.Transaction;
import service.RenterService;
import service.RoomService;
import service.TransactionService;
import utils.DateUtils;
import utils.ValidateUtils;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionView {
    private final int onTime = 1;
    private final int outOfDate = 2;
    public static Scanner scanner = new Scanner(System.in);
    private TransactionService transactionService;
    private RenterService renterService;
    private RenterView renterView;
    private RoomService roomService;
    public TransactionView(){
        transactionService = new TransactionService();
        renterService = new RenterService();
        renterView = new RenterView();
        roomService = new RoomService();
    }
    public void addTransaction(int time){
        showTransactions(transactionService.getAllTransaction());
        renterView.showListRenter(renterService.getAllRenter());
        Transaction transaction = new Transaction();
        inputTransaction(transaction, time);
        if(transaction.getCreateAt() == null) return;
        transactionService.addTransaction(transaction);
        showTransactions(transactionService.getAllTransaction());
    }
    public void inputTransaction(Transaction transaction, int time){
        Room room;
        Renter renter;
        do {
            System.out.println("Nhập ID người thuê hoặc Enter để quay lại:");
            String strId = scanner.nextLine();
            if(strId.equals("")) return;
            try{
                long id = Long.parseLong(strId);
                renter = renterService.findRenterById(id);
                if(renter == null){
                    System.out.println("Người thuê không tồn tại!");
                } else {
                    transaction.setId(System.currentTimeMillis()%100000);
                    transaction.setIdRenter(id);
                    long idRoom = renter.getIdRoom();
                     room = roomService.findRoomById(idRoom);

                    break;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập ID là số!");
            }

        }while (true);
        int totalBill = 0;
        if(time == onTime){
            do {
                try{
                    System.out.println("Nhập số điện cũ:");
                    int electOld = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập số điện mới:");
                    int electNew = Integer.parseInt(scanner.nextLine());
                    int electBill = (electNew - electOld)* room.getPriceElectric();
                    transaction.setElectricBill(electBill);
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập số");
                }
            }while (true);
            do {
                try{
                    System.out.println("Nhập số nước cũ:");
                    int waterOld = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập số nước mới:");
                    int waterNew = Integer.parseInt(scanner.nextLine());
                    int waterBill = (waterNew - waterOld)*room.getPriceWater();
                    transaction.setWaterBill(waterBill);
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập số");
                }
            }while (true);
            totalBill = transaction.getRoomBill()+transaction.getInternetBill()+transaction.getElectricBill()+transaction.getWaterBill();
            transaction.setRoomBill(room.getPriceRoom());
            transaction.setInternetBill(room.getPriceInternet());
        }else {
            totalBill = renter.getDeposist();
            transaction.setRoomBill(0);
            transaction.setInternetBill(0);
        }

        transaction.setTotalBill(totalBill);
        transaction.setCreateAt(LocalDate.now());
        transaction.setYear(Integer.toString(transaction.getCreateAt().getYear()));
        transaction.setMonth(Integer.toString(transaction.getCreateAt().getMonthValue()-1));

    }

    public void laucher(){
        do {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*               QUẢN LÝ DOANH THU PHÒNG TRỌ                   *");
            System.out.println("*   Nhập 1. Xem danh sách tất cả doanh thu                    *");
            System.out.println("*   Nhập 2. Thêm doanh thu mới                                *");
            System.out.println("*   Nhập 3. Xem tổng doanh thu của mỗi tháng                  *");
            System.out.println("*   Nhập 4. Đánh giá doanh thu tháng sau so với tháng trước   *");
            System.out.println("*   Nhập 5. Xem quy định                                      *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Nhập lựa chọn của bạn:");
            boolean check2;
            do {
                check2 = false;
                try{
                    int actionMenuRenter = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuRenter) {
                        case 1:
                            showTransactions(transactionService.getAllTransaction());
                            break;
                        case 2:
                            System.out.println("Nhập 1. Người thuê đóng tiền đúng hạn");
                            System.out.println("Nhập 2. Người thuê đóng tiền quá hạn (bị mất cọc và phải trả phòng)");
                            boolean check;
                            do {
                                check = false;
                                System.out.println("Nhập lựa chọn của bạn:");
                                try{
                                    int choose = Integer.parseInt(scanner.nextLine());
                                    switch (choose){
                                        case 1:
                                            addTransaction(onTime);
                                            break;
                                        case 2:
                                            addTransaction(outOfDate);
                                            break;
                                        default:
                                            System.out.println("Nhập 1 hoặc 2!");
                                            check = true;
                                    }
                                }catch (NumberFormatException numberFormatException){
                                    System.out.println("Nhập 1 hoặc 2!");
                                    check = true;
                                }
                            }while (check);
                            break;
                        case 3:
                            do {
                                System.out.println("Nhập tháng muốn xem doanh thu");
                                String month = scanner.nextLine();
                                if(!ValidateUtils.isValidMonth(month)) {
                                    System.out.println("Nhập tháng từ 1 đến 12");
                                    continue;
                                }
                                String year;
                                do {
                                    System.out.println("Nhập năm");
                                    year = scanner.nextLine();
                                    if(ValidateUtils.isValidYear(year)) break;
                                    else  System.out.println("Năm có 4 chữ số bắt đầu từ 2000");
                                }while (true);

                                List<Transaction> transactions = findTransactionsByMonth(month, year);
                                if(transactions.size() == 0){
                                    System.out.printf("Tháng %s/%s không có doanh thu \n", month, year);
                                }else {
                                    showTransactions(transactions);
                                    showTransactionsByMonnth(transactions);
                                    break;
                                }
                            }while (true);
                            break;
                        case 4:
                            revenueAssessment();
                            break;
                        case 5:
                            System.out.println("QUY ĐỊNH:");
                            System.out.println();
                            System.out.println("Khi thuê phòng nguời thuê phải đóng tiền cọc theo quy định trong hợp đồng.\n" +
                                    "Ngày 01 hàng tháng sẽ thu tiền phòng của tháng trước đó.\n" +
                                    "Nếu người thuê đóng trễ quá 5 ngày (hạn cuối là ngày 5) sẽ buộc phải trả phòng và mất tiền cọc theo quy định ghi rõ trong hợp đồng.\n" +
                                    "Khi người thuê trả phòng đúng quy định sẽ được trả lại tiền cọc theo hợp đồng.");
                            System.out.println();
                            break;
                        default:
                            System.out.println("Vui lòng nhập số từ 1-5!");
                            check2 = true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập số từ 1-5!");
                    check2 = true;
                }
            }while (check2);
            boolean check3;
            do {
                check3 =false;
                System.out.println("Bạn có muốn tiếp tục mục quản lý doanh thu không?");
                System.out.println("Nhâp 1. Tiếp tục");
                System.out.println("Nhâp 2. Không");
                try {
                    int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuContinue){
                        case 1:
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Vui lòng nhập lại!");
                            check3= true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Hãy nhập 1 hoặc 2");
                    check3 =true;
                }


            }while (check3);

        }while (true);

    }
    public void revenueAssessment(){
        float total1 = 0;
        float total2 = 0;
        String m1;
        String m2;
        String year;
        do {
            System.out.println("Nhập năm");
            year = scanner.nextLine();
            if(!ValidateUtils.isValidYear(year)){
                System.out.println("Năm có 4 chữ số bắt đầu từ 2000");
                continue;
            }
            do {
                System.out.println("Nhập tháng thứ nhất");
                m1 = scanner.nextLine();
                if(ValidateUtils.isValidMonth(m1)) break;
                else System.out.println("Nhập tháng từ 1 đến 12");
            }while (true);

            List<Transaction> transactions = findTransactionsByMonth(m1, year);
            if(transactions.size() == 0){
                System.out.printf("Tháng %s/%s không có doanh thu \n", m1, year);
            }else {
                showTransactionsByMonnth(transactions);
                for(int i = 0; i < transactions.size(); i++){
                    total1 += transactions.get(i).getTotalBill();
                }
                break;
            }
        }while (true);
        do {
            System.out.println("Nhập tháng thứ hai");
            m2 = scanner.nextLine();
            if(!ValidateUtils.isValidMonth(m2)) {
                System.out.println("Nhập tháng từ 1 đến 12");
                continue;
            }
            List<Transaction> transactions = findTransactionsByMonth(m2, year);
            if(transactions.size() == 0){
                System.out.printf("Tháng %s/%s không có doanh thu \n", m2, year);
            }else {
                showTransactionsByMonnth(transactions);
                for(int i = 0; i < transactions.size(); i++){
                    total2 += transactions.get(i).getTotalBill();
                }
                break;
            }
        }while (true);
        if(total2 >= total1) {
            System.out.printf("Doanh thu tháng %s/%s tăng trưởng %s phần trăm so với tháng %s\n", m2,year, (total2-total1)/total1*100, m1 );
        }else System.out.printf("Doanh thu tháng %s/%s giảm %s phần trăm so với tháng %s\n", m2,year, (total1-total2)/total1*100, m1 );

    }
    public List<Transaction> findTransactionsByMonth(String month, String year){
        List<Transaction> transactions = transactionService.getAllTransaction();
        List<Transaction> results = new ArrayList<>();
        for(Transaction t : transactions){
            if(t.getMonth().equals(month) && t.getYear().equals(year)){
                results.add(t);
            }
        }
        return results;
    }
    public void showTransactionsByMonnth(List<Transaction> transactionList){
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.printf("* %10s %-34s *\n", " ", "TỔNG DOANH THU THÁNG");
        System.out.printf("* %-10s | %-10s | %-19s *\n", "YEAR", "MONTH", "TOTAL");
        int total = 0;
        for(int i = 0; i < transactionList.size(); i++){
            total += transactionList.get(i).getTotalBill();
        }
            Transaction transaction = transactionList.get(0);
            System.out.printf("* %-10s | %-10s | %-19s *\n", transaction.getYear(), transaction.getMonth(), total);
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
    }
    public void showTransactions(List<Transaction> transactionList){
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.printf("* %50s %-71s  *\n", " ", "DOANH THU PHÒNG TRỌ");
        System.out.printf("* %-8s | %-8s | %-10s | %-10s | %-10S | %-10S | %-10S | %-10s | %-10s | %-10s *\n",
                "ID", "IDRENTER", "TIỀN PHÒNG", "TIỀN ĐIỆN", "TIỀN NƯỚC","TIỀN MẠNG","TỔNG TIỀN","THÁNG","NĂM","NGÀY THU");
        Transaction transaction = null;
        for (int i = 0; i<transactionList.size(); i++){
            transaction  = transactionList.get(i);
            String dateView = DateUtils.formatLocalDate(transaction.getCreateAt());
            System.out.printf("* %-8s | %-8s | %-10s | %-10s | %-10S | %-10S | %-10S | %-10s | %-10s | %-10s *\n",
                   transaction.getId(), transaction.getIdRenter(), transaction.getRoomBill(), transaction.getElectricBill(), transaction.getWaterBill(),
                    transaction.getInternetBill(),transaction.getTotalBill(), transaction.getMonth(), transaction.getYear(), dateView);
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static void main(String[] args) {
        TransactionView transactionView = new TransactionView();
        transactionView.laucher();
    }
}
