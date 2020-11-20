package linkedlists.general;

public class SortZeroOnesTwos {

    public static void main(String[] args) {
//2 1 1 1 0 1 2 0 1 0 1 0 1 2 0 0 1
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(0);
        Node n6 = new Node(1);
        Node n7 = new Node(2);
        Node n8 = new Node(0);
        Node n9 = new Node(1);
        Node n10 = new Node(0);
        Node n11 = new Node(1);
        Node n12 = new Node(0);
        Node n13 = new Node(1);
        Node n14 = new Node(2);
        Node n15 = new Node(0);
        Node n16 = new Node(0);
        Node n17 = new Node(1);

        n1.next = (n2);
        n2.next = (n3);
        n3.next = (n4);
        n4.next = (n5);
        n5.next = (n6);
        n6.next = (n7);
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;

        Node head = segregate(n1);
        System.out.println(head);

    }
    static Node segregate(Node head)
    {
        Node one = new Node(0), firstOne = new Node(0);
        Node two = new Node(0), firstTwo = new Node(0);
        Node zero = new Node(0), firstZero = new Node(0);
        boolean isFirstOne = true, isFirstZero = true, isFirstTwo = true;
        while(head!=null){
            if(head.val==0){
                if(isFirstZero){
                    firstZero = head;
                    zero = firstZero;
                    isFirstZero = false;
                }
                else{
                    zero.next = head;
                    zero = zero.next;
                }
            }
            if(head.val==1){
                if(isFirstOne){
                    firstOne = head;
                    one = firstOne;
                    isFirstOne = false;
                }
                else{
                    one.next = head;
                    one = one.next;
                }
            }
            if(head.val==2){
                if(isFirstTwo){
                    firstTwo = head;
                    two = firstTwo;
                    isFirstTwo = false;
                }
                else{
                    two.next = head;
                    two = two.next;
                }
            }
            head = head.next;
        }
        zero.next = firstOne.next!=null ? firstOne:firstTwo;
        one.next = firstTwo.next!=null ? firstTwo:null;

        two.next = null;
        return firstZero;
    }
}
