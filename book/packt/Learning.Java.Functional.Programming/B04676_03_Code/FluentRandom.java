package packt;

import java.util.Random;

public class FluentRandom extends Random {
    private int lower = 0;
    private int upper = Integer.MAX_VALUE;

    public FluentRandom useAsSeed(long seed) {
        this.setSeed(seed);
        return this;
    }

    public FluentRandom asLower(int lower) {
        this.lower = lower;
        return this;
    }

    public FluentRandom asUpper(int upper) {
        this.upper = upper;
        return this;
    }

    @Override
    public int nextInt() {
        return lower + this.nextInt(upper - lower);
    }
}
