package packt.visitor.functional;

public class Scene implements ISceneElement {
    ISceneElement[] elements;
    private String name;
 
    public Scene(String name) {
        this.name = name;
        BuildingElement building = ()->"Tool Shed";
        this.elements = new ISceneElement[] { building ,()->"Brick House",
            new PlantElement("Oak Tree"), new PlantElement("Lawn") };
    }
 
    @Override
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
