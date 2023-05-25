package exercise.ex1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerOfficer {
    public Scanner scanner = new Scanner(System.in);
    private Officer[] officers;
    public ManagerOfficer(){
        officers = new Officer[5];
        officers[0] = new Engineer(1, "Nhân", 29, "Nam", "28NTP", "Bằng Đh tphcm");
        officers[1] = new Worker(2, "Bảo", 22, "Nam", "28NTP", 8);
        officers[2] = new Staff(3, "Minh", 27, "Nam", "28NTP", "IT");
        officers[3] = new Engineer(4, "Nhật", 28, "Nam", "28NTP", "Bằng Đh đn");
        officers[4] = new Worker(5, "Hiếu", 24, "Nam", "28NTP", 9);
/**
        System.out.println("Thêm mới cán bộ: ");
        System.out.println("Bạn muốn thêm cán bộ loại nào: ");
        System.out.println("Nhập 1. Worker");
        System.out.println("Nhập 2. Engineer");
        System.out.println("Nhập 3. Staff");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        Officer officer = null;
        switch (actionMenu){
            case 1:
                officer = new Worker();
                inputBasicInfo(officer);
                System.out.println("Nhập level: ");
                int level = Integer.parseInt(scanner.nextLine());
                ((Worker)officer).setLevel(level);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
            case 2:
                officer = new Engineer();
                inputBasicInfo(officer);
                System.out.println("Nhập bằng cấp: ");
                String branch = scanner.nextLine();
                ((Engineer)officer).setBranch(branch);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
            case 3:
                officer = new Staff();
                inputBasicInfo(officer);
                System.out.println("Nhập công việc: ");
                String task = scanner.nextLine();
                ((Staff)officer).setTask(task);
                officers = addOfficer(officer);
                showOfficers(officers);
                break;
        }
 **/
        showOfficers(officers);
        System.out.println("Sắp xếp cán bộ theo tuổi");
        Comparator comparatorByAge = new ComparatorByAge();
        Arrays.sort(officers, comparatorByAge);
        showOfficers(officers);
        System.out.println("Sắp xếp cán bộ theo tên");
        Comparator comparatorByName = new ComparatorByName();
        Arrays.sort(officers, comparatorByName);
        showOfficers(officers);
    }

    public static void main(String[] args) {
        ManagerOfficer managerOfficer = new ManagerOfficer();
    }
    public void inputBasicInfo(Officer officer){
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
    public Officer[] addOfficer(Officer officer){
        Officer[] officersNew = Arrays.copyOf(officers, officers.length + 1);
        officersNew[officersNew.length - 1] = officer;
        return officersNew;
    }
    public void showOfficers(Officer[] officers){
        for(Officer officer : officers){
            System.out.println(officer);
        }
    }
}
