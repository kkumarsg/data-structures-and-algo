package trees;

public class Traversals {

    public void inOrderTraversal(TreeNode node){

        if (node==null) {
            return ;
        }

        inOrderTraversal(node.getLeft());
        System.out.print(node.getKey()+" ");
        inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal(TreeNode node){

        if (node==null) {
            return ;
        }

        System.out.print(node.getKey()+" ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(TreeNode node){

        if (node==null) {
            return ;
        }

        inOrderTraversal(node.getLeft());
        inOrderTraversal(node.getRight());
        System.out.print(node.getKey()+" ");
    }
}
