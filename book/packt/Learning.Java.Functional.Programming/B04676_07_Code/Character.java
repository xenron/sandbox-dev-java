package packt;

public class Character implements Move {
   @Override
   public boolean walk() {
      System.out.println("Walking");
      return true;
   }
   @Override
   public boolean run() {
      System.out.println("Running");
      return true;
   }
   @Override
   public boolean jump() {
      System.out.println("Jumping");
      return true;
   }
}
