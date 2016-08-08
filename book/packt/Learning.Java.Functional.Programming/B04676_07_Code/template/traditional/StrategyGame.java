package packt.template.traditional;

public class StrategyGame extends Game {

    public StrategyGame() {
        run("Strategy Game");
    }

    @Override
    void initialize(String name) {
        System.out.println("Starting " + name);}

    @Override
    String render() {
        System.out.println("Generating Strategy Image");
        return "Strategy Image";}

    @Override
    int update(String name) {
        System.out.println("Updating " + name);
        return 0;
    }
}
