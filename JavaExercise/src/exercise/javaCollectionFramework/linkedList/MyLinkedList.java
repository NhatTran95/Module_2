package exercise.javaCollectionFramework.linkedList;

public class MyLinkedList<E>{
    private class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }
    private Node head;
    private int numNodes;
    public MyLinkedList(){
    }
    public void add(int index, E element){
        Node temp = head;
        Node holder;
        for (int i = 0; i < index -1; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E element){
        Node temp = head;
        for (int i = 0; i < numNodes-1; i++){
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }
    public Object get(int index){
        Node temp = head;
        for (int i =0; i < index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public E getFirst(){
        return (E) head.data;
    }
    public Object getLast(){
        Node temp = head;
        for (int i =0; i < numNodes-1; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public int size(){
        return numNodes;
    }
    public void clear(){
        Node temp = head;
        for (int i = 0; i < numNodes; i++){
            while (temp!=null) {
                temp = temp.next;
            }
            temp = null;
        }
        head = null;
        numNodes = 0;
    }
    public E remove(int index){
        if (index < 0 || index > numNodes -1){
            throw new IllegalArgumentException("index: "+index);
        }
        Node temp = head;
        Object data;
        if (index == 0){
            data = head.data;
            head = head.next;
            numNodes--;
        }else {
            for (int i = 0; i < index-1; i++){
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }
    public boolean remove(Object element){
        if (head.data.equals(element)){
            remove(0);
            return true;
        }else {
            Node temp = head;
            for (int i =0; i < numNodes -1 ; i++){
                temp=temp.next;
                if (temp.data.equals(element)) {
                    remove(i + 1);
                    return true;
                }
            }
        }
        return false;
    }
    public MyLinkedList<E> clone(){
        if (numNodes == 0)
            throw new NullPointerException("Linked List = null");
        MyLinkedList<E> myLinkedListClone = new MyLinkedList<>();
        Node temp = head;
        myLinkedListClone.addFirst((E) temp.data);
        temp = temp.next;
        while (temp!=null){
            myLinkedListClone.addLast((E) temp.data);
            temp = temp.next;
        }
        return myLinkedListClone;
    }
    public boolean contains(E element){
        Node temp = head;
        while (temp != null){
            if (temp.data.equals(element))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element){
        Node temp = head;
        for (int i = 0; i<numNodes; i++){
            if (temp.data.equals(element))
                return i;
            temp = temp.next;
        }
        return -1;
    }
}
