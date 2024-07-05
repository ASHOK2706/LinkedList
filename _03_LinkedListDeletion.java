
// Q1. Delete head Node
// Q2. Delete Tail Node 
// Q3. Delete Kth Node  k=5
// Q4. Delete Element

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}  
public class _03_LinkedListDeletion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node head = ConvertArr2LL(arr);
        // Q1. Delete head Node 
        System.out.print("Before Deleting Head : ");
        printLL(head);
        head = delete_head_node(head);
        System.out.print("\nAfter Deleting Head : " );
        printLL(head);

        // Q2. Delete Tail Node 
        System.out.print("\n\nBefore Deleting Tail : ");
        printLL(head);
        head = delete_tail_node(head);
        System.out.print("\nAfter Deleting Tail : ");
        printLL(head);

        // Q3. Delete Kth Node  k=5
        System.out.print("\n\nBefore Deleting Kth Node : ");
        printLL(head);
        head = delete_kth_node(head,5);
        System.out.print("\nAfter Deleting kth Node : ");
        printLL(head);
    
        
        // Q4. Delete Element
        System.out.print("\n\nBefore Deleting Element : ");
        printLL(head);
        head = delete_element_node(head,3);
        System.out.print("\nAfter Deleting Element : ");
        printLL(head);
    }

     // Q1. Delete head Node
     private static Node delete_head_node(Node head) {
        if(head==null) {
            return head;
        }
        head = head.next;
        return head;
     }

    // Q2. Delete Tail Node 
    private static Node delete_tail_node(Node head) {
        Node temp = head;
        while(temp.next.next!=null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Q3. Delete Kth Node  k=5
    private static Node delete_kth_node(Node head,int k) {
        if(head==null) return head;
        if(k==1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev =null;
        int count = 0;
        while(temp!=null) {
            count++;
            if(count==k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    // Q4. Delete Element
    private static Node delete_element_node(Node head, int element) {
        if(head==null) return head;
        if(head.data == element) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null) {
            if(temp.data == element) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node ConvertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = tail.next;
        }
        return head;
    }
    private static void printLL(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            if(temp.next!=null) System.out.print(" -> ");
            temp = temp.next;
        }
    }
}
