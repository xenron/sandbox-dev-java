package packt;

public class WalkCommand implements Command{
   private final Move move;

   public WalkCommand(Move move){
      this.move=move;
   }

   @Override
   public boolean execute() {
      return move.walk();
   }
}
