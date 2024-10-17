class SharedBuffer {
    private int value = 0; // The single shared value between producer and consumer
    private boolean hasValue = false; // To check if the buffer has a value

    // Method for producer to produce a value
    public synchronized void produce() throws InterruptedException {
        while (true) {
            // If the buffer already has a value, producer should wait
            if (hasValue) {
                wait(); // Wait for consumer to consume the value
            }

            // Produce the next value
            value++;
            System.out.println("Produced: " + value);

            // Set flag to indicate buffer has a value
            hasValue = true;

            // Notify consumer that a value is available
            notify();

            // Simulate production time
            Thread.sleep(1000);
        }
    }

    // Method for consumer to consume a value
    public synchronized void consume() throws InterruptedException {
        while (true) {
            // If the buffer doesn't have a value, consumer should wait
            if (!hasValue) {
                wait(); // Wait for producer to produce a value
            }

            // Consume the value
            System.out.println("Consumed: " + value);

            // Set flag to indicate buffer is empty
            hasValue = false;

            // Notify producer that buffer is empty
            notify();

            // Simulate consumption time
            Thread.sleep(1500);
        }
    }
}

// Producer class
class Producer extends Thread {
    private SharedBuffer buffer;

    // Constructor to assign the shared buffer
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            buffer.produce(); // Call the produce method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Consumer class
class Consumer extends Thread {
    private SharedBuffer buffer;

    // Constructor to assign the shared buffer
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            buffer.consume(); // Call the consume method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Main class to run the producer-consumer problem
public class pra37 {
    public static void main(String[] args) {
        // Create a shared buffer object
        SharedBuffer buffer = new SharedBuffer();

        // Create producer and consumer threads
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Start the producer and consumer threads
        producer.start();
        consumer.start();
    }
}
