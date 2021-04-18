package trees;

public class Height {

    public int height(TreeNode node){

        if(node==null){
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    // in the beginning level would be 0.
    public void elementsInLevelK(TreeNode node, int k, int level){
        if(k>level || node==null){
            return ;
        }
        if(k==level){
            System.out.print(node.getKey()+" ");
        }
        else{
            elementsInLevelK(node.getLeft(), k, level+1);
            elementsInLevelK(node.getRight(), k, level+1);
        }
    }


}
