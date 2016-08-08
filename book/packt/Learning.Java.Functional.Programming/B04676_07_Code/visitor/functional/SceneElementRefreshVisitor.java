package packt.visitor.functional;

public class SceneElementRefreshVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Refesh " + element.getName());
    }
    
}
