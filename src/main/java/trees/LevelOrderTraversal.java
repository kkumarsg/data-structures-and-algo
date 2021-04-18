package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    /*
     * There's a good trick to print the new line.
     * You push a 'null' with root.
     * While iterating, everytime you see a null remove it and add a null.
     *
     * Ex: [1, 2 3, 4 5 6 7] are in level order with ',' for next level.
     * queue would be : [1,null,2,3,null,4,5,6,7,null]
     */



    public void levelTraversalWithoutNewLines(TreeNode node){

        if (node==null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode lastElement = queue.remove();

            System.out.print(lastElement.getKey()+" ");
            if (lastElement.getLeft()!=null) {
                queue.add(lastElement.getLeft());
            }
            if (lastElement.getRight()!=null) {
                queue.add(lastElement.getRight());
            }
        }
    }

    /*
     * This is little tricky.
     */
    public void levelTraversalWithNewLines(TreeNode node){

        if (node==null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        System.out.println();

        while (!queue.isEmpty()) {

            for(int i=0; i<queue.size(); i++) {
                TreeNode lastElement = queue.remove();

                System.out.print(lastElement.getKey() + " ");
                if (lastElement.getLeft() != null) {
                    queue.add(lastElement.getLeft());
                }
                if (lastElement.getRight() != null) {
                    queue.add(lastElement.getRight());
                }
            }
            System.out.println();
        }
    }
}
