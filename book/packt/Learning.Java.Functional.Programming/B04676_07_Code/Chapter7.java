package packt;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import packt.decorator.traditional.BasicBox;
import packt.decorator.traditional.ColorBox;
import packt.decorator.traditional.ColorMaterialBox;
import packt.decorator.traditional.IBox;
import packt.decorator.traditional.IColorBox;
import packt.decorator.traditional.IColorMaterialBox;
import packt.decorator.traditional.IMaterialBox;
import packt.decorator.traditional.MaterialBox;

//import packt.decorator.Box;
//import packt.decorator.BasicBox2;
//import packt.decorator.CardBoardBox;
//import packt.decorator.ReinforcedBox;
//import packt.decorator.DoubleWalledBox;

//import packt.decorator2.BasicBox;
//import packt.decorator2.ColorBox;
//import packt.decorator2.IBox;
//import packt.decorator2.MaterialBox;


//import packt.decorator.functional.BasicBox;
//import packt.decorator.functional.ColorBox;
//import packt.decorator.functional.ColorMaterialBox;
//import packt.decorator.functional.IBox;
//import packt.decorator.functional.IColorBox;
//import packt.decorator.functional.IColorMaterialBox;
//import packt.decorator.functional.IMaterialBox;
//import packt.decorator.functional.MaterialBox;

public class Chapter7 {

    public static void main(String[] args) {
//        executeAroundMethodExamples();
//        factoryPatternExamples();
//        commandPatternExample();
        decoratorExample();
    }

    private static int executeImperativeSquareSolution(int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            // Use value
            result = value * value;
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }

    private static int executeImperativeCubeSolution(int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            // Use value
            result = value * value * value;
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }

    private static int executeDuration(
            Function<Integer, Integer> consumer, int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            result = consumer.apply(value);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }

    private static int withLog(int value) {
        System.out.print("Operation logged for " + value + " - ");
        return value;
    }

    private static int executeWithLog(
            Function<Integer, Integer> consumer, int value) {
        System.out.print("Operation logged for " + value + " - ");
        return consumer.apply(value);
    }

    private static int executeBefore(
            Function<Integer, Integer> beforeFunction,
            Function<Integer, Integer> function,
            Integer value) {
        beforeFunction.apply(value);
        return function.apply(value);
    }

    private static int executeAfter(
            Function<Integer, Integer> function,
            Function<Integer, Integer> afterFunction,
            Integer value) {
        int result = function.apply(value);
        afterFunction.apply(result);
        return result;
    }

    private static void executeAroundMethodExamples() {

        // Imperative solution
        System.out.println("---Imperative Solution");
        System.out.println(executeImperativeSquareSolution(5));
        System.out.println(executeImperativeCubeSolution(5));

        // Functional solution
        System.out.println("---Functional Solution");
        Function<Integer, Integer> computeSquare = x -> x * x;
        Function<Integer, Integer> computeCube = x -> x * x * x;

        System.out.println("---executeDuration Examples");
        System.out.println(executeDuration(x -> x * x, 5));
        System.out.println(executeDuration(x -> x * x * x, 5));

        System.out.println("---withLog Examples");
        System.out.println(withLog(5));

        int result = executeDuration(x -> x * x, 5);
        System.out.println(withLog(result));

        System.out.println(withLog(executeDuration(x -> x * x, 5)));
        System.out.println(executeDuration(x -> x * x, withLog(5)));
        System.out.println(executeWithLog(x -> x * x, 5));
        System.out.println(executeWithLog(computeSquare, 5));

        System.out.println("---executeBefore");
        System.out.println(executeBefore(Chapter7::withLog, computeSquare, 5));
        System.out.println("---executeAfter");
        System.out.println(executeAfter(computeSquare, Chapter7::withLog, 5));

        // Stream example
        Function<Integer, Integer> computeDuration
                = x -> executeDuration(computeSquare, x);
        Integer arr[] = {1, 2, 3, 4, 5};
        Stream<Integer> myStream = Arrays.stream(arr);
        myStream
                //                .map(computeDuration)
                .map(x -> executeDuration(v -> v * v, x))
                .forEach(x -> System.out.println(x));
    }

