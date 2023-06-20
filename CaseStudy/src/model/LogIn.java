package model;

public class LogIn {
    private String usename;
    private String password;
    public LogIn(){};

    public LogIn(String usename, String password) {
        this.usename = usename;
        this.password = password;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", usename, password);
    }
}
