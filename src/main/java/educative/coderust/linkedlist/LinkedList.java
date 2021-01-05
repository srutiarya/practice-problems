package educative.coderust.linkedlist;

class Node {

    private int data;
    private Node next;

    public Node(int val) {
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getNext() {
        return next;
    }
}

public class LinkedList {

    private Node head;

    public LinkedList() {

    }

    public LinkedList(int val) {
        head = new Node(val);
    }

    public void addAtEnd(int val) {
        Node newNode = new Node(val);

        Node temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(newNode);

    }

    public void reverse() {
        reverse(head, null);
    }

    public void reverse(Node current, Node previous) {
        if (current.getNext() == null) {
            head = current;
        } else {
            reverse(current.getNext(), current);
        }
        current.setNext(previous);
    }


    public void display() {
        Node temp = head;
        while(temp.getNext() != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);
        linkedList.addAtEnd(1);
        linkedList.addAtEnd(6);
        linkedList.addAtEnd(8);
        linkedList.addAtEnd(3);
        linkedList.addAtEnd(9);

        linkedList.display();

        linkedList.reverse();

        linkedList.display();
    }

}
