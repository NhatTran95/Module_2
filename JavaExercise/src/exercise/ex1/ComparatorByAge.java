package exercise.ex1;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Officer> {
    @Override
    public int compare(Officer o1, Officer o2) {
        if (o1.getAge() > o2.getAge()) return 1;
        if (o1.getAge() < o2.getAge()) return -1;
        return 0;
    }
}
