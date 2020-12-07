package linkedlists.general;

import java.util.HashMap;
import java.util.Map;

/*
 * This needs to be tested and fixed.
 */
public class LRUCache
{

    static NodeDouble head = new NodeDouble();
    static NodeDouble tail = new NodeDouble();
    static int cap;
    static int currentSize = 0;
    static Map<Integer, NodeDouble> map = new HashMap<>();

    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        this.cap = cap;
    }

    // This method works in O(1)
    public static int get(int key)
    {
        // your code here
        if(map.containsKey(key)){
            NodeDouble returnNode = map.get(key);
            if(returnNode==tail){
                tail = returnNode.prev;
            }
            if(returnNode!=head){
                head = makeReturnNodeAsHead(head, returnNode);
            }

            return returnNode.value;

        }
        return -1;
    }

    public static NodeDouble makeReturnNodeAsHead(NodeDouble head, NodeDouble node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head;
        head.prev = node;
        return node;
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        // your code here
        if(map.containsKey(key)){
            get(key);
        }
        else{
            NodeDouble node = new NodeDouble();
            node.key = key;
            node.value = value;
            node.next = head;
            head.prev = node;
            head = node;
            currentSize += 1;
            if(currentSize>cap){
                //removeTail from map and list.
                map.remove(tail.key);
                currentSize -= 1;
                tail.prev.next = null;
                NodeDouble prev = tail.prev;
                tail.prev = null;
                tail = prev;

            }
            map.put(key, node);
        }
    }
}

class NodeDouble {
    int key;
    int value;
    NodeDouble next;
    NodeDouble prev;
}