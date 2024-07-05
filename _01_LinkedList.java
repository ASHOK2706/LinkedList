

// Q1 . Convert Array to LinkedList
// Q2 . LinkedList Traversing
// Q3 . Length Of LinkedList
//Creating Node 
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class _01_LinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node head = ConvertArray2LinkedList(arr);
        System.out.println("head Element Of LinkedList is : "+head.data);

        System.out.println("Traverse LinkedList ");
        Traversal(head);

        System.out.println("\nLength Of LinkedList is : " +LengthOfLL(head));

    }


    // Convert Array to LinkedList
    private static Node ConvertArray2LinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = tail.next;
        }
        return head;
    }


    //LinkedList Traversing
    private static void Traversal(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            temp = temp.next;
            if(temp!=null) System.out.print(" -> ");
        }
    } 


    //Length Of LinkedList
    private static int LengthOfLL(Node head) {
        Node temp = head;
        int count = 0;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}