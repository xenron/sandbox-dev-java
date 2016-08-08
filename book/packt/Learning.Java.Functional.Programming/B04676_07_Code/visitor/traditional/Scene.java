package packt.visitor.traditional;

public class Scene implements ISceneElement {
    ISceneElement[] elements;
    private String name;
 
    public Scene(String name) {
        this.name = name;
        this.elements = new ISceneElement[] { new BuildingElement("Tool Shed"),
            new BuildingElement("Brick House"), new PlantElement("Oak Tree") ,
            new PlantElement("Lawn") };
    }
 
    public void accept(ISceneElementVisitor visitor) {    
        for(ISceneElement elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);    
    }

    @Override
    public String getName() {
        return this.name;
    }
}
