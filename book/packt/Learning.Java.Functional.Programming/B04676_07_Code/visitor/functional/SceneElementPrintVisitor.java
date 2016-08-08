package packt.visitor.functional;

public class SceneElementPrintVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Printing " + element.getName());
    }

}
