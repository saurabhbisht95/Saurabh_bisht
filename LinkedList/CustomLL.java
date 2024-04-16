package LinkedLIst;

public class CustomLL {

    private Node head;
    private Node tail;
    private int size;

    public CustomLL() {
        this.size = 0;
    }

    // ********Creating the new private class name Node***** */
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // creating the fucntion that add the new element before the head.
    // here when we add new number that is gonna be add before the previous number.
    /*
     * For ex:- lets we have a number 1 and i m adding new number 2, then the new
     * number gonna be add before 1 ,Ex 2,1.
     */

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;

    }

    /*
     * defining the function that gonna add a new member at the last of the list
     * that means after the tail
     */
    public void insertLast(int val) {
        // here if the list is empty then it will call the insertFirst() function..
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    /*
     * delcaring function that gonna take value and index number where user want to
     * add new element.
     */
    public void insertRan(int val, int index) {

        // here if index ==0 then it will cal the function inserfirst.
        if (index == 0) {
            insertFirst(val);
            return;
        }
        // if the index == size of list then it will call the function insertLast.
        if (index == size) {
            insertLast(val);
            return;
        }

        // now here we are creating the new temp node which holds the value of head.
        Node temp = head;

        // here we are moving the value of temp from head to before the index number.
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        // creating the new object of Node.
        Node node = new Node(val, temp.next);
        temp.next = node;
        // here we can also do this like this:-
        // Node node = new Node(val);
        // node.next = temp.next;
        // temp.next = node;
        //
        size += 1;
    }

    // *******display method/*** */
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("End");
        System.out.println(head.value);
        System.out.println(tail.value);
    }

    // **************Main method****** */
    public static void main(String[] args) {

        CustomLL list = new CustomLL();
        list.insertFirst(1);
        // list.insertFirst(2);
        // list.insertFirst(3);
        // list.insertFirst(4);
        list.insertLast(13);
        list.insertRan(15, 4);

        list.display();
    }
}