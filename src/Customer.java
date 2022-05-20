public class Customer {
    ATMCard atm;

    public Customer(){
        atm = new ATMCard();
        atm.setPin(1234);
        atm.setBalance(50_000);
    }


    public void addBalance(int newBalance){

        atm.setBalance(atm.getBalance() + newBalance);
    }

    public void decBalance(int amount){
        atm.setBalance(atm.getBalance() - amount);
    }
}
