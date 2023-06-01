package exercise.javaCollectionFramework.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(2);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addLast(9);
        myLinkedList.add(2, 10);
        myLinkedList.remove(1);
        for(int i = 0; i < myLinkedList.size(); i++){
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(myLinkedList.getLast());
        System.out.println(myLinkedList.getFirst());
        LinkedList<Integer> ds = new LinkedList<>();
        ds.add(1);
        ds.add(1);
        ds.add(1);
        ds.add(1);
        for (Integer item : ds){
            System.out.println(item);
        }

    }
}
