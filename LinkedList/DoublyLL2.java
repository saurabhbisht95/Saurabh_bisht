package LinkedLIst;

public class DoublyLL2 {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLL2() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
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

    public void deleteFirst() {
        if (head == null) {
            System.out.println("your list is empty");
        }
        // here it will check if there only one node availble then it will assgin both
        // to null the head and tail.
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size -= 1;

        // If the list becomes empty after deletion, update the tail to null
        if (head == null) {
            tail = null;
        }
    }

    public void deleteLast() {

        Node temp = head;
        /*
         * here id head==tail that means there is only one node and if we have to delete
         * that one then we have to assgin the both head and tail = null;
         */
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
        }
        size -= 1;

    }

    public void deleteByvalue(int val) {
        Node temp = head;
        if (head.value == val) {
            deleteFirst();
            return;
        }
        if (tail.value == val) {
            deleteLast();
            return;
        }

        while (temp.next != null) {
            if (temp.value == val) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        size -= 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
        if (head == null) {
            System.out.println("Head value is Null");
        } else {
            System.out.println("Head value ->" + head.value);
        }
        if (tail == null) {
            System.out.println("Tail value is Null");
        } else {
            System.out.println("Tail value ->" + tail.value);
        }
        // size of the linkedlist
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
        if (head == null) {
            System.out.println("Head value is Null");
        } else {
            System.out.println("Head value ->" + head.value);
        }
        if (tail == null) {
            System.out.println("Tail value is Null");
        } else {
            System.out.println("Tail value ->" + tail.value);
        }
        // size of the linked list
        System.out.println("The size of Linkedlist->" + size);
    }

    public static void main(String[] args) {
        DoublyLL2 list = new DoublyLL2();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        // list.deleteFirst();
        // list.deleteLast();
        list.deleteByvalue(2);

        list.display();
        list.displayRev();
    }
}
