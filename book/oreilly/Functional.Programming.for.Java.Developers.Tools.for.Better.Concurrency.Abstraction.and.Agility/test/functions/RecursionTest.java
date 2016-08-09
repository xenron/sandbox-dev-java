package functions;
import static org.junit.Assert.*;
import org.junit.Test;

public class RecursionTest {
  
  static class Tree {
    // public fields for simplicity
    public final Tree left;   // left subtree
    public final Tree right;  // right subtree
    public final int  value;  // value at this node
  
    public Tree(Tree left, int value, Tree right) {
      this.left  = left;
      this.value = value;
      this.right = right;
    }

    public final String toString() {
      String leftStr  = left  == null ? "^" : left.toString();
      String rightStr = right == null ? "^" : right.toString();
      return "(" + leftStr + "-" + value + "-" + rightStr + ")";
    }
  }
 
  @Test
  public void walkATree() {
    Tree root = new Tree( 
      new Tree(
        new Tree(null, 3, null), 2, new Tree(new Tree(null, 5, null), 4, null)), 
      1,
      new Tree(
        new Tree(null, 7, null), 6, new Tree(null, 8, null)));
  
    String expected = "(((^-3-^)-2-((^-5-^)-4-^))-1-((^-7-^)-6-(^-8-^)))";
    assertEquals(expected, root.toString());
  }
}