    // Factory Pattern Examples
    private static void factoryPatternExamples() {
        VacuumCleaner dvc = VacuumCleanerFactory.getInstance("Dirt");
        dvc.vacuum();
        dvc.clean();
        Supplier<DirtVacuumCleaner> dvcSupplier = DirtVacuumCleaner::new;
//        Supplier<DirtVacuumCleaner> dvcSupplier = ()->DirtVacuumCleaner::new;
        dvc = dvcSupplier.get();
        dvc.vacuum();
        dvc.clean();
        System.out.println();

        VacuumCleaner wvc = VacuumCleanerFactory.getInstance("Water");
        wvc.vacuum();
        wvc.clean();
        Supplier<WaterVacuumCleaner> wvcSupplier = WaterVacuumCleaner::new;
        wvc = wvcSupplier.get();
        wvc.vacuum();
        wvc.clean();

//        System.out.println(VacuumCleanerFactory.buildVacuumCleaner("Dirt"));
//        System.out.println(VacuumCleanerFactory.buildVacuumCleaner("Water"));
    }

    private static void commandPatternExample() {
        Character character = new Character();
        Commands commands = new Commands();

        commands.addCommand(new WalkCommand(character));
        commands.addCommand(new RunCommand(character));
        commands.addCommand(new JumpCommand(character));
        commands.executeCommand();

        // Lambda expressions
        // Specific classes not needed WalkCommand ...
        System.out.println("Functional Implementation");
        FunctionalCommands fc = new FunctionalCommands();
        fc.addCommand(() -> character.walk());
        fc.addCommand(() -> character.run());
        fc.addCommand(() -> character.jump());
        fc.executeCommand();

        fc.addCommand(character::walk);
        fc.addCommand(character::run);
        fc.addCommand(character::jump);
        fc.executeCommand();

    }

