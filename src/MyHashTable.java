public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        public K key;
        public V value;
        public MyHashTable.HashNode<K,V> next;

        private class HashNode<K, V> {
            private K key;
            private V value;
            private HashNode<K, V> next;

            public HashNode(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "{" + key + " " + value + "}";
            }
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
        this.M = M;
    }

    private int hash(K key) {
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node!=null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new HashNode<>(key, value);
        node.next = chainArray[index];
        chainArray[index] = node;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> last = null;
        while (node != null){
            if (node.key.equals(key)){
                if (last==null){
                    chainArray[index] = node.next;
                }
                else {
                    last.next = node.next;
                }
                size--;
                return node.value;
            }
            last = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value) {
    }

    public K getKey(V value) {
    }
}
