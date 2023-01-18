public class Main {
    public static void main(String[] args) {


        Basket bastek = new Basket(5);
        Producer producer = new Producer(bastek);
        Consumer consumer = new Consumer(bastek);

        producer.start();


    }
}