package homework.week9.laptrinh;

public class GeneralTree {
    static class Node{
        char data;
        int firstChild;
        int nextSibling;

        public Node(char data){
            this.data = data;
            firstChild = -1;
            nextSibling = -1;
        }
    }

    private Node[] tree;
    private int size;
    private int rootIndex;

    public GeneralTree(int capacity){
        tree = new Node[capacity];
        size = 0;
        rootIndex = -1;
    }

    public int addNode(char data) {
        if (size >= tree.length) {
            throw new RuntimeException("Mảng đã đầy!");
        }
        tree[size] = new Node(data);
        if (rootIndex == -1) {
            rootIndex = size;
        }
        return size++;
    }

    public void addChild(int parentIdx, int childIdx) {
        if (tree[parentIdx].firstChild == -1) {
            tree[parentIdx].firstChild = childIdx;
        } else {
            int current = tree[parentIdx].firstChild;
            while (tree[current].nextSibling != -1) {
                current = tree[current].nextSibling;
            }
            tree[current].nextSibling = childIdx;
        }
    }

    public int findParent(int targetIndex) {
        if (rootIndex == -1 || targetIndex == rootIndex) {
            return -1;
        }
        return findParentHelper(rootIndex, targetIndex);
    }

    private int findParentHelper(int currIndex, int targetIndex) {
        if (currIndex == -1 || targetIndex == -1) {
            return -1;
        }

        // 1. Kiểm tra xem targetIndex có phải là con của currIndex không
        int child = tree[currIndex].firstChild;
        while (child != -1) {
            if (child == targetIndex) {
                return currIndex;
            }
            child = tree[child].nextSibling; // duyệt sang người con tiếp theo
        }

        // 2. Nếu không phải, tìm tiếp trong nhánh các con của currIndex
        int parentInChild = findParentHelper(tree[currIndex].firstChild, targetIndex);
        if (parentInChild != -1) {
            return parentInChild;
        }

        // 3. Nếu vẫn không thấy, tìm tiếp sang nhánh anh em của currIndex
        return findParentHelper(tree[currIndex].nextSibling, targetIndex);
    }

}
