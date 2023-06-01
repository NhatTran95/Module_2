package practice.javaCollectiinFramework.stack;

import java.util.Arrays;
import java.util.Stack;

public class MyStack<T> {
    private Object arr[];
    private int size;
    private int index = 0;
    public MyStack(int size){
        this.size = size;
        arr = new Object[size];
    }
    public void push(T value) {
        if (index == arr.length) {
            arr  = Arrays.copyOf(arr, size*2);
        }
        arr[index] = value;
        index++;
    }
    public T pop() {
        T temp = (T) arr[index - 1];
        arr[index-1] = null;
        index--;

        return temp;
    }
    public T peek() {
        return (T)arr[index - 1];
    }
    public boolean isEmpty() {
        return index==0;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>(10);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.pop();
        myStack.push(9);
        myStack.peek();
        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }


        /**MyStack<String> myStack1 = new MyStack<>(5);
        myStack1.push("nam");
        myStack1.push("nam1");
        myStack1.push("nam2");
        myStack1.push("nam3");
        myStack1.peek();
        myStack1.push("nam4");
        myStack1.pop();
        myStack1.push("nam5");
        while (!myStack1.isEmpty()){
            System.out.println(myStack1.pop());
        }**/

    }

}
