class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    void deleteAtStart() {
        if (head == null) {
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    void deleteAtEnd() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    void deleteByValue(int key) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (temp.data == key) {
            deleteAtStart();
            return;
        }

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtStart(10);
        list.insertAtStart(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.displayForward();

        list.deleteAtStart();
        list.displayForward();

        list.deleteAtEnd();
        list.displayForward();

        list.deleteByValue(10);
        list.displayForward();
    }
}
