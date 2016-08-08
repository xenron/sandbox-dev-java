package packt.template.functional;

public class TemplateDriver {

    public static void initializeGame(String name) {
        System.out.println("Starting " + name);
    }

    public String render() {
        System.out.println("Generating FPS Image");
        return "FPS Image";
    }

    int update(String name) {
        System.out.println("Updating " + name);
        return 0;
    }

    public static void main(String args[]) {
        TemplateDriver td = new TemplateDriver();
        FPSGame fps = new FPSGame(
                TemplateDriver::initializeGame,
                td::render,
                name -> {
                    System.out.println("Updating " + name);
                    return 0;
                });

        StrategyGame sg = new StrategyGame(
                n -> System.out.println("Starting " + n),
                () -> {
                    System.out.println("Generating Strategy Image");
                    return "Strategy Image";
                },
                td::update);
    }
}
