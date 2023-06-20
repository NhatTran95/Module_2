package view;

import model.Renter;
import model.Room;
import service.RenterService;
import service.RoomService;
import utils.DateUtils;
import utils.ValidateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RenterView {
    private static final int INPUT_ADD = 1;
    private static final int INPUT_EDIT = 2;
    public static Scanner scanner = new Scanner(System.in);
    private static RenterService renterService;
    private static RoomService roomService;
    private static RoomView roomView;
    public RenterView(){
        renterService = new RenterService();
        roomService = new RoomService();
        roomView = new RoomView();
    }

    public void addRenter() {
        showListRenter(renterService.getAllRenter());
        roomView.showListRoom(roomService.getAllRoom());
        Renter renterAdd = new Renter();
        do {
            System.out.println("Nhập id phòng đang trống hoặc Enter để quay lại:");
            String strId = scanner.nextLine();
            if(strId.equals("")) return;
            int id;
            try {
                id = Integer.parseInt(strId);
                Room roomAdd = roomService.findRoomById(id);
                if(roomAdd == null){
                    System.out.println("Phòng không tồn tại!");
                }else if (roomAdd.isStatusRoom()){
                    System.out.println("Phòng đã có người thuê");
                }
                else {
                    renterAdd.setIdRenter(System.currentTimeMillis()%1000);
                    renterAdd.setIdRoom(id);
                    roomService.updateStatusRoomById(id);
                    break;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập id là số");
            }
        }while (true);
        LocalDate date = LocalDate.now();
        renterAdd.setDateRent(date);
        inputRenter(INPUT_ADD, renterAdd);
        renterService.addRenter(renterAdd);
        showListRenter(renterService.getAllRenter());
    }
    public void updateRenter(){
        showListRenter(renterService.getAllRenter());
        Renter renterEdit;
        int id;
        do {
            System.out.println("Nhập ID người thuê cần sửa thông tin hoặc Enter để quay lại:");
            String strId = scanner.nextLine();
            if(strId.equals("")) return;
            try {
                id = Integer.parseInt(strId);
                renterEdit = renterService.findRenterById(id);
                if(renterEdit == null){
                    System.out.println("Người thuê không tồn tại!");
                }
                else {
                    inputRenter(INPUT_EDIT, renterEdit);
                    break;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập id là số");
            }

        }while (true);
        renterService.updateRenterById(id, renterEdit);
        showListRenter(renterService.getAllRenter());
    }
    public void deleteRenter(){
        showListRenter(renterService.getAllRenter());
        do {
            System.out.println("Nhập ID người thuê cần xóa hoặc Enter để quay lại:");
            String strId = scanner.nextLine();
            if(strId.equals("")) return;
            int id;
            try {
                id = Integer.parseInt(strId);
                Renter renterDelete = renterService.findRenterById(id);
                if(renterDelete == null){
                    System.out.println("Người thuê không tồn tại!");
                }else {
                    renterService.deleteRenterById(id);
                    roomService.updateStatusRoomById(renterDelete.getIdRoom());
                    showListRenter(renterService.getAllRenter());
                    break;
                }
            }catch (NumberFormatException numberFormatException){
                System.out.println("Vui lòng nhập id là số");
            }
        }while (true);

    }
    public void inputRenter(int ACTION, Renter renter){
        String strACTION = ACTION == INPUT_ADD ? "" : " mới";
        inputNameRenter(strACTION, ACTION, renter);
        inputDateOfBirthRenter(strACTION, ACTION, renter);
        inputPhoneRenter(strACTION, ACTION, renter);
        inputHometownRenter(strACTION, ACTION, renter);
        inputCCCDRenter(strACTION, ACTION, renter);
        inputDeposits(strACTION, ACTION, renter);
    }

    private void inputDeposits(String strACTION, int action, Renter renter) {
        if(action == INPUT_ADD){
            do {
                int deposits;
                System.out.printf("Nhập tiền cọc%s:\n",strACTION);
                try {
                    deposits = Integer.parseInt(scanner.nextLine());
                    renter.setDeposist(deposits);
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Nhập sai vui lòng nhập vào một số");
                }
            }while (true);
        } else {
            do {
                int deposits;
                System.out.printf("Nhập tiền cọc%s hoặc Enter để bỏ qua:\n",strACTION);
                String strDep = scanner.nextLine();
                if(strDep.equals("")) break;
                try {
                    deposits = Integer.parseInt(strDep);
                    renter.setDeposist(deposits);
                    break;
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Nhập sai vui lòng nhập vào một số");
                }
            }while (true);
        }

    }

    private void inputPhoneRenter(String strACTION, int ACTION, Renter renter) {
        if(ACTION == INPUT_ADD){
            do{
                System.out.printf("Nhập số điện thoại%s hoặc Enter để bỏ qua \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidRenterPhone(phone)) {
                    if (phone.equals("")) {
                        renter.setPhone("");
                        break;
                    }
                    System.out.println("Nhập không hợp lệ. Số điện thoại gồm 10 số và bắt đầu là số 0");
                }else {
                    renter.setPhone(phone);
                    break;
                }
            }while (true);
        }else {
            do{
                System.out.printf("Nhập số điện thoại%s hoặc Enter để bỏ qua \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidRenterPhone(phone)) {
                    if (phone.equals("")) {
                        break;
                    }
                    System.out.println("Nhập không hợp lệ. Số điện thoại gồm 10 số và bắt đầu là số 0");
                }else {
                    renter.setPhone(phone);
                    break;
                }
            }while (true);
        }
    }

    private void inputHometownRenter(String strACTION, int ACTION, Renter renter) {
        if(ACTION == INPUT_ADD){
            do{
                System.out.printf("Nhập quê quán%s hoặc Enter để bỏ qua \n", strACTION);
                String hometown = scanner.nextLine();
                if (!ValidateUtils.isValidRenterHometown(hometown)) {
                    if (hometown.equals("")) {
                        renter.setHometown("");
                        break;
                    }
                    System.out.println("Nhập không hợp lệ. Phải viết hoa tất cả các từ");
                }else {
                    renter.setHometown(hometown);
                    break;
                }
            }while (true);
        }else {
            do{
                System.out.printf("Nhập quê quán%s hoặc Enter để bỏ qua \n", strACTION);
                String hometown = scanner.nextLine();
                if (!ValidateUtils.isValidRenterHometown(hometown)) {
                    if (hometown.equals("")) {
                        break;
                    }
                    System.out.println("Nhập không hợp lệ. Phải viết hoa tất cả các từ");
                }else {
                    renter.setHometown(hometown);
                    break;
                }
            }while (true);
        }
    }

    private void inputCCCDRenter(String strACTION, int ACTION, Renter renter) {
        if(ACTION == INPUT_ADD){
            do{
                System.out.printf("Nhập số CCCD%s hoặc Enter để bỏ qua \n", strACTION);
                String cccd = scanner.nextLine();
                if (!ValidateUtils.isValidRenterCCCD(cccd)) {
                    if (cccd.equals("")) {
                        renter.setCitizenIdentification("");
                        break;
                    }
                    System.out.println("Số CCCD không hợp lệ. CCCD là 12 chữ số, bắt đầu là số 0");
                }else {
                    renter.setCitizenIdentification(cccd);
                    break;
                }
            }while (true);
        }else {
            do{
                System.out.printf("Nhập số CCCD%s hoặc Enter để bỏ qua \n", strACTION);
                String cccd = scanner.nextLine();
                if (!ValidateUtils.isValidRenterCCCD(cccd)) {
                    if (cccd.equals("")) {
                        break;
                    }
                    System.out.println("Số CCCD không hợp lệ. CCCD là 12 chữ số, bắt đầu là số 0");
                }else {
                    renter.setCitizenIdentification(cccd);
                    break;
                }
            }while (true);
        }
    }

    private void inputDateOfBirthRenter(String strACTION, int ACTION, Renter renter) {
        if(ACTION == INPUT_ADD){
            do{
                System.out.printf("Nhập ngày sinh%s hoặc Enter để bỏ qua \n", strACTION);
                String birthday = scanner.nextLine();
                if (!ValidateUtils.isValidRenterBirth(birthday)) {
                    if (birthday.equals("")) {
                        renter.setDateOfBirth("");
                        break;
                    }
                    System.out.println("Ngày sinh không hợp lệ. Phải theo dạng dd/MM/yyyy");
                }else {
                    renter.setDateOfBirth(birthday);
                    break;
                }
            }while (true);
        }else {
            do{
                System.out.printf("Nhập địa ngày sinh%s hoặc Enter để bỏ qua \n", strACTION);
                String birthday = scanner.nextLine();
                if (!ValidateUtils.isValidRenterBirth(birthday)) {
                    if (birthday.equals("")) {
                        break;
                    }
                    System.out.println("Ngày sinh không hợp lệ. Phải theo dạng dd/MM/yyyy");
                }else {
                    renter.setDateOfBirth(birthday);
                    break;
                }
            }while (true);
        }
    }

    private void inputNameRenter(String strACTION, int ACTION, Renter renter) {
        if(ACTION == INPUT_ADD){
            do {
                System.out.printf("Nhập tên%s:\n", strACTION);
                String name = scanner.nextLine();
                if(!ValidateUtils.isValidRenterName(name)){
                    System.out.println("Tên không hợp lệ. Tên gồm các kí tự chữ và viết hoa kí tự đầu tiên mỗi từ");
                }else {
                    renter.setNameRenter(name);
                    break;
                }
            }while (true);
        }else{
            do {
                System.out.printf("Nhập tên%s hoặc Enter để bỏ qua\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidRenterName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ. Tên gồm các kí tự chữ và viết hoa kí tự đầu tiên mỗi từ");
                }else {
                    renter.setNameRenter(name);
                    break;
                }
            } while (true);
        }
    }
    private void sortRenterByDateRent() {
        List<Renter> renters = renterService.getAllRenter();
        renters.sort(new Comparator<Renter>() {
            @Override
            public int compare(Renter o1, Renter o2) {
                return o1.getDateRent().compareTo(o2.getDateRent());
            }
        });
        showListRenter(renters);
    }
    private void searchRenterByNameView() {
        do {
            System.out.println("Nhập tên cần tìm: ");
            String key = scanner.nextLine();
            if(!ValidateUtils.isValidFindName(key)){
                System.out.println("Vui lòng nhập tên là chữ!");
            }else {
                List<Renter> rentersSearched = renterService.searchRenterByName(key);
                if (rentersSearched.size() == 0){
                    System.out.println("Tên người thuê không tồn tại!");
                }else {
                    showListRenter(rentersSearched);
                    break;
                }
            }
        }while (true);

    }
    private void searchRenterByRangeDateView() {
        LocalDate d1 = null;
        LocalDate d2 = null;
        boolean check;
        do {
            check = false;
            System.out.println("Nhập thời gian bắt đầu: (dd-MM-yyyy)");
            String d1Str = scanner.nextLine();
            if(!ValidateUtils.isValidDateRent(d1Str)){
                System.out.println("Vui lòng nhập đúng định dạng");
                check = true;
                continue;
            }
            else d1 = DateUtils.parseStrLocalDate(d1Str);
            do {
                System.out.println("Nhập thời gian kết thúc: (dd-MM-yyyy)");
                String d2Str = scanner.nextLine();
                if(!ValidateUtils.isValidDateRent(d2Str)){
                    System.out.println("Vui lòng nhập đúng định dạng");
                }
                else {
                    d2 = DateUtils.parseStrLocalDate(d2Str);
                    break;
                }
            }while (true);

        }while (check);

        List<Renter> rentersSearched = renterService.searchRenterByRangeDate(d1, d2);

        showListRenter(rentersSearched);
    }
    public void laucher(){
        do {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*               QUẢN LÝ NGƯỜI THUÊ PHÒNG                *");
            System.out.println("*   Nhập 1. Xem danh sách người thuê phòng              *");
            System.out.println("*   Nhập 2. Thêm thông tin người thuê mới               *");
            System.out.println("*   Nhập 3. Sửa thông tin người thuê                    *");
            System.out.println("*   Nhập 4. Xóa thông tin người thuê                    *");
            System.out.println("*   Nhập 5. Sắp xếp người thuê theo ngày tháng thuê     *");
            System.out.println("*   Nhập 6. Tìm người thuê theo tên                     *");
            System.out.println("*   Nhập 7. Tìm người thuê theo khoảng thời gian        *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Nhập lựa chọn của bạn:");
            boolean check2;
            do {
                check2 = false;
                try{
                    int actionMenuRenter = Integer.parseInt(scanner.nextLine());
                    switch (actionMenuRenter) {
                        case 1:
                            showListRenter(renterService.getAllRenter());
                            break;
                        case 2:
                            addRenter();
                            break;
                        case 3:
                            updateRenter();
                            break;
                        case 4:
                            deleteRenter();
                            break;
                        case 5:
                            sortRenterByDateRent();
                            break;
                        case 6:
                            searchRenterByNameView();
                            break;
                        case 7:
                            searchRenterByRangeDateView();
                            break;
                        default:
                            System.out.println("Vui lòng nhập số từ 1-7!");
                            check2 = true;
                    }
                }catch (NumberFormatException numberFormatException){
                    System.out.println("Vui lòng nhập số từ 1-7!");
                    check2 = true;
                }
            }while (check2);
            boolean check3;
            do {
                check3 =false;
                System.out.println("Bạn có muốn tiếp tục mục quản lý người thuê không?");
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
    public void showListRenter(List<Renter> renters){
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.printf("* %50s %-77s  *\n", " ", "DANH SÁCH NGƯỜI THUÊ PHÒNG");
        System.out.printf("* %-10s | %-10s | %-20s | %-10s | %-10S | %-10S | %-15S | %-10s | %-10s *\n",
                "IDRENTER", "IDROOM", "TÊN NGƯỜI THUÊ", "NGÀY SINH", "PHONE","QUÊ QUÁN","SỐ CCCD","NGÀY THUÊ","TIỀN CỌC");
        for (int i = 0; i<renters.size(); i++){
            Renter renter = renters.get(i);
            String dateView = DateUtils.formatLocalDate(renter.getDateRent());
            System.out.printf("* %-10s | %-10s | %-20s | %-10s | %-10S | %-10S | %-15S | %-10s | %-10s *\n",
                    renter.getIdRenter(), renter.getIdRoom(), renter.getNameRenter(), renter.getDateOfBirth(), renter.getPhone(),
                    renter.getHometown(), renter.getCitizenIdentification(), dateView, renter.getDeposist());
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static void main(String[] args) {
        RenterView renterView = new RenterView();
        renterView.laucher();
    }
}
