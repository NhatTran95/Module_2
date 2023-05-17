//Ứng dụng có sẵn một danh sách tên của sinh viên,
// cho phép người dùng nhập vào một tên sinh viên,
// sau đó hiển thị vị trí của sinh viên đó trong danh sách (nếu tìm thấy)
// hoặc là thông báo không tìm thấy
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] listStudents = {"Nhân", "Nhật", "Hiếu", "Minh", "Thắng", "Đạt", "Hưng"};
        System.out.println("Nhập tên sinh viên:");
        String name = input.nextLine();
        boolean flag = true;
        for(int i = 0; i < listStudents.length; i++) {
            if (listStudents[i].equals(name)) {
                System.out.println("Vị trí của sinh viên " +name+ " trong danh sách là: " +i);
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println("Sinh viên " +name+ " không có tên trong danh sách ");
        }
    }
}
