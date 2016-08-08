package packt.visitor.traditional;

public class SceneElementRefreshVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Refreshing " + element.getName());
    }
}
