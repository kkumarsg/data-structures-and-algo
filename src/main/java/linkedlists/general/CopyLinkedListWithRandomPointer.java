package linkedlists.general;



import java.util.HashMap;

public class CopyLinkedListWithRandomPointer {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;
        while(current!=null){
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        Node copyHead = map.get(head);
        Node tail = copyHead;
        while(current!=null){
            tail.next = map.get(current.next);
            tail.random = map.get(current.random);
            tail = tail.next;
            current = current.next;
        }
        return copyHead;
    }
}
