package exercise.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerOfficer {
    public Scanner scanner = new Scanner(System.in);
    private Officer[] officers;

    public ManagerOfficer() {
        officers = new Officer[5];
        officers[0] = new Engineer(1, "Nhân", 29, "Nam", "28NTP", "Bằng Đh tphcm");
        officers[1] = new Worker(2, "Bảo", 22, "Nam", "28NTP", 8);
        officers[2] = new Staff(3, "Minh", 27, "Nam", "28NTP", "IT");
        officers[3] = new Engineer(4, "Nhật", 28, "Nam", "28NTP", "Bằng Đh đn");
        officers[4] = new Worker(5, "Hiếu", 24, "Nam", "28NTP", 9);
        showOfficers(officers);
        addOfficerView();
        editOfficerView();
        showOfficers(officers);
        comparatorByAge();
        comparatorByName();
        deleteOfficerView();
        showOfficers(officers);



    }

    public static void main(String[] args) {
        ManagerOfficer managerOfficer = new ManagerOfficer();
    }

    public void inputBasicInfo(Officer officer) {
        officer.setId(System.currentTimeMillis());
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        officer.setName(name);
        officer.setAge(age);
        officer.setGender(gender);
        officer.setAddress(address);

    }

    public Officer[] addOfficer(Officer officer) {
        Officer[] officersNew = Arrays.copyOf(officers, officers.length + 1);
        officersNew[officersNew.length - 1] = officer;
        return officersNew;
    }

    public void showOfficers(Officer[] officers) {
        for (Officer officer : officers) {
            System.out.println(officer);
        }
    }

    public void addOfficerView() {
        System.out.println("Thêm mới cán bộ: ");
        System.out.println("Bạn muốn thêm cán bộ loại nào: ");
        System.out.println("Nhập 1. Worker");
        System.out.println("Nhập 2. Engineer");
        System.out.println("Nhập 3. Staff");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        Officer officer = null;
        switch (actionMenu) {
            case 1:
                officer = new Worker();
                inputBasicInfo(officer);
                System.out.println("Nhập level: ");
                int level = Integer.parseInt(scanner.nextLine());
                ((Worker) officer).setLevel(level);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
            case 2:
                officer = new Engineer();
                inputBasicInfo(officer);
                System.out.println("Nhập bằng cấp: ");
                String branch = scanner.nextLine();
                ((Engineer) officer).setBranch(branch);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
            case 3:
                officer = new Staff();
                inputBasicInfo(officer);
                System.out.println("Nhập công việc: ");
                String task = scanner.nextLine();
                ((Staff) officer).setTask(task);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
        }
    }

    public void comparatorByAge() {
        System.out.println("Sắp xếp cán bộ theo tuổi");
        Comparator comparatorByAge = new ComparatorByAge();
        Arrays.sort(officers, comparatorByAge);
        showOfficers(officers);
    }

    public void comparatorByName() {
        System.out.println("Sắp xếp cán bộ theo tên");
        Comparator comparatorByName = new ComparatorByName();
        Arrays.sort(officers, comparatorByName);
        showOfficers(officers);
    }

    public void editOfficerView() {
        System.out.println("Sửa thông tin cán bộ: ");
        System.out.println("Nhập mã cán bộ muốn sửa: ");
        long id = Long.parseLong(scanner.nextLine());
        Officer officerEdit = null;
        for (Officer item : officers) {
            if (item.getId() == id) {
                officerEdit = item;
                break;
            }
        }
        if (officerEdit instanceof Worker) {
            showMenu(officerEdit);
            int actionMenuEditInfoWorker = Integer.parseInt(scanner.nextLine());
            inputNewInfo(actionMenuEditInfoWorker, id, officerEdit);
        }
        if (officerEdit instanceof Engineer) {
            showMenu(officerEdit);
            int actionMenuEditInfoEngineer = Integer.parseInt(scanner.nextLine());
            inputNewInfo(actionMenuEditInfoEngineer, id, officerEdit);
        }
        if (officerEdit instanceof Staff) {
            showMenu(officerEdit);
            int actionMenuEditInfoStaff = Integer.parseInt(scanner.nextLine());
            inputNewInfo(actionMenuEditInfoStaff, id, officerEdit);
        }
    }

//    public void editOfficesById(Officer[] officers, long idOffice, Officer o) {
//        for (Officer item : officers) {
//            if (item.getId() == idOffice) {
//                item.setName(o.getName());
//                item.setAddress(o.getAddress());
//                item.setAge(o.getAge());
//                item.setGender(o.getGender());
//                break;
//            }
//        }
//    }

    public void showMenu(Officer officer) {
        System.out.println("Chọn thông tin cần sửa: ");
        System.out.println("Nhập 1. Sửa tên");
        System.out.println("Nhập 2. Sửa tuổi");
        System.out.println("Nhập 3. Sửa địa chỉ");
        System.out.println("Nhập 4. Sửa giới tính");
        if (officer instanceof Worker) {
            System.out.println("Nhập 5. Sửa level");
        }
        if (officer instanceof Engineer) {
            System.out.println("Nhập 5. Sửa bằng cấp");
        }
        if (officer instanceof Staff) {
            System.out.println("Nhập 5. Sửa công viêc");
        }
    }
    public void inputNewInfo(int number, long id, Officer officerEdit){
        switch (number) {
            case 1:
                System.out.println("Nhập tên mới: ");
                String name = scanner.nextLine();
                officerEdit.setName(name);
//                editOfficesById(officers, id, officerEdit);
                break;
            case 2:
                System.out.println("Nhập tuổi mới: ");
                int Age = Integer.parseInt(scanner.nextLine());
                officerEdit.setAge(Age);
//                editOfficesById(officers, id, officerEdit);
                break;
            case 3:
                System.out.println("Nhập địa chỉ mới: ");
                String Address = scanner.nextLine();
                officerEdit.setAddress(Address);
//                editOfficesById(officers, id, officerEdit);
                break;
            case 4:
                System.out.println("Nhập giới tính mới: ");
                String gender = scanner.nextLine();
                officerEdit.setAddress(gender);
//                editOfficesById(officers, id, officerEdit);
                break;
            case 5:
                if(officerEdit instanceof Worker){
                    System.out.println("Nhập thông tin level mới: ");
                    int Level = Integer.parseInt(scanner.nextLine());
                    Worker worker = (Worker) officerEdit;
                    worker.setLevel(Level);
                    break;
                }
                if(officerEdit instanceof Engineer){
                    System.out.println("Nhập thông tin branch mới: ");
                    String branch = scanner.nextLine();
                    Engineer engineer = (Engineer) officerEdit;
                    engineer.setBranch(branch);
                    break;
                }
                if(officerEdit instanceof Staff){
                    System.out.println("Nhập thông tin task mới: ");
                    String task = scanner.nextLine();
                    Staff staff = (Staff) officerEdit;
                    staff.setTask(task);
                    break;
                }

        }
    }
    public void deleteOfficerView(){
        System.out.println("Xóa một cán bộ: ");
        System.out.println("Nhập mã cán bộ cần xóa");
        long id = Long.parseLong(scanner.nextLine());
        Officer officerDelete = null;
        int indexDel = 0;
        for(int i = 0; i < officers.length; i++){
            if(officers[i].getId() == id){
                indexDel = i;
                break;
            }
        }
        officers = deleteOfficer(indexDel);
    }
    public Officer[] deleteOfficer(int indexDel){
        int newLength = officers.length -1;
        Officer[] officersNew = new Officer[newLength];
        System.arraycopy(officers, 0, officersNew, 0, indexDel);
        System.arraycopy(officers, indexDel+1, officersNew, indexDel, newLength - indexDel);
        return officersNew;
    }

}


