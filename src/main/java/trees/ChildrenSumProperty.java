package trees;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChildrenSumProperty {

    public boolean checkForChildrenSum(TreeNode node){
        if(node==null){
            return true;
        }
        int childrenSum =
                (node.getLeft()!=null ? node.getLeft().getKey() : 0)
                + (node.getRight()!=null ? node.getRight().getKey() : 0);
        if(node.getKey()!=childrenSum){
            return false;
        }
        return checkForChildrenSum(node.getLeft()) && checkForChildrenSum(node.getRight());
    }
}
