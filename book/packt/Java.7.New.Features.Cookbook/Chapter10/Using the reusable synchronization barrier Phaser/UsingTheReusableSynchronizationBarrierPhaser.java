package usingthereusablesynchronizationbarrierphaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class UsingTheReusableSynchronizationBarrierPhaser {

    private static abstract class Entity implements Runnable {
        public abstract void run();
    }

    private static class Player extends Entity implements Runnable {
        private final static AtomicInteger idSource = new AtomicInteger();
        private final int id = idSource.incrementAndGet();

        public void run() {
            System.out.println(toString() + " started");
            try {
                Thread.currentThread().sleep(
                        ThreadLocalRandom.current().nextInt(200, 600));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(toString() + " stopped");
        }

        @Override
        public String toString() {
            return "Player #" + id;
        }
    }

    private static class Zombie extends Entity implements Runnable {
        private final static AtomicInteger idSource = new AtomicInteger();
        private final int id = idSource.incrementAndGet();

        public void run() {
            System.out.println(toString() + " started");
            try {
                Thread.currentThread().sleep(
                        ThreadLocalRandom.current().nextInt(400, 800));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(toString() + " stopped");
        }

        @Override
        public String toString() {
            return "Zombie #" + id;
        }
    }
    
    private void execute() {
        List<Entity> entities = new ArrayList<>();
        entities = new ArrayList<>();
        entities.add(new Player());
        entities.add(new Zombie());
        entities.add(new Zombie());
        entities.add(new Zombie());
        gameEngine(entities);
    }
    
    private void gameEngine(List<Entity> entities) {
        final Phaser phaser = new Phaser(1);
        for (final Entity entity : entities) {
            final String member = entity.toString();
            System.out.println(member + " joined the game");
            phaser.register();
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + 
                            " waiting for the remaining participants");
                    phaser.arriveAndAwaitAdvance(); // wait for remaining entities
                    System.out.println(member + " starting run");
                    entity.run();
                }
            }.start();
        }
        phaser.arriveAndDeregister();     //Deregister and continue
        System.out.println("Phaser continuing");
  
        // Using a phaser to repeat a series of tasks
//        final int iterations = 3;  
//        final Phaser phaser = new Phaser(1) {
//            protected boolean onAdvance(int phase, int registeredParties) {
//                System.out.println("Phase number " + phase + " completed\n");                
//                return phase >= iterations-1 || registeredParties == 0;
//            }
//        };
//        for (final Entity entity : entities) {
//            final String member = entity.toString();
//            System.out.println(member + " joined the game");
//            phaser.register();
//            new Thread() {
//
//                @Override
//                public void run() {
//                    do {
//                        System.out.println(member + " starting run");
//                        entity.run();
//                        System.out.println(member + 
//                                " waiting for the remaining participants during phase " +
//                                phaser.getPhase());
//                        phaser.arriveAndAwaitAdvance(); // wait for remaining entities
//                    } while (!phaser.isTerminated());
//                }
//            }.start();
//        }
//
//        while (!phaser.isTerminated()) {
//            phaser.arriveAndAwaitAdvance();
//        }
//        System.out.println("Phaser continuing");

    }

    public static void main(String[] args) {
        new UsingTheReusableSynchronizationBarrierPhaser().execute();
    }

}
