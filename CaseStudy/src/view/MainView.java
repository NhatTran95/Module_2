package view;

import org.omg.CORBA.MARSHAL;
import service.LogInService;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class MainView {
    private static Scanner scanner = new Scanner(System.in);
    private RoomView roomView;
    private RenterView renterView;
    private TransactionView transactionView;
    private static LogInService logInService;
    public MainView(){
        roomView = new RoomView();
        renterView = new RenterView();
        transactionView = new TransactionView();
        logInService = new LogInService();
    }
    public void laucher(){
        do {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*      CHÀO MỪNG BẠN ĐẾN VỚI NHÀ TRỌ THIÊN ĐƯỜNG      *");
            System.out.println("*           NHẬP 1. QUẢN LÝ PHÒNG                     *");
            System.out.println("*           NHẬP 2. QUẢN LÝ NGƯỜI THUÊ                *");
            System.out.println("*           NHẬP 3. QUẢN LÝ DOANH THU                 *");
            System.out.println("*           NHẬP 4. THAY ĐỔI TÀI KHOẢN ĐĂNG NHẬP      *");
            System.out.println("*           NHẬP 5. THOÁT CHƯƠNG TRÌNH                *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Nhập lựa chọn của bạn");
            boolean checkInput;
            do {
                checkInput = false;
                try {
                    int actionMenu = Integer.parseInt(scanner.nextLine());
                    switch (actionMenu) {
                        case 1:
                            roomView.laucher();
                            break;
                        case 2:
                            renterView.laucher();
                            break;
                        case 3:
                            transactionView.laucher();
                            break;
                        case 4:
                            logInService.updateLogIn();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Vui lòng nhập 1 hoặc 2, 3, 4, 5!");
                            checkInput =true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập 1 hoặc 2, 3, 4, 5!");
                    checkInput = true;
                }


            }while (checkInput);
            boolean checkContinue;
            do {
                checkContinue = false;
                System.out.println("Bạn có muốn tiếp tục chương trình quản lý nhà trọ Thiên Đường không?");
                System.out.println("Nhâp 1. Tiếp tục");
                System.out.println("Nhâp 2. Không");
                try{
                    int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuContinue){
                        case 1:
                            break;
                        case 2:
                            System.out.println("NHÀ TRỌ THIÊN ĐƯỜNG TẠM BIỆT BẠN!!! SEE YOU AGAIN!");
                            return;
                        default:
                            System.out.println("Vui lòng nhập 1 hoặc 2!");
                            checkContinue = true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập 1 hoặc 2!");
                    checkContinue = true;
                }
            }while (checkContinue);
        }while (true);

    }

    public static void main(String[] args) {
        MainView mainView = new MainView();
        logInService.logIn();
        mainView.laucher();
    }
}
