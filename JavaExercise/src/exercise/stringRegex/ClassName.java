package exercise.stringRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String CLASSNAME_REGEX = "^[CAP][0-9]{4}[GHIK]$";
    public ClassName(){};
    public static boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASSNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    private static final String[] regexs = new String[] {"C0323H", "A0568K", "P5869A", "P86958I", "M2356K"};

    public static void main(String[] args) {
        for(String item : regexs){
            System.out.println(validate(item));
        }
    }

}
