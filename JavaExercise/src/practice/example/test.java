package practice.example;

public class test {
        public static void main(String[] args) {
            String s = "AABBBCCD";
            String result = "";
            int count = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    count++;
                } else {
                    result += s.charAt(i-1) + Integer.toString(count);
                    count = 1;
                }
            }
            result += s.charAt(s.length()-1) + Integer.toString(count);

            System.out.println(result);
        }

}
