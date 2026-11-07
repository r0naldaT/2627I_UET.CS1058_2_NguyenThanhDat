package homework.week9.laptrinh;

public class bai6 {
    static class Node{
        int val;
        int ht;
        Node left;
        Node right;

        public Node(){}
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.ht = 0;
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static int getHeight(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    static int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.ht = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.ht = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }
}
