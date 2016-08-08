package packt.visitor.functional;

@FunctionalInterface
public interface ISceneElementVisitor {
    public void visit(ISceneElement element);
}
