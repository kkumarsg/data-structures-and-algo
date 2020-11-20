package linkedlists.general;


public class SwapKthNodesFromStartAndEnd {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);

        n1.next = (n2);
        n2.next = n3;
//        n3.next = (n4);
//        n4.next = (n5);
        Node head = swapkthnode(n1, 3, 1);
        System.out.println("hello");
    }

    public static Node swapkthnode(Node head, int num, int k)
    {
        if(head==null || head.next==null){
            return head;
        }
        Node fromBeginning = head, fromEnd = head;
        int counter = 1;
        while(counter<k-1 && fromBeginning!=null){
            fromBeginning = fromBeginning.next;
            counter += 1;
        }
        Node current = fromBeginning.next;
        while(current!=null && current.next!=null && current.next.next!=null){
            current = current.next;
            fromEnd = fromEnd.next;
        }

        if(k==1)
            fromEnd = fromEnd.next;

        if(fromEnd==fromBeginning){
            if(k==1 || k==num){
                Node oldHead = head;
                head = head.next;
                head.next = oldHead;
                oldHead.next = null;
                return head;
            }
        }

        if(k==1 || k==num){
            Node oldHead = head;
            Node toSwap = fromEnd;
            if(k==num){
                toSwap = fromBeginning;
            }
            head = toSwap.next;
            toSwap.next = oldHead;
            head.next = oldHead.next;
            oldHead.next = null;
            return head;
        }

        Node fromBeginningNext = fromBeginning.next;
        fromBeginning.next = fromEnd.next;
        fromEnd.next = fromBeginningNext;

        Node fromBeginningNextNext = fromBeginning.next.next;
        fromBeginning.next.next = fromEnd.next.next;
        fromEnd.next.next = fromBeginningNextNext;

        return head;
    }
}
