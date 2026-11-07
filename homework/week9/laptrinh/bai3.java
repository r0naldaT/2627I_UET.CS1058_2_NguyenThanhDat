package homework.week9.laptrinh;

public class bai3 {
    public static Node insert(Node root,int data) {
        if (root == null){
            return new Node(data);
        }

        if (data < root.data){
            root.left = insert(root.left, data);
        }
        else if (data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }
}
