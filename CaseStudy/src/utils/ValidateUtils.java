package utils;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.regex.Pattern;

public class ValidateUtils {
    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
    private static final String REGEX_BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}$";
    private static final String REGEX_DATERENT = "^(0?[1-9]|[12][0-9]|3[01])[\\-](0?[1-9]|1[012])[\\-]\\d{4}$";
    private static final String REGEX_CCCD = "^[0][0-9][1-9][0-9][0-9]{2}[0-9]{6}$";
    private static final String REGEX_HOMETOWN = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ ]+$";
    private static final String REGEX_PHONE = "^[0][0-9]{9}$";
    private static final String REGEX_YEAR = "^[2][0-9]{3}$";
    private static final String REGEX_MONTH = "^[1-9]|[1][0-2]}$";
    private static final String REGEX_USENAME = "^[a-zA-Z]{5,}$";
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{8,}$";

    private static final String REGEX_FINDNAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+$";
    public static boolean isValidRenterName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }
    public static boolean isValidRenterBirth(String birthday) {
        return Pattern.matches(REGEX_BIRTHDAY, birthday);
    }
    public static boolean isValidRenterCCCD(String cccd) {
        return Pattern.matches(REGEX_CCCD, cccd);
    }
    public static boolean isValidRenterHometown(String hometown){
        return Pattern.matches(REGEX_HOMETOWN, hometown);
    }
    public static boolean isValidRenterPhone(String phone){
        return Pattern.matches(REGEX_PHONE, phone);
    }
    public static boolean isValidDateRent(String date){
        return Pattern.matches(REGEX_DATERENT, date);
    }
    public static boolean isValidFindName(String name){
        return Pattern.matches(REGEX_FINDNAME, name);
    }
    public static boolean isValidYear(String year){
        return Pattern.matches(REGEX_YEAR, year);
    }
    public static boolean isValidMonth(String month){
        return Pattern.matches(REGEX_MONTH, month);
    }
    public static boolean isValidUsername(String usename){
        return Pattern.matches(REGEX_USENAME, usename);
    }
    public static boolean isValidPassword(String pass){
        return Pattern.matches(REGEX_PASSWORD, pass);
    }
}
