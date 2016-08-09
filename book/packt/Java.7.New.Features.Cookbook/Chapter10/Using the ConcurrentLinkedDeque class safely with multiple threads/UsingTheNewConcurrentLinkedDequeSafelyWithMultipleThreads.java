package packt;

import java.util.concurrent.ConcurrentLinkedDeque;

public class UsingTheNewConcurrentLinkedDequeSafelyWithMultipleThreads {

    private static ConcurrentLinkedDeque<Item> deque = new ConcurrentLinkedDeque<>();

    static class Item {

        private String description;
        private int itemId;

        public String getDescription() {
            return description;
        }

        public int getItemId() {
            return itemId;
        }

        public Item() {
            this.description = "Default Item";
            this.itemId = 0;
        }

        public Item(String description, int itemId) {
            this.description = description;
            this.itemId = itemId;
        }
    }

    static class ItemProducer implements Runnable {
        @Override
        public void run() {
            String itemName = "";
            int itemId = 0;
            try {
                for (int x = 1; x < 8; x++) {
                    itemName = "Item" + x;
                    itemId = x;
                    deque.add(new Item(itemName, itemId));
                    System.out.println("New Item Added:" + itemName + " " + itemId);
                    Thread.currentThread().sleep(250);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

static class ItemConsumer implements Runnable {

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Item item;
            while ((item = deque.pollFirst()) != null) {
                if (item == null) {
                    //wait
                } else {
                    generateOrder(item);
                }
            }
        }

        private void generateOrder(Item item) {
            System.out.println("Part Order");
            System.out.println("Item description: " + item.getDescription());
            System.out.println("Item ID # " + item.getItemId());
            System.out.println();
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
}
    
    public static void main(String[] args) {
        Thread producerThread = new Thread(new ItemProducer());
        Thread consumerThread = new Thread(new ItemConsumer());
        producerThread.start();
        consumerThread.start();
    }

}
