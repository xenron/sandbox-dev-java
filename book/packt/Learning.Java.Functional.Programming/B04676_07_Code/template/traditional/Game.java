package packt.template.traditional;

public abstract class Game {
    abstract void initialize(String name);
    abstract String render();
    abstract int update(String name);
    
    // Template method
    public final void run(String name) {
        initialize(name);
        while (true) {
            String image = render();
            System.out.println("Rendering " + image);
            int status = update(name);
            // Evaluate termination conditions
            System.out.println("...");
            break;
        }
    }
}
