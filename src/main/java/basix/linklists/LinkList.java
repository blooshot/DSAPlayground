package basix.linklists;

import java.util.NoSuchElementException;

public class LinkList {

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;
    //addFirst, addLast, deleteFirst, deleteLast, contains, indexOf

    public void addLast(int value){
       var node = new Node(value);
       if(first == null){
           first = last = node;
       }else {
           last.next = node;
           last = node;
       }
       size++;
    }

    public void addFirst(int value){
        var node = new Node(value);

        if(first == null){
            first = last = node;
        }else {
            node.next = node;
            first = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;
        while (current != null){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item){
        return  this.indexOf(item) != -1;
    }

    public void removeFirst(){
        if(first == null) throw new NoSuchElementException();

        if(first == last){
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast(){
        if(first == null) throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size --;
    }

    public int size(){
        return  size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current !=null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    private Node getPrevious(Node node){
        var current = first;
        while(current != null){
            if(current.next == node){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void ghumo(){
        var previous = getPrevious(last);

    }

    public void reverse(){
   /*     var current = first;
      *//*  var firstValue = first.value;
        first.value = last.value;
        last.value = firstValue;*//*
//        System.out.println(first.value);
//        System.out.println(last.value);
        while (current != null){
//            var previous = getPrevious(current);
//            System.out.println(previous.value);
            if(null == current.next) return;
            var theNext = current.next;
            var theCurrent = current;
            if(theNext.next != null) theNext.next.value = theCurrent.value;
//            System.out.println("==> "+theNext.next.value);
//            System.out.println(current.value);
            current = current.next;
        }*/
        //[10->13->15->65->121]  rev[121->65->15->13->10]

        if(first == null) return;
        var previouse = first;
        var current = first.next;

        while (current !=null){
            var next = current.next;
            current.next = previouse;
            previouse = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previouse;
    }







}
