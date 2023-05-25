package exercise.ex1;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Officer> {
    @Override
    public int compare(Officer o1, Officer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
