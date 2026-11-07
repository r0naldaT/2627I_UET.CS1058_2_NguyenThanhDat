package homework.week9.laptrinh;

public class bai5 {
    boolean checkBST(Node root) {
        if (root == null){
            return true;
        }
        if (root.left.data > root.data || root.left.data < root.data){
            return false;
        }
        if (root.left == null){
            return checkBST(root.right);
        }
        else if (root.right == null){
            return checkBST(root.left);
        }
        return checkBST(root.left) && checkBST(root.right);
    }
}
