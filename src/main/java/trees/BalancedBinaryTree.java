package trees;

public class BalancedBinaryTree {

    /*
     * A tree is said to be balanced binary tree if the following condition holds true for every node in the tree
     * The difference between the height of the left subtree and height of the right subtree should not be more than 1.
     */

    // naive approach
    public boolean isTreeBalanced(TreeNode node){
        if(node==null){
            return true;
        }
        int lh = findHeight(node.getLeft());
        int rh = findHeight(node.getRight());
        if(Math.abs(lh-rh)>1){
            return false;
        }
        return isTreeBalanced(node.getLeft()) && isTreeBalanced(node.getRight());
    }

    // efficient approach
    // Here instead of returning if every node is balanced or not we'll return the height only if its balanced
    // otherwise we return -1.
    public int isTreeBalancedEff(TreeNode node){
        if(node==null){
            return 1;
        }
        int lh = isTreeBalancedEff(node.getLeft());
        int rh = isTreeBalancedEff(node.getRight());
        if(lh==-1 || rh==-1 || Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }

    private int findHeight(TreeNode node){
        if (node==null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
    }
}
