import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<String> buffer;
    private final int messageCount;

    public Producer(BlockingQueue<String> buffer, int messageCount) {
        this.buffer = buffer;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= messageCount; i++) {
                String message = "Message " + i;
                buffer.put(message); // Add message to the buffer
                System.out.println("Produced: " + message);
                Thread.sleep(500); // Simulate delay in message production
            }
            buffer.put("DONE"); // Signal the consumer to stop
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> buffer;

    public Consumer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            String message;
            while (!(message = buffer.take()).equals("DONE")) { // Consume messages until "DONE" is received
                System.out.println("Consumed: " + message);
                Thread.sleep(1000); // Simulate delay in message consumption
            }
            System.out.println("No more messages to consume. Consumer is stopping.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MessagingApp {
    public static void main(String[] args) {
        BlockingQueue<String> sharedBuffer = new LinkedBlockingQueue<>(5); // Shared buffer with a capacity of 5 messages
        int messageCount = 10; // Number of messages to produce

        Producer producer = new Producer(sharedBuffer, messageCount);
        Consumer consumer = new Consumer(sharedBuffer);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        // Start the producer and consumer threads
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Messaging application has completed.");
    }
}
