package linkedlists.doublylinkedlists;

public class DeleteTail {

    public static Node deleteTail(Node head){
        if (head==null || head.next==null) {
            return null;
        }
        Node iterator = head;
        while(iterator.next!=null){
            if(iterator.next.next==null){
                break;
            }
            iterator = iterator.next;
        }
        iterator.next.prev = null;
        iterator.next = null;
        return head;
    }
}
