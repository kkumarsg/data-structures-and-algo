package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {

    /*
        * method 1
            changing the next of every node to a temp node and keep looking for a node which is pointing to
            temp node in future, if we get such a node we've a loop.
            Disadvantages : modifying the original list, we cannot get back the original list.
        * method 2
            using a set and adding all the nodes to it, while adding we can check if the set already contains this
            node, if it does then we've a loop.
        * method 3 :  Floyd cycle detection method.
        *
        *
        * Why does Floyd cycle detection method work ?
                * slowPointer and fastPointer start at same position.
                * As they go ahead their distance between them increases, increases by 1 after every movement.
                * if there's no loop distance goes on increasing forever and they don't meet.
                * if there's a loop the distance will decrease once one of them or both of them enter inside the loop.
                * but before the distance decreases.. Note that it reaches max distance between them(inside the loop) which is equal to the length of the loop.

             This works because distance is increasing 1 step at a time, and distance will be equal to length of cycle at one point, at that point they meet.
             * However, if they're increasing more than 1 step at a time, there's no guarantee that they'll meet
               even after slow has visited all nodes. But, they could meet once the slow starts rotating again.

     */

    public static boolean checkIfLoopExistsSet(Node head){
        Set<Node> set = new HashSet<Node>();

        while(head!=null){
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean checkIfLoopExistsTemp(Node head){
        Node temp = new Node(4);

        while(head!=null){
            Node next = head.next;
            if(head.next==temp){
                return true;
            }
            head.next = temp;
            head = next;
        }
        return false;
    }

    public static boolean checkIfLoopExistsFloyd(Node head){

        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer==fastPointer){
                return true;
            }
        }
        return false;
    }
}
