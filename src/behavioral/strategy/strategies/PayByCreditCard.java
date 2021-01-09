package behavioral.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public boolean pay(int paymentAmount) {
        if(cardIsPresent()){
            System.out.println("Paying " + paymentAmount + " using credit card.");
            creditCard.setAmount(creditCard.getAmount() + paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try{
            System.out.println("Enter the credit card number: ");
            String number = READER.readLine();
            System.out.println("Enter the card expiration date MM/YY: ");
            String expiration = READER.readLine();
            System.out.println("Enter the CVV code: ");
            String cvv = READER.readLine();
            this.creditCard = new CreditCard(number, cvv, expiration);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private boolean cardIsPresent(){
        return creditCard != null;
    }

}
