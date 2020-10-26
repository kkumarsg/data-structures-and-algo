package linkedlists.singlylinkedlists;

public class DeleteTail {

    public static Node deleteTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node iterator = head;
        while(iterator.next!=null){
            if(iterator.next.next==null){
                break;
            }
            iterator = iterator.next;
        }
        iterator.next = null;
        return head;
    }
}
