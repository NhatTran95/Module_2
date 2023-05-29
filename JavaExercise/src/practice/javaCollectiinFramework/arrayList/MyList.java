package practice.javaCollectiinFramework.arrayList;

import java.util.*;

public class MyList<E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCap(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e){
        if(size == elements.length){
            ensureCap();
        }
        elements[size] = e;
        size++;
    }
    public int size(){
        return this.size;
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException();
        }
        return (E) elements[index];
    }
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException();
        }
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;
    }
    public void add(int index, E e){
        if(size == elements.length) {
            ensureCap();
        }
        for(int i = size-1; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = e;
        size++;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        Set<String> b = new HashSet<>();

        b.add("Quang");
        b.add("Thu");


        System.out.println(b.add("Thu"));
        for(String tt: b){
            System.out.println(tt +" ");
        }


        /**
        MyList<Integer> ds = new MyList<>();
        ds.add(1);
        ds.add(5);
        ds.add(6);
        ds.add(8);
        ds.add(2);
        for(int i = 0; i < ds.size(); i++ ){
            System.out.println(ds.get(i));
        }
        ds.remove(2);
        System.out.println("sau khi remove");
        for(int i = 0; i < ds.size(); i++ ){
            System.out.println(ds.get(i));
        }
        ds.add(4, 10);
        System.out.println("sau khi add");
        for(int i = 0; i < ds.size(); i++ ){
            System.out.println(ds.get(i));
        }

         **/

    }


}
