class Node {
    Integer value;
    Node next;
    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;
        while (count < elementNumber && current != null) {
            current = current.next;
            count = count + 1;
        }
        return current;
    }

    public void LinkedListDelete(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        int count = 0;
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }
        if (current != null) {
            previous.next = current.next;
        } else {
            System.out.println("Índice inválido: " + index);
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        System.out.println("Lista original:");
        list.printList();

        Node previous = list.LinkedListLookUp(2);
        Node newNode = new Node(71);
        list.LinkedListInsertAfter(previous, newNode);

        System.out.println("Lista después de insertar 71:");
        list.printList();

        list.LinkedListDelete(4);

        System.out.println("Lista después de eliminar índice 4:");
        list.printList();
    }
}