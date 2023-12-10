import java.util.List;

public class ReArrangeLinkedList {

    public static ListNode rearrangeList(ListNode head) {

        //Divide the linked list inti halves
        //Reverse the 2Nd half
        //Then merge alternatively

        if(head == null || head.getNext() == null || head.getNext().getNext() == null){
            return  null;
        }

        ListNode middle = getMiddle(head);
        ListNode firstList = head;
        ListNode secondList = reverse(middle.getNext());
        //Dividing it into two halves .
        //1st linked list ends at middle . so middle.next = null
        //2Nd linked list starts at middle
        middle.setNext(null);
        ListNode fTemp = firstList;
        ListNode sTemp = secondList;


        while(sTemp!= null){

            ListNode firstNext = fTemp.getNext();
            ListNode secondNext = sTemp.getNext();

            fTemp.setNext(sTemp);
            sTemp.setNext(secondNext);
            fTemp= firstNext;
            sTemp = secondNext;


        }

        return  head;

    }

    public  static ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.getNext()!= null)
        {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null)
        {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
        return  head;

    }


}
