public class Consumer extends Thread{

    private Basket basket;

    public Consumer(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        while(true) {
            try {
                String vegetable = this.basket.comsume();
                System.out.println("Consumido : " + vegetable);

                sleep((int) (Math.random() * 5000));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
