package packt;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(Node node) {
        this.value = node.value;
        this.left = node.left;
        this.right = node.right;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public Node left() {
        return this.left;
    }
    
    public Node addLeft(int value) {
        Node node = new Node(value);
        this.left = node;
        return node;
    }
    
    public Node addLeft(Node node) {
        this.left = node;
        return this;
    }
    
    public Node right() {
        return this.right;
    }
    
    public Node addRight(int value) {
        Node node = new Node(value);
        this.right = node;
        return node;
    }
    
    public Node addRight(Node node) {
        this.right = node;
        return this;
    }
}
