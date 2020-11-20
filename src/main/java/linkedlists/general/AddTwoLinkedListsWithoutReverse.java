package linkedlists.general;

public class AddTwoLinkedListsWithoutReverse {

    public static void main(String[] args) {

        Node n1 = new Node(6);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(9);

        Node n5 = new Node(9);
        Node n6 = new Node(8);
        Node n7 = new Node(7);
        Node n8 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Node node = addSameSize(n1, n5);
        System.out.println(node);
    }
    static Node addSameSize(Node head1, Node head2) {
        // Write code here
        Node res;
        PairData pair = getSumByRecursion(head1, head2);
        if(pair.carry!=0){
            Node carryNode = new Node(pair.carry);
            carryNode.next = pair.resultantNode;
            res = carryNode;
            return res;
        }
        res = pair.resultantNode;
        return res;
    }

    static PairData getSumByRecursion(Node h1, Node h2){
        if(h1==null && h2==null){
            return new PairData(0, null);
        }
        if(h1.next==null && h2.next==null){
            int sum = h1.val+h2.val;
            return new PairData(sum/10, new Node(sum%10));
        }
        PairData pair = getSumByRecursion(h1.next, h2.next);
        int sum = h1.val + h2.val + pair.carry;
        Node node = new Node(sum%10);
        node.next = pair.resultantNode;
        return new PairData(sum/10, node);
    }
}

class PairData {
    int carry;
    Node resultantNode;

    public PairData(int carry, Node resultantNode){
        this.carry = carry;
        this.resultantNode = resultantNode;
    }
}
