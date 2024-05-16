import java.util.ArrayList;
import java.util.List;

public class BST <K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public <V> V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return (V) x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node root, K key) {
        Node x = root;
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }


    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }
    public void inorder(Node x) {
        inorder(root);
    }
    private void inOrder(Node x, List<K> keys) {
        if (x == null) return;
        inOrder(x.left, keys);
        keys.add(x.key);
        inOrder(x.right, keys);
    }

    public void insert(K key, V val) {
        root = insert(root, key, val);
    }

    private Node insert(Node current, K key, V val) {
        if (current == null)
            return new Node(key, val);
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = insert(current.left, key, val);
        else
            current.right = insert(current.right, key, val);
        return current;
    }


    public int size() {
        return size(root);
    }


    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }
}
