class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int data) {
        this.data = data;
        next =null;
    }
}
public class LinkListDelete {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist1, int position1) {
        // Write your code here
        if(llist1 == null || position1 == 0) {
            return null;
        }
        SinglyLinkedListNode itr = llist1;
        SinglyLinkedListNode prev = null;
        int posCount = 0;
        while(posCount < position1 && itr != null) {
            prev = itr;
            itr = itr.next;
            posCount++;
        }
        if(posCount < position1)
            return llist1;
        prev.next = itr.next;
        return llist1;
    }
    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(20);
        head.next = new SinglyLinkedListNode(6);
        head.next.next = new SinglyLinkedListNode(2);
        head.next.next.next = new SinglyLinkedListNode(19);
        head.next.next.next.next = new SinglyLinkedListNode(7);
        head.next.next.next.next.next = new SinglyLinkedListNode(4);
        head.next.next.next.next.next.next = new SinglyLinkedListNode(15);
        head.next.next.next.next.next.next.next = new SinglyLinkedListNode(9);
        SinglyLinkedListNode head1 = deleteNode(head, 3);
        while(head1 != null) {
            System.out.println(head1.data);
            head1 = head1.next;
        }

    }
}