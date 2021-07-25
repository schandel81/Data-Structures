public class LinkedList1 {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    Node reverseLinkedList(Node head)
    {
        if(head == null)
            return null;
        Node prev = null;
        Node cur = head;
        Node next = cur.next;
        while(next != null)
        {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        return cur;
    }
    void deleteWithoutHeadPointer(Node delNode) {
        Node temp = delNode;
        while(temp.next != null)
        {
            temp.val = temp.next.val;
            temp = temp.next;
        }
        temp = null;
    }
    Node findMiddleElement(Node head) {
        Node fast = head;
        Node slow = head;
        if(head == null)
            return null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    Node rearrageListForOddEvenPositions(Node head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        Node odd = head;
        Node even = head.next;
        Node oddItr = odd;
        Node evenItr = even;
        while(oddItr != null && evenItr != null) {
            oddItr.next = evenItr.next;
            oddItr = evenItr.next;
            if(oddItr != null) {
                evenItr = oddItr.next;
                evenItr = oddItr.next;
            }
        }
        oddItr = odd;
        evenItr = even;
        while(oddItr.next != null)
            oddItr = oddItr.next;
        oddItr.next = even;
        return odd;

    }
    Node detectAndRemoveLoop(Node head) {
        if(head == null)
            return null;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null && fast != slow)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast)
            return head;
        Node ptr1 = slow;
        Node ptr2 = slow;
        int k = 1; // tO calculate number of nodes in loop
        while(ptr2.next != ptr1) {
            ptr2 = ptr2.next;
            k++;
        }
        int i = 0;
        ptr2 = head;
        while(i < k) {
            ptr2 = ptr2.next;
        }
        while(ptr1 != ptr2) { //To get starting point of loop
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr2.next != ptr1) // To get last node in loop
            ptr2 = ptr2.next;
        ptr2.next = null; // removed
        return head;
    }
    Node intersectionPoint(Node head1, Node head2) {
        if(head1 == null || head2 == null)
            return null;
        Node l1Itr = head1;
        Node l2Itr = head2;
        int c1 = 0, c2 = 0;
        while(l1Itr != null) {
            l1Itr = l1Itr.next;
            c1++;
        }
        while(l2Itr != null) {
            l2Itr = l2Itr.next;
            c2++;
        }
        int d;
        if(c1 > c2)
        {
            d = c1 - c2;
            int i = 0;
            l1Itr = head1;
            while(i < d)
                l1Itr = l1Itr.next;

        }
        else
        {
            d = c2 - c1;
            int i = 0;
            l2Itr = head2;
            while(i < d)
                l2Itr = l2Itr.next;
        }
        while(l1Itr != null && l2Itr != null && l1Itr != l2Itr)
        {
            l1Itr = l1Itr.next;
            l2Itr = l2Itr.next;
        }
        if(l1Itr == null || l2Itr == null)
            return null;
        else
            return l1Itr; //Intersection point
    }
    Node rotateLinkListByKPlaces(Node head, int k) {
        if(head == null)
            return null;
        if(k == 0)
            return head;
        int i = 1;
        Node itr = head;
        while(i < k && itr != null) {
            itr = itr.next;
            k++;
        }
        if(itr == null)
            return head;
        Node knode = itr;
        while(itr.next != null)
            itr = itr.next;
        itr.next = head;
        head = knode.next;
        knode.next = null;
        return head;
    }
    Node reverseLinkListInSizeOfK(Node head, int k) {
        if(k == 0)
            return head;
        Node prev = null;
        Node curr = head;

        int loop = 0;
        while(curr != null) {
            int i = 0;
            Node curHead = curr;
            while (i < k && curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                i++;
            }
            if (loop == 0)
                head = prev;
            curHead.next = curr;
        }
        return head;

    }
    class Node1 {
        int val;
        Node1 next;
        Node1 down;
        Node1(int val) {
            this.val = val;
            next = null;
            down = null;
        }
    }
    Node1 flattenLinkList(Node1 head) {
        if(head == null)
            return null;
        Node1 itr = head;
        Node1 next = itr.next;
        Node1 down = itr.down;
        while(itr != null) {
            while (down != null) {
                itr.next = down;
                down = down.down;
                itr.next.down = null;
                itr = itr.next;
            }
            itr.next = next;
            itr = next;
            next = itr.next;
            down = itr.down;
        }
        return head;
    }

    //Clone a linked list with Random pointers
}
