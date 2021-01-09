package behavioral.strategy.strategies;

public class CreditCard {
    private int amount;
    private String name;
    private String cvv;
    private String date;

    public CreditCard(String name, String cvv, String date) {
        this.amount = 100_000;
        this.name = name;
        this.cvv = cvv;
        this.date = date;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }
}
