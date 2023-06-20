package service;

import config.Config;
import model.LogIn;
import sun.text.resources.no.CollationData_no;
import utils.FileUtils;
import utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogInService implements ILogInService{
    private Scanner scanner = new Scanner(System.in);
    private String path = "F:\\Module2\\CaseStudy\\data\\login.csv";
    public void logIn(){
        List<LogIn> logIns = FileUtils.readFile(path, Config.TYPE_LOGIN);
        for(LogIn logIn : logIns){
            System.out.println("* * * * * * * * * * * * * * * * *");
            System.out.println("*       MỜI BẠN ĐĂNG NHẬP       *");
            System.out.println("* * * * * * * * * * * * * * * * *");
            do {
                System.out.println("Nhập username:");
                String username = scanner.nextLine();
                if(!ValidateUtils.isValidUsername(username)){
                    System.out.println("Usename là các từ viết liền không dấu và tối thiểu 5 kí tự");
                    continue;
                }
                String password;
                do {
                    System.out.println("Nhập password:");
                    password = scanner.nextLine();
                    if(ValidateUtils.isValidPassword(password)){
                        break;
                    }else System.out.println("Password gồm các kí tự chữ hoặc số và tối thiểu là 8 kí tự");
                }while (true);

                if(username.equals(logIn.getUsename()) && password.equals(logIn.getPassword())){
                    System.out.println("***** Đăng nhập thành công *****");
                    break;
                }else {
                    System.out.println("*** Xin lỗi bạn nhập username hoặc password không đúng ***");
                    System.out.println("*** Bạn vui lòng đăng nhập lại ***");
                }
            }while (true);
        }
    }
    public void updateLogIn(){
        List<LogIn> logIns = new ArrayList<>();
        LogIn logIn = new LogIn();
        String usename;
        String password;
        do {
            System.out.println("Nhập usename mới:");
            usename = scanner.nextLine();
            if(ValidateUtils.isValidUsername(usename)) break;
            else System.out.println("Usename là các từ viết liền không dấu và tối thiểu 5 kí tự");
        }while (true);
        do {
            System.out.println("Nhập password mới:");
            password = scanner.nextLine();
            if(ValidateUtils.isValidPassword(password)) break;
            else System.out.println("Password gồm các kí tự chữ hoặc số và tối thiểu là 8 kí tự");
        }while (true);
        logIn.setUsename(usename);
        logIn.setPassword(password);
        logIns.add(logIn);
        FileUtils.writeFile(logIns, path);
        System.out.println("Bạn đã thay đổi tài khoản thành công!");
    }
}
