package com.datastructures;

public class LinkedList<T> {
    private class Node <T>{
        private T value;
        private Node next;

        Node(T item) {
            value = item;
        }
    }

    private Node Head;
    private Node Last;
    private Node Temp;
    private int size;

    private boolean isEmpty(){ return Head == null;}

    private boolean isFirst(){return  Head == Last;}

    public void addLast(T item){
        Temp = new Node(item);
        if(isEmpty())
            Head = Last = Temp;
        else{
            Last.next = Temp;
            Last = Last.next;
        }
        size++;
    }

    public void addFirst(T item){
        Temp = new Node(item);
        if(isEmpty()){
            Head = Last = Temp;
        }
        else{
            Temp.next = Head;
            Head = Temp;
        }
        size++;
    }

    public void removeLast(){
         Node n = Head;
         if(isEmpty()){
             System.out.println("No Element in Linked List");
         }
         else if(isFirst()){
             Head = Last = null;
             System.out.println("\nRemoved - " + n.value);
         }
         else{
            while(n.next!=Last){
                n = n.next;
            }
            System.out.println("\nRemoved - " + Last.value);
            Last = null;
            Last = n;
            Last.next = null;
            n = null;
         }
         size--;
    }

    public void removeFirst(){
        Node n = Head;
        if(isEmpty()){
            System.out.println("No Element in Linked List");
        }
        else if(isFirst()){
            System.out.println("\nRemoved - " + Head.value);
            Head = null;
            Last = null;
        }
        else{
            n = Head.next;
            System.out.println("\nRemoved - "+Head.value);
            Head = null;
            Head = n;
            n = null;
        }
        size--;
    }

    public Boolean contains(T item){
        return indexOf(item) != -1;
  /*      Node n = Head;
        if(isEmpty()) return Boolean.FALSE;
        while(n!=null){
            if(n.value == item) return Boolean.TRUE;
            n = n.next;
        }
        n = null;
        return Boolean.FALSE;          */
    }

    public int Size(){
        return size;
   /*     int count = 0;
        Node n = Head;
        while( n != null){
            count++;
            n = n.next;
        }
        System.out.println(count);  */
    }

    public int indexOf(T item) {
        int count = 0;
        Node n = Head;
        if (isEmpty()) return -1;
        while (n != null) {
            if (n.value == item) return count;
            count++;
            n = n.next;
        }
        n = null;
        return -1;
    }

    public void Print(){
        Node n = Head;
        if(isEmpty()){
            System.out.println("No Element in Linked List");
        }
        while(n!=null){
            System.out.print(n.value + "\t");
            n = n.next;
        }
    }

    public void reverse(){
        Node point = null;
        Node current = null;
        Node Next = null;
        Node n;
        point = Last;
        while(Head != point){
            if(point == Last){
                n = Head.next;
                current = Head;
                current.next = null;
                point.next = current;
                Last = point.next;
                Head  = n;
            }
          else{
                 Next = point.next;
                 n = Head.next;
                 current = Head;
                 current.next = null;
                 point.next = current;
                 current.next = Next;
                 Head = n;
            }
        }
    }

    public void reverse2(){
        if(isEmpty()) return;
        var Previous =  Head;
        var Current = Head.next;
        while(Current!=null){
            var Next = Current.next;
            Current.next = Previous;
            Previous = Current;
            Current = Next;
        }
        Last = Head;
        Last.next = null;
        Head = Previous;
    /*    Node Current = null;
        Node Previous  = null;
        Node Next = null;
        Previous =  Head;
        Current = Head.next;
        Next = Current.next;
        Previous.next = null;
        Last = Previous;
        while(Next!=null){
            Current.next = Previous;
            Previous = Current;
            Current = Next;
            Next = Current.next;
        }
        Current.next = Previous;
        Head = Current;
        */

    }

    public  T getKthFromTheEnd(int k){
        if(isEmpty()) throw new  IllegalStateException();
        var first = Head;
        var second = Head;
        int count = 1;
        while (count!= k){
            if(second.next == null) throw new IllegalArgumentException();
            second = second.next;
            count++;
        }
        while(second!=Last){
            first = first.next;
            second = second.next;
        }
        return (T) first.value;
    }

    public void printMiddle(){
        if(isEmpty()) throw new IllegalStateException();
        var first = Head;
        var second = Head;
        while(second != Last && second.next != Last){
            second = second.next.next;
            first = first.next;
        }
        if(second == Last)
            System.out.println("The Middle Element is  - " + first.value);
        else
            System.out.println("The Middle Element are  - " + first.value  + "," + first.next.value);
    }

    public void createWithLoop(){
        if(isEmpty()) throw new IllegalThreadStateException();
        var Temp = Head;
        for(int i = 0; i<3; i++)
            if(Temp.next!=null)
                Temp = Temp.next;
        Last.next = Temp;
    }

    public boolean hasLoop(){
        if(isEmpty()) throw  new  IllegalArgumentException();
        var first = Head;
        var second = Head;
        while(second != null && second.next != null){
            second = second.next.next;
            first = first.next;
            if(first == second) return true;
        }
        return false;

    }

    public void removeLoop() {
        if (isEmpty()) throw  new IllegalArgumentException();
        var first = Head;
        var second = Head;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
            if (first == second)
                break;
        }
        var hit = first;
        first = Head;
        System.out.println("First and Second " + first.value + " " + second.value);
        while (second.next != first) {
            while (second.next != hit && second.next != first)
                second = second.next;
            if(second.next == first)
                break;
            first = first.next;
            second = hit;
        }
        second.next = null;
    }
   // public int[] toArray(){
    //    int[] array = new int[size];
    //    var current = Head;
    //    int index = 0;
    //    while(current != null) {
    //        array[index++] = current.value;
    //        current = current.next;
    //    }
    //    return array;
   // }
}
