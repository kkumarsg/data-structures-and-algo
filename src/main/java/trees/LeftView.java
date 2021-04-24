package trees;

import java.util.HashMap;
import java.util.Map;

public class LeftView {

    /*
     * Simplest way is to do a level order traversal and print the first element in every level.
     * Same thing can be applied for right view as well.
     */


    /*
     * This is an extension of print nodes in level K, or from a distance K.
     * We keep a track of if a node is being printed in the level K. if Yes, we don't print the next element.
     */
    public void leftView(TreeNode node){
        leftView(node, 0, new HashMap<Integer, Integer>());
    }

    public void leftView(TreeNode node, int level, Map<Integer, Integer> map){
        if (node==null) {
            return ;
        }

        if(map.get(level)==null){
            System.out.println(node.getKey());
            map.put(level, 1);
        }
        else{
            leftView(node.getLeft(), level+1, map);
            leftView(node.getRight(), level+1, map);
        }
    }
}
