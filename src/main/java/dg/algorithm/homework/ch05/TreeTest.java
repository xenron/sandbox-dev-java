package dg.algorithm.hw.ch05;

public class TreeTest {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(6);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = node1;
        left.right = node2;
        right.left = node3;
        right.right = node4;
        System.out.println(isSymmetric(root));

        left.left = new TreeNode(7);
        System.out.println(isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}