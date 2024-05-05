package tree.postorder;

import java.util.*;

public class ZigZag2 {
    public static List<Integer> traverseBoundary(Node root){
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null){
            return ans;
        }
        if(!isLeaf(root)){
            ans.add(root.data);

        }
        leftside(root.left,ans);
        bottomside(root, ans);
        rightside(root.right, ans);
        return ans;
        // Write your code here.
    }

    public static boolean isLeaf(Node root){

        return (root.left == null) && (root.right == null);
    }

    public static void leftside(Node root, List<Integer> ans){
        Node cur = root.left;
        while(cur != null){
            if (!isLeaf(cur)) ans.add(cur.data);
            if(cur.left != null){
                cur = cur.left;
            }else{
                cur = cur.right;
            }

        }

    }

    public static void bottomside(Node root, List<Integer> ans){
        if (isLeaf(root)){
            ans.add(root.data);
            return;
        }

        bottomside(root.left, ans);
        bottomside(root.right, ans);

    }
    public static void  rightside(Node root, List<Integer> ans ){
        List<Integer> temp = new ArrayList<Integer>();
        Node cur = root.right;
        while(cur != null){
            if (!isLeaf(cur)) temp.add(0,cur.data);
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }

        }

        ans.addAll(temp);

    }
}
