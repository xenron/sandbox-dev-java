package packt.visitor.traditional;

public class BuildingElement implements ISceneElement {
    private String name;
 
    public BuildingElement(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
    @Override
    public void accept(ISceneElementVisitor visitor) {
        visitor.visit(this);
    }
}