public class Producer extends  Thread{

    private Basket basket;
    private String vegetable;

    public Producer(Basket basket) {
        this.basket = basket;
    }

    public String randomVegetable() {
        String vegetables[] = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke"};

        int index = (int) (Math.random() * vegetables.length);
        vegetable = vegetables[index];

        return vegetable;
    }

    public void run(){

        while (true) {

            try {

                String vegetable = randomVegetable();
                basket.produce(vegetable);
                System.out.println("Producido : " + vegetable);

                sleep((int) (Math.random() * 5000));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


