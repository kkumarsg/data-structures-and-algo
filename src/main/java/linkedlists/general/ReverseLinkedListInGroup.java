package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class ReverseLinkedListInGroup {

    /*
    Another idea to try..
    create a method which reverse only the elements in between.
      ex : 1->2->3->4->5->6
           A method which takes 1 and k, let's say k=3.
           it'll return this, 1->(4->3->2)->5->6
           Now only 4,3,2 are reversed, this way we can iterate over a group and keep reversing them.
     */

    public static Node reverse(Node head, int k)
    {
        //Your code here
        Node current = head;
        Node prevFirst = null;
        boolean isFirst = true;
        while(current!=null){
            int counter = 0;
            Node prev = null;
            Node first = current;
            while(counter<k && current!=null){
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                counter = counter + 1;
            }
            if(isFirst){
                head = prev;
                isFirst = false;
            }
            else{
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }
}
