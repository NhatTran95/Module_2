package view;

import model.Room;
import service.RoomService;

import java.util.List;
import java.util.Scanner;

public class RoomView {
    public static Scanner scanner = new Scanner(System.in);
    private RoomService roomService;
    public RoomView(){
        roomService = new RoomService();
    }
    public void laucher(){
        do {
            System.out.println("* * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*            QUẢN LÝ PHÒNG              *");
            System.out.println("*   Nhập 1. Xem danh sách phòng         *");
            System.out.println("*   Nhập 2. Cập nhật giá phòng          *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Nhập lựa chọn của bạn:");
            boolean check1;
            do {
                check1 = false;
                try {
                    int actionMenuRoom = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuRoom) {
                        case 1:
                            showListRoom(roomService.getAllRoom());
                            break;
                        case 2:
                            updatePriceRoom();
                            break;
                        default:
                            System.out.println("Vui lòng nhập 1 hoặc 2!");
                            check1 =true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập 1 hoặc 2!");
                    check1 = true;
                }

            }while (check1);
            boolean check2;
            do {
                check2 = false;
                System.out.println("Bạn có muốn tiếp tục mục quản lý phòng không?");
                System.out.println("Nhâp 1. Tiếp tục");
                System.out.println("Nhâp 2. Không");
                try{
                    int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuContinue){
                        case 1:
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Vui lòng nhập 1 hoặc 2!");
                            check2 = true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập 1 hoặc 2!");
                    check2 = true;
                }
            }while (check2);

        }while (true);

    }

    public void updatePriceRoom(){
        showListRoom(roomService.getAllRoom());
        do {
            System.out.println("Nhập ID phòng cần thay đổi giá hoặc Enter để quay lại:");
            String strId = scanner.nextLine();
            if(strId.equals("")) return;
            try{
                long idRoomUpdate = Long.parseLong(strId);
                Room roomUpdate = roomService.findRoomById(idRoomUpdate);
                if(roomUpdate == null){
                    System.out.println("Phòng không tồn tại!");
                }else {
                    inputNewPrice(roomUpdate);
                    roomService.updatePriceRoomById(idRoomUpdate, roomUpdate);
                    break;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập id phòng là số");
            }

        }while (true);
        showListRoom(roomService.getAllRoom());
    }
    public void inputNewPrice(Room roomUpdate) {
        do {
            System.out.println("Nhập 1. Thay đổi giá phòng");
            System.out.println("Nhập 2. Thay đổi giá điện");
            System.out.println("Nhập 3. Thay đổi giá nước");
            System.out.println("Nhập 4. Thay đổi giá internet");
            try {
                int actionMenu = Integer.parseInt(scanner.nextLine());
                switch (actionMenu) {
                    case 1:
                        inputPriceRoom(roomUpdate);
                        break;
                    case 2:
                        inputPriceElectric(roomUpdate);
                        break;
                    case 3:
                        inputPriceWater(roomUpdate);
                        break;
                    case 4:
                        inputPriceInternet(roomUpdate);
                        break;
                    default:
                        System.out.println("Vui lòng nhập từ 1-4!");
                        continue;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập từ 1-4!");
                continue;
            }
            boolean check;
            do {
                check = false;
                System.out.println("Bạn có muốn tiếp tục thay đổi những giá khác không?");
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
                            System.out.println("Vui lòng nhập 1 hoặc 2!");
                            check = true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập 1 hoặc 2!");
                    check = true;
                }

            }while (check);

        }while (true);
    }
    public void inputPriceRoom(Room room){
        do {
            try {
                System.out.printf("Nhập giá phòng mới:\n");
                int roomPr = Integer.parseInt(scanner.nextLine());
                room.setPriceRoom(roomPr);
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Nhập sai vui lòng nhập vào một số");
            }
        }while (true);
    }
    public void inputPriceElectric(Room room){
        do {
            try {
                System.out.printf("Nhập giá điện mới:\n");
                int electricPr = Integer.parseInt(scanner.nextLine());
                room.setPriceElectric(electricPr);
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Nhập sai vui lòng nhập vào một số");
            }
        }while (true);
    }
    public void inputPriceWater(Room room){
        do {
            try {
                System.out.printf("Nhập giá phòng mới:\n");
                int waterPr = Integer.parseInt(scanner.nextLine());
                room.setPriceWater(waterPr);
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Nhập sai vui lòng nhập vào một số");
            }
        }while (true);
    }
    public void inputPriceInternet(Room room){
        do {
            try {
                System.out.printf("Nhập giá phòng mới:\n");
                int internetPr = Integer.parseInt(scanner.nextLine());
                room.setPriceInternet(internetPr);
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Nhập sai vui lòng nhập vào một số");
            }
        }while (true);
    }

    public void showListRoom(List<Room> rooms) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.printf("* %35s %-56s  *\n", " ", "DANH SÁCH PHÒNG");
        System.out.printf("* %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-15s *\n", "ID PHÒNG", "TÊN PHÒNG", "TRẠNG THÁI", "GIÁ PHÒNG", "GIÁ ĐIỆN", "GIÁ NƯỚC", "GIÁ INTERNET");
        for (int i = 0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            System.out.printf("* %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-15s *\n", room.getIdRoom(), room.getNameRoom(), room.isStatusRoom(), room.getPriceRoom(), room.getPriceElectric(), room.getPriceWater(), room.getPriceInternet());
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static void main(String[] args) {
        RoomView roomView = new RoomView();
        roomView.laucher();
    }
}
