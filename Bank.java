public class Bank implements Runnable {
    static int balance = 0;

    static final Object lock = new Object();

    public void deposit() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
        balance += 100;
    }

    public void withdraw() {
        balance -= 100;
    }

    public int getValue() {
        return balance;
    }

    @Override
    public void run() {
        // --- CASE 1: BEFORE LOCK (Uncomment this section, Comment out Case 2) ---
        
        // deposit();
        // System.out.println("Value for " + Thread.currentThread().getName() + " after deposit: " + getValue());
        // withdraw();
        // System.out.println("Value for " + Thread.currentThread().getName() + " after withdraw: " + getValue());
         

        // --- CASE 2: AFTER LOCK (Uncomment this section, Comment out Case 1) ---
        synchronized (lock) {
            deposit();
            System.out.println("Value for " + Thread.currentThread().getName() + " after deposit: " + getValue());
            withdraw();
            System.out.println("Value for " + Thread.currentThread().getName() + " after withdraw: " + getValue());
        }
    }
}