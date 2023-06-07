package exercise.stringRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telephone {
    private static final String PHONE_REGEX = "^(\\([0-9]{2}\\))-(\\(0[0-9]{9}\\))$";
    public static boolean validate(String regex){
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    private static final String[] phones = {"(84)-(0123456789)","(a4)-(0123456789)","(84)-(01234568789)","(84)-(0924756789)","(84)-(012346789)", "(984)-(0123456789)" };

    public static void main(String[] args) {
        for(String item : phones){
            System.out.println(validate(item));
        }
    }
}
