package exercise.ex1;

public class Worker extends Officer{
    private int level;

    public Worker(long id, String name, int age, String gender, String address, int level) {
        super(id, name, age, gender, address);
        this.level = level;
    }

    public Worker(int level) {
        this.level = level;
    }

    public Worker() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                '}';
    }
}
