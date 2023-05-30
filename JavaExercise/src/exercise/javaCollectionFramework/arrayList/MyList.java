package exercise.javaCollectionFramework.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void ensureCapacity() {
        if (size >= elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
    }

    public void add(int index, E e) {
        ensureCapacity();
        checkIndex(index);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
        size++;
    }

    public boolean add(E e) {
        ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E remove(int index) {
        checkIndex(index);
        Object temp = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return (E) temp;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    private int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }
    public void clear(){
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
    }
    public MyList<E> clone() {
        MyList<E> clone = new MyList<>();
        clone.elements = Arrays.copyOf(this.elements, this.size);
        clone.size = this.size;
        return clone;
    }

    public static void main(String[] args) {
        MyList<Integer> numbers = new MyList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(4);
        numbers.add(2, 10);
        numbers.add(5,  10);
        numbers.remove(0);
        for (int i = 0; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
        }

    }
}

