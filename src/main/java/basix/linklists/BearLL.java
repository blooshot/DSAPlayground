package basix.linklists;

public class BearLL {
    public class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    public void add(int data){
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
    }

    public Node getHead() {
        return head;
    }

    public BearLL(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

//    public static void main(String[] args) {
//
////        while (temp != null){
////            System.out.println(temp.data);
////            temp = temp.next;
////        }
//    }

    public  Node reverseLinkedList(Node head) {
        Node temp = head;
        Node newNode = new Node();
//        if(temp.next != null) {
            reversIng(temp.next,newNode);
//                    if(newNode)
//        }
//        System.out.println(temp.data);
//        if(newHead == null){
//            newHead .data= temp.data;
//        }else{
//            newHead.next .data= temp.data;
//            newHead = newHead.next;
//        }

        return temp;
    }

void reversIng(Node start, Node retu){
        Node temp = start;
        if(temp != null){
            reversIng(temp.next,retu);
        }

        if(retu.data == 0 ){

        }
}

}//EC
