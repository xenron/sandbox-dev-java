package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Chapter5 {

    public static void main(String[] args) {
        introductionExample();
        directRecursionExamples();
        treeExamples();
        recursiveLambdaExpressions();
    }

    private static void introductionExample() {
        // Imperative solution
        long fact = 1;
        for (int i = 1; i <= 5; i++) {
            fact *= i;
        }
        System.out.println(fact);
        // Recursive solution
        System.out.println(factorial(5));
    }

    public static long factorial(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static void head(String phrase) {
        if (phrase.length() == 0) {
            return;
        }
        head(phrase.substring(1));
//        System.out.print(phrase.charAt(0));

//        System.out.println(phrase.charAt(0));
        System.out.println(phrase);
    }

    private static void tail(String phrase) {
        if (phrase.length() == 0) {
            return;
        }
//        System.out.print(phrase.charAt(0));
        System.out.println(phrase);
        tail(phrase.substring(1));
    }

    private static int[] arr = {1, 2, 3, 4, 5};
    private static int presum = 0;
    private static int postsum = 0;

    private static void middle(int n) {
        if (n < 0) {
            return;
        }
        presum += arr[n];
        arr[n] += 2;
        middle(n - 1);
        postsum += arr[n];
        return;
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    private static int count = 0;

    private static int fib(int n) {
        count++;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static int recursiveSum(int n) {
        if (n == 2) {
            return 2;
        } else {
            return n + recursiveSum(n - 2);
        }
    }

    private static void directRecursionExamples() {
        head("Recursion");
        System.out.println();
        tail("Recursion");
        System.out.println();

        // Middle recursion example
        middle(4);
        System.out.println(presum);
        System.out.println(postsum);

        // gcd examples
        System.out.println(gcd(48, 72));
        System.out.println(gcd(182, 154));
        System.out.println(fib(11));
        System.out.println(count);

        // iterative GCD solution
        int arr[] = new int[15];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 15; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[11]);

        // Converting ierative loop to recursive solution
        int sum = 0;
        for (int i = 2; i <= 20; i += 2) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(recursiveSum(20));
        System.out.println(recursiveSum(18));
        System.out.println(recursiveSum(30));
        mergingTwoLists();
    }

    private static void mergingTwoLists() {
        Integer arr1[] = {2, 6, 9, 10, 14};
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(arr1));
        Integer arr2[] = {3, 5, 7, 12, 13};
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(arr2));

        ArrayList<Integer> list3;
        list3 = mergeList(list1, list2);
        list3.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static ArrayList<Integer> mergeList(
            ArrayList<Integer> list1,
            ArrayList<Integer> list2) {
        if (list1.isEmpty()) {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }
        ArrayList list = new ArrayList<>();
        if (list1.get(0) < list2.get(0)) {
            list.add(list1.remove(0));
        } else {
            list.add(list2.remove(0));
        }
        list.addAll(mergeList(list1, list2));
        return list;
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getValue() + " ");
            preOrder(node.left());
            preOrder(node.right());
        }
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left());
            System.out.print(node.getValue() + " ");
            inOrder(node.right());
        }
    }

    static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left());
            postOrder(node.right());
            System.out.print(node.getValue() + " ");
        }
    }

    static Consumer<Node> inorder; // Instance variable

    static void recursiveLambdaExpressions() {

        inorder = (Node node) -> {
            if (node == null) {
                return;
            } else {
                inorder.accept(node.left());
                System.out.print(node.getValue() + " ");
                inorder.accept(node.right());
            }
        };
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        inorder.accept(root);
    }

    static void treeExamples() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        System.out.println("Preorder traversal -----------------");
        preOrder(root);
        System.out.println();
        System.out.println("Inorder traversal -----------------");
        inOrder(root);
        System.out.println();
        System.out.println("Postoder traversal -----------------");
        postOrder(root);
        System.out.println();
    }
}