    private static void decoratorExample() {
//        Box box;
//        CardBoardBox cbox = new CardBoardBox(new BasicBox());
//        System.out.println(cbox);
//        ReinforcedBox rbox = new ReinforcedBox(new BasicBox());
//        System.out.println(rbox);
//        DoubleWalledBox dwbox = new DoubleWalledBox(new BasicBox());
//        System.out.println(dwbox);
//
//        // Combinations
//        box = new DoubleWalledBox(new ReinforcedBox(new CardBoardBox(new BasicBox())));
//        System.out.println("Combined Boxes: " + box);
//        box = new CardBoardBox(new DoubleWalledBox(new ReinforcedBox(new BasicBox())));
//        System.out.println("Combined Boxes: " + box);

        //
        System.out.println("\nFunctional");
//        Optional<FunctionalBox> fBox = Optional.of(new FunctionalBox());
//        System.out.println("FunctionalBox - " + fBox);
//        
//        Optional<FunctionalBox> cardBoardBox = Optional.of(
//                new FunctionalBox()
//                .setContents("+Book")
//                .setCost(0.5));
//        System.out.println("cardBoardBox - " + cardBoardBox);
//        
//        Optional<FunctionalBox> reinforcedBox = Optional.of(
//                new FunctionalBox()
//                .setContents("+BlueRay Player")
//                .setCost(0.75));
//        System.out.println("reinforcedBox - " + reinforcedBox);
//        
//        Optional<FunctionalBox> doubleWalledBox = Optional.of(
//                new FunctionalBox()
//                .setContents("+Flatscreen TV")
//                .setCost(1.25));
//        System.out.println("doubleWalledBox - " + doubleWalledBox);
//        
//        BiFunction<FunctionalBox,FunctionalBox,FunctionalBox> combined = (b1,b2)->{
//            FunctionalBox b = new FunctionalBox();
//            b.setCost(b1.getCost()+b2.getCost());
//            b.setContents(b1.getContents()+b2.getContents());
//            return b;
//        };
//        BiFunction<Optional<FunctionalBox>,Optional<FunctionalBox>,Optional<FunctionalBox>> combined2 = (b1,b2)->{
//            FunctionalBox b = new FunctionalBox();
//            b.setCost(b1.get().getCost()+b2.get().getCost());
//            b.setContents(b1.get().getContents()+b2.get().getContents());
//            return Optional.of(b);
//        };
//        fBox = Optional.of(combined.apply(cardBoardBox.get(), reinforcedBox.get()));
//        System.out.println("Combined - " + fBox);
//        fBox = combined2.apply(cardBoardBox, reinforcedBox);
//        System.out.println("Combined - " + fBox);
//        fBox = Optional.of(combined.apply(combined.apply(cardBoardBox.get(), reinforcedBox.get()),doubleWalledBox.get()));
//        System.out.println("Combined - " + fBox);
//        fBox = Optional.of(combined.apply(combined.apply(reinforcedBox.get(), doubleWalledBox.get()),cardBoardBox.get()));
//        System.out.println("Combined - " + fBox);
//        System.out.println();
//        System.out.println();
//        
//        doubleWalledBox.get().setCost(3.25);
//        doubleWalledBox.get().setContents("+Anvil");
//        System.out.println("doubleWalledBox - " + doubleWalledBox);

//        Optional<FunctionalBox> mBox = cardBoardBox.map(co -> co.contents("+keyboard"));
//        Optional<FunctionalBox> lBox = mBox.map(co -> co.contents("+UPS"));
//        
//        System.out.println(fBox);
//        System.out.println(mBox);
//        System.out.println(lBox);
//        
//        lBox.get().setCost(35.4);
//        lBox.get().setContents("+UPS");
//        System.out.println(lBox);
//        
//        System.out.println(fBox
//                .map(co -> co.getCost() + 3)
//        );
//        Optional<FunctionalBox> fBox2;
//        fBox2 = fBox
//                .flatMap(co -> co.cost(3));
//        System.out.println(fBox2);
//        Optional<FunctionalBox> smallBox;
//        smallBox = fBox
//                .flatMap(co -> co.cost(3))
//                .flatMap(co -> co.optionalContents("+Thumb drive"));
//        System.out.println(smallBox);
//        smallBox.get().setContents("+more small stuff");
//        smallBox.get().setCost(24.5);
//        System.out.println(smallBox);
//        FunctionalBox anotherSmallBox = smallBox.get();
//        anotherSmallBox.setCost(122);
//        System.out.println(anotherSmallBox);
//        fBox = Optional.of(new FunctionalBox());
//        Optional<FunctionalBox> cardBoardBox = Optional.of(new FunctionalBox());
//        Optional<FunctionalBox> mBox = cardBoardBox.map(co->co.contents("+keyboard"));
//        Optional<FunctionalBox> lBox = mBox.map(co->co.contents("+UPS"));
//        
//        System.out.println(fBox);
//        System.out.println(mBox);
//        System.out.println(lBox);
//        
//        lBox.get().setCost(35.4);
//        lBox.get().setContents("+UPS");
//        System.out.println(lBox);
        // Use packt.decorator2
//import packt.decorator2.BasicBox;
//import packt.decorator2.ColorBox;
//import packt.decorator2.IBox;
//import packt.decorator2.MaterialBox;        
//        BasicBox b2 = new BasicBox();
//        System.out.println(b2);
//        ColorBox cb = new ColorBox(b2);
//        System.out.println(cb);
//        MaterialBox mb = new MaterialBox(b2);
//        System.out.println(mb);
//        
//        IBox combined = new MaterialBox(cb);
//        System.out.println(combined);
//        combined.setCost(45.80);
//        System.out.println(combined);
//        
//        combined = new ColorBox(mb);
//        System.out.println(combined);
//        combined.setCost(5.45);
//        System.out.println(combined);
        // Use packt.decorator3
//import packt.decorator3.BasicBox;
//import packt.decorator3.ColorBox;
//import packt.decorator3.IBox;
//import packt.decorator3.IColorBox;
//import packt.decorator3.IMaterialBox;
//import packt.decorator3.MaterialBox;
        
        System.out.println("\nTraditional");
        IBox bb = new BasicBox();
        bb.setCost(45.55);
        System.out.println(bb);

        ColorBox cb = new ColorBox(bb);
        cb.setColor("Red");
        cb.setCost(45.65);
        System.out.println(cb);

        MaterialBox mb =new MaterialBox(bb);
        mb.setMaterial("Cardboard");
        mb.setCost(34.32);
        System.out.println(mb);

        ColorMaterialBox cmb = new ColorMaterialBox(cb, mb);
        System.out.println(cmb);
        cmb.setColor("Blue");
        cmb.setMaterial("Plastic");
        cmb.setCost(23.45);
        System.out.println(cmb);

        cmb.setColor("Blue");
        // cast is necessary because encapsulated class method return type dominates
        ((IColorMaterialBox) cmb.setMaterial("Carbon Fiber")).setColor("Purple");
        System.out.println(cmb);
        
        
        
//        System.out.println("\nFunctional");
//        IBox basicFunctionalBox = (u) -> {
//            IBox box = new BasicBox();
//            box.setCost(u);
//            return box;
//        };
//
//        IColorBox colorFunctionalBox = (t) -> {
//            IColorBox b = new ColorBox(basicFunctionalBox.setCost(cost));
//            return b.setColor(t);
//        };
//
//        Function<String, IMaterialBox> materialFunctionalBox = (t) -> {
//            IMaterialBox b = new MaterialBox(new BasicBox());
//            return b.setMaterial(t);
//        };
//
//        BiFunction<IColorBox, IMaterialBox, IColorMaterialBox> cmBox = (t, u) -> {
//            IColorMaterialBox cmfb = new ColorMaterialBox(t, u);
//            return cmfb;
//        };
//
////        IBox bfb = basicFunctionalBox.apply(new BasicBox(), 45.55);
//        IBox bfb = basicFunctionalBox.setCost(45.55);
//        System.out.println(bfb);
//
//        IColorBox cfb = colorFunctionalBox.apply("Red");
//        cfb.setCost(45.65);
//        System.out.println(cfb);
//
//        IMaterialBox mfb = materialFunctionalBox.apply("Cardboard");
//        mfb.setCost(34.32);
//        System.out.println(mfb);
//
//        System.out.println();
//
//        IColorMaterialBox cmfb = cmBox.apply(cfb, mfb);
//        cmfb = new ColorMaterialBox(cfb, mfb);
//        System.out.println(cmfb);
//        cmfb.setColor("Blue");
//        cmfb.setMaterial("Plastic");
//        cmfb.setCost(23.45);
//        System.out.println(cmfb);
//
//        cmfb.setColor("Blue");
//        ((IColorMaterialBox) cmfb.setMaterial("Carbon Fiber")).setColor("Purple");
//        System.out.println(cmfb);
        
        
//        Function<Double, Double> function = x -> x + 45.67;
//        Consumer<Double> con = x -> System.out.println(x);
//        TestAlso t = 
//        TestAlso con2 = x -> cost=x;//System.out.println(x);
//        test(function, con);
    }

    interface TestAlso {

        public Double cost = 0.0;

        public default Double getCost(Double cost) {
            return cost;
        }

        public void setCost(Double cost);
    }

    private static void test(Function<Double, Double> box, Consumer<Double> con) {
        box.apply(23.65);

    }
}
