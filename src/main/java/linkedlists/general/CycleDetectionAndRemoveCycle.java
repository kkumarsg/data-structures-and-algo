package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class CycleDetectionAndRemoveCycle {

    public static void removeLoop(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node slowPointer = head.next;
        Node fastPointer = head.next.next;

        while(fastPointer!=null && fastPointer.next!=null){
            if(slowPointer==fastPointer){
                slowPointer = head;
                break;
            }
            if(slowPointer.next==fastPointer.next.next && fastPointer.next.next==head){
                fastPointer.next.next = null;
                return;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if(slowPointer==head){
            while(slowPointer.next != fastPointer.next){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            fastPointer.next = null;
        }

    }
}
