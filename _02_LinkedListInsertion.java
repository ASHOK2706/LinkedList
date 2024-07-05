// Q1. Inserting at Front 
// Q2. Inserting at Last
// Q3. Inserting at Kth Posistion
// Q4. Inserting at before value
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    public Node(int data,Node next) {
        this.data = data;
        this.next = next;
    }
}

public class _02_LinkedListInsertion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = convertArr2LL(arr);
        // Q1. Inserting at Front 
        System.out.print("Before Inserting Front : ");
        printLL(head);
        head = InsertAtFront(head,100);
        System.out.print("\nAfter Inserting Front : ");
        printLL(head);

        // Q2. Inserting at Last
        System.out.print("\n\nBefore Inserting Last : ");
        printLL(head);
        head = InsertAtLast(head,100);
        System.out.print("\nAfter Inserting Last : ");
        printLL(head);

        // Q3. Inserting at Kth Posistion   k = 3
        System.out.print("\n\nBefore Inserting at Kth Posistion : ");
        printLL(head);
        head = InsertAtKthPosistion(head,100,3);
        System.out.print("\nAfter Inserting at Kth Posistion : ");
        printLL(head);

        // Q4. Inserting at before value val = 7
        System.out.print("\n\nBefore Inserting at BeforeValue : ");
        printLL(head);
        head = InsertAtBeforeValue(head,100,6);
        System.out.print("\nAfter Inserting BeforeValue : ");
        printLL(head);
    }

    // Q1. Inserting at Front 
    private static Node InsertAtFront(Node head, int element) {
        Node newNode  = new Node(element);
        if(head==null) {
            return new Node(element);
        }
        newNode.next = head;
        return newNode;   
    }

    // Q2. Inserting at Last
    private static Node InsertAtLast(Node head, int element) {
        if(head==null) {
            return new Node(element);
        }
        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        temp.next=newNode;
        return head;
        
    }

    // Q3. Inserting at Kth Posistion   k = 3
    private static Node InsertAtKthPosistion(Node head, int element, int k) {
        if(k==1) {
            return new Node(element,head);
        }
        Node newNode = new Node(element);
        Node temp = head;
        int count = 0;
        while(temp!=null) {
            count++;
            if(count == k-1) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // Q4. Inserting at before value val = 7
    private static Node InsertAtBeforeValue(Node head, int element,int before) {
        if(head.data == before) {
            Node newNode = new Node(element,head);
            return newNode;
        }
        Node newNode = new Node(element);
        Node temp = head;
        while(temp.next!=null) {
            if(temp.next.data == before) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // converting Array to LinnkedList
    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = tail.next;
        }
        return head;
    }

    // printing LinkedList
    private static void printLL(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            if(temp.next!=null) System.out.print(" -> ");
            temp = temp.next;
        }
    }
}
