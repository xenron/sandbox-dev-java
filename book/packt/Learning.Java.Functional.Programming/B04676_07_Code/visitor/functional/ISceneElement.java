package packt.visitor.functional;

@FunctionalInterface
public interface ISceneElement {
    
    public String getName();
    
    public default void accept(ISceneElementVisitor visitor) {
        visitor.visit(this);
    }    
}
