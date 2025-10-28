package basix;

public class Interview2 {
    class Node{
        Integer value;
        Node next;
        Node(Integer value){
            this.value = value;
        }
    }
    Node head;
    Node tail;
    Integer length =0;
    //add
    public  void add(Integer a){
        if(length ==0){
            Node newNode = new Node(a);
            head = newNode;
            tail = newNode;
        }else{
            Node newNode = new Node(a);
          //  Node temp = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

//    void  reverse(){
//        if(length >0){
//            Node start = head;
//            Node end = tail;
//            while (){
//
//            }
//        }
//    }

}

class  x{
    public static void main(String[] args) {
        Interview2 link = new Interview2();
        link.add(1);
        link.add(2);
        link.add(3);

        Interview2.Node temp = link.head;

        Integer[] arry = {4,0,6,0,7,0,7};
        //4,6,7,7,0,0,0

        for(Integer i = 0; i<arry.length-1; i++){
            if(arry[i] == 0){
                Integer temp1 = arry[i];
                arry[i] = arry[i+1];
                arry[i+1] = 0;
            }
        }

        for(Integer i: arry){
            System.out.println(i);
        }
//        while(temp !=  null){
//            System.out.println(temp.value);
//            temp = temp.next;
//        }
//
//        System.out.println(link.head);
//        System.out.println(link.tail);

//        for(Integer i =0; i <= link.length; i++){
//            System.out.println(link.f);
//        }
    }
}