package linkedlists.doublylinkedlists;

public class DLLUtil {

    public static final String APPENDER = "<=>";

    public static void printDoublyLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data);
            head = head.next;
            if(head!=null){
                System.out.print(APPENDER);
            }
        }
        System.out.println();
    }
}
