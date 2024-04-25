package LinkedLIst;

public class DoublyLL {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        // public Node(int value, Node next, Node prev) {
        // this.value = value;
        // this.next = next;
        // this.prev = prev;
        // }

    }

    // here in insertFirst() function we are adding the new node before the current
    // code.
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        // here this condtion is work is there is head already presented in list.
        if (head != null) {
            head.prev = node;
        }

        head = node;
        /*
         * here it will asign the first node as a tail because at the initially tail =
         * null so it assgin the first node which is also head as a tail.
         */
        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        // here it will check if tail there is no tail then it will tell to insertFirst
        // element
        if (tail == null) {
            insertFirst(val);
            return;
        }

        tail.next = node;
        node.next = null;
        if (tail != null) {
            node.prev = tail;
        }
        tail = node;
        size += 1;
    }

    public void insertRan(int val, int pos) {
        if (pos == 0) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        // here it will firstly create the node and then it assign the node.next to the
        // temp.next.
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        node.next.prev = node;
        size += 1;

        // here we can also do this method both will do same work
        /*
         * temp.next = node;
         * node.prev = temp;
         * node.next = temp.next.next;
         * temp.next.next.prev = node;
         * size += 1;
         */

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("Your head value is->" + head.value);
        System.out.println("Your tail value is->" + tail.value);
        System.out.println("The size of Linkedlist->" + size);
    }

    /*
     * Here in displayRev funtion we are just printing the element from tail to head
     * , the value of head and tail will still same.
     */
    public void displayRev() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.value + "->");
            // here the main thing is that we are moving from tail to previous one .
            temp = temp.prev;
        }
        System.out.println("Start");
        System.out.println("Your head value->" + head.value);
        System.out.println("Your tail value->" + tail.value);
        System.out.println("The size of Linkedlist->" + size);
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        list.insertLast(0);
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(3);

        // here it will add the 5 in first postion because pos is=0.
        list.insertRan(5, 3);
        list.display();
        list.displayRev();
    }
}
