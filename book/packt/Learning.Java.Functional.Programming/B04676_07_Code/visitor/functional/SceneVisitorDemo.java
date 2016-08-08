package packt.visitor.functional;

public class SceneVisitorDemo {
    public static void main(String[] args) {
        ISceneElement scene = new Scene("Primary Scene");
        System.out.println("-----------SceneElementPrintVisitor-------------");
        scene.accept(new SceneElementPrintVisitor());
        System.out.println("-----------SceneElementDoVisitor-------------");
        scene.accept(new SceneElementRefreshVisitor());
        System.out.println("-----------LambdaSceneVisitor-------------");
        scene.accept(t -> System.out.println("Another visitor operation on " + t.getName()));
    }
}
