import com.sun.source.tree.BinaryTree;

public class Main {

    public static void main(String[] args) {
        MyBinarySearchTree binaryTree = new MyBinarySearchTree();

        binaryTree.insert(10);
        binaryTree.insert(34);
        binaryTree.insert(4);
        binaryTree.insert(12);
        binaryTree.insert(63);
        binaryTree.insert(79);

        binaryTree.inOrder();
        System.out.println();
        System.out.println("Root data before remove: " +binaryTree.root.data);
        binaryTree.remove(79);
        System.out.println();
        binaryTree.inOrder();
        System.out.println();
        System.out.println("Root data after remove: " +binaryTree.root.data);
    }
}