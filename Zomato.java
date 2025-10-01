import java.util.Scanner;

class Cooking extends Thread {
    Cooking(String name) { 
        super(name); 
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " cooking... step " + i);
            try {
                 Thread.sleep(500);
                 } catch (Exception e) {
                System.out.println(getName() + " error during cooking!");
            }
        }
    }
}


class Delivery extends Thread {
    Delivery(String name) {
         super(name); 
        }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " delivering... step " + i);
            try { 
                Thread.sleep(700);
             }
              catch (Exception e) {
                System.out.println(getName() + " error during delivery!");
            }
        }
    }
}

class Notification extends Thread {
    Notification(String name) { 
        super(name);
     }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " notifying customer... step " + i);
            try {
                 Thread.sleep(1000);
                 } catch (Exception e) {
                System.out.println(getName() + " error sending notification!");
            }
        }
    }
}

public class Zomato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orderNo = 1;

        while (true) {
            System.out.println("\n--- Zomato Menu ---");
            System.out.println("1. Place Order");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Thank you! Visit again.");
                break;
            } 
            else if (choice == 1) {
                System.out.println("Select Recipe:");
                System.out.println("1. idly");
                System.out.println("2. biryani");
                System.out.println("3. dosa");
                System.out.print("Your choice: ");
                int recipe = sc.nextInt();
                System.out.println("Recipe #" + recipe + " selected.");

             System.out.println("Placing Order #" + orderNo);

                Cooking cook = new Cooking("Cook-" + orderNo);
                Delivery deliver = new Delivery("Delivery-" + orderNo);
                Notification notify = new Notification("Notify-" + orderNo);

                cook.setPriority(10);       // High
                deliver.setPriority(5);     // Medium
                notify.setPriority(1);      // Low

                
                cook.start();
                deliver.start();
                notify.start();

                orderNo++;
            } else {
                System.out.println("oops! Try again.");
            }
        }

        sc.close();
    }
}