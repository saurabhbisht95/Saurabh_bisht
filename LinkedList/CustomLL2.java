package LinkedLIst;

public class CustomLL2 {

    private Node head;
    private Node tail;
    private int size;

    public CustomLL2() {
        this.size = 0;
    }

    // ********Creating the new private class name Node***** */
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        // public Node(int value, Node next) {
        // this.value = value;
        // this.next = next;
        // }

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

    /******** This function is for deleting the first element in the list**** */
    public int deleteFirst() {
        if (tail == null) {
            System.out.println("your list is empty");
        }
        int val = head.value;
        // here the current head positon will move to the next position of head.
        head = head.next;
        size -= 1;
        return val;

    }

    public int deleteLast() {
        // Defining the temp node which is equal to head of linkedlist
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.value;
        // Now assignig the tail to current temp node that means current temp node =tail
        tail = temp;
        // Redirecting the temp.next value to null
        temp.next = null;
        size -= 1;
        return val;

    }

    public int deleteByIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        // Definig the temp node which is pointing the head or linkedlist
        Node temp = head;
        // Here moving temp node to before the index node which we have to delete
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        /*
         * here it assign the value of index node so that we can return it that this
         * node has removed from linkedlist, because temp is currently pointing the node
         * which is just prevvious of index node, so we are assigning the value of
         * temp.next which means index node into val variable.
         */
        int val = temp.next.value;

        // Here we are pointing the next node of temp to temp.next.next that means the
        // next node of index node.
        temp.next = temp.next.next;
        size -= 1;
        return val;

    }

    public void deleteByvalue(int val) {
        if (head.value == val) {
            deleteFirst();
            return;
        }
        if (tail.value == val) {
            deleteLast();
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public Node Find(int value) {
        // Declaring the temp variable which is also pointing to the head.
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // *******display method/*** */
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

    }

    // **************Main method****** */
    public static void main(String[] args) {

        CustomLL2 list = new CustomLL2();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        // list.deleteFirst();
        // list.deleteLast();
        list.deleteByvalue(3);
        list.display();

        // list.deleteByIndex(1);
        // list.display();

        // System.out.println(list.Find(2));

    }
}