package linkedlists.singlylinkedlists;

public class IndexSearch {

    public int findIndex(Node head, int data){
        int counter = 1;
        while(head!=null || head.data!=data){
            head = head.next;
            counter += 1;
        }
        if (head==null) {
            return -1;
        }
        return counter;
    }

    public int findIndexRecursive(Node head, int data){
        if (head==null) {
            return -1;
        }
        if (head.data == data) {
            return 1;
        }
        int res = findIndexRecursive(head.next, data);
        if (res==-1) {
            return -1;
        }
        return 1+res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        System.out.println("findIndexRecursiveAlt(node, 3, 0) = " + findIndexRecursiveAlt(node, 3, 0));
        System.out.println("findIndexRecursiveAlt(node, 4, 0) = " + findIndexRecursiveAlt(node, 4, 0));
        System.out.println("findIndexRecursiveAlt(node, 6, 0) = " + findIndexRecursiveAlt(node, 6, 0));
    }

    public static int findIndexRecursiveAlt(Node head, int data, int counter){
        if (head==null) {
            return -1;
        }
        if (head.data==data) {
            return counter+1;
        }
        return findIndexRecursiveAlt(head.next, data, counter+1);
    }
}
