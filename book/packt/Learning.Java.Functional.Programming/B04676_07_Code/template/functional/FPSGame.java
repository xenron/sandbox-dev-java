package packt.template.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FPSGame extends Game {

    public FPSGame(
            Consumer<String> initialize,
            Supplier<String> render,
            Function<String, Integer> update) {
        this.initialize = initialize;
        this.render = render;
        this.update = update;
        run("FPS Game");
    }
}
