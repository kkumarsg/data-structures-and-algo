package linkedlists;

public class LinkedListUtil {

    public static void printLinkedList(Node head){
        Node iterator = head;
        while(iterator!=null){
            System.out.print(iterator.data);
            if (iterator.next!=null) {
                System.out.print("->");
            }
            iterator = iterator.next;
        }
    }
}