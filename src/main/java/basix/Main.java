package basix;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      /*  MyArray number = new MyArray(3);
        number.insert(11);
        number.insert(23);
        number.insert(54);
        number.insert(124);
        number.insert(74);
        System.out.println(number.indexOf(54));
        number.print();
        number.removeAt(3);
        number.print();*/

      /*  LinkList list = new LinkList();
        list.addFirst(10);
        list.addLast(13);
        list.addLast(15);
        list.addLast(65);
        list.addLast(121);
//        System.out.println( list.indexOf(15));
//        list.removeLast();
//        System.out.println(list.size());
        var arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        list.reverse();
        var ar1r = list.toArray();
        System.out.println(Arrays.toString(ar1r));*/

/*        var stack = new Stack<>();
        String string = "abcd";
        StringBuffer reversed = new StringBuffer();
      for (int i = 0;i < string.length(); i++) {
          System.out.println(string.charAt(i));
            stack.push(string.charAt(i));
        }

      while(!stack.empty()){
          var i = 1;
//            var poop = stack.pop().toString();
//            System.out.println(poop);
           reversed.append(stack.pop());
        }

        System.out.println(reversed);*/

//        LinkedList myLinkedList = new LinkedList(1);
//        myLinkedList.append(2);
//
//        // (2) Items - Returns 2 Node
//        System.out.println(myLinkedList.removeLast().value);
//        // (1) Item - Returns 1 Node
//        System.out.println(myLinkedList.removeLast().value);
//        // (0) Items - Returns null
//        System.out.println(myLinkedList.removeLast());

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
//        stack.printStack();

        sortStack(stack);
        stack.peek();

        System.out.println("\nAfter sorting:");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
//        stack.printStack();
    }

    static void sortStack(java.util.Stack<Integer> stackToSort){
        java.util.Stack<Integer> additionalStack = new java.util.Stack<>();
        while(!stackToSort.isEmpty()){
            Integer temp = stackToSort.pop();
            while(!additionalStack.isEmpty() && additionalStack.peek() > temp){
                stackToSort.push(additionalStack.pop());
            }
            additionalStack.push(temp);
        }
        while (!additionalStack.isEmpty()) {
            stackToSort.push(additionalStack.pop());
        }
    }


}