class LRUCache {

    // 1. Declare the Node inner class
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 2. Declare the class fields
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes to simplify boundary operations
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move the accessed node to the most recently used (MRU) position
        removeNode(node);
        addToTail(node);

        return node.value;        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node value and move to MRU
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToTail(node);
        } else {
            // Check capacity before inserting a new key
            if (map.size() == capacity) {
                // Remove LRU node (node immediately after dummy head)
                Node lruNode = head.next;
                map.remove(lruNode.key);
                removeNode(lruNode);
            }

            // Insert new node at MRU position (right before dummy tail)
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToTail(newNode);
        }
    }

    // 3. Include the helper methods for the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */