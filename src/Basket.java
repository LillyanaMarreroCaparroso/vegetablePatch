public class Basket {

    private String vegetable;
    private String array[];
    private int next;
    private boolean isEmpty;
    private boolean isFull;

    public Basket(int capacity) {
        this.array = new String[capacity];
        this.next = 0;
        this.isEmpty = true;
        this.isFull = false;
    }

    synchronized public void produce(String vegetable) throws InterruptedException {
        while (this.isFull) {
            wait();
        }

        array[next] = vegetable;
        next++;

        this.isEmpty = false;
        if (next == this.array.length) {
            this.isFull = true;
        }
        notifyAll();
    }

    synchronized public String comsume() throws InterruptedException {
        while(this.isEmpty) {
            wait();
        }
        next --;
        this.isFull = false;
        if (next == 0) {
            this.isEmpty = true;
        }
        notifyAll();

        return this.array[this.next];
    }

}
