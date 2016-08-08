package packt.visitor.traditional;

public interface ISceneElement {    
    public String getName();
    void accept(ISceneElementVisitor visitor);
}
