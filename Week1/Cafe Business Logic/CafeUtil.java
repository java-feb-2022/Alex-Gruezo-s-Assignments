import java.util.ArrayList;



public class CafeUtil {
    
    public int getStreakGoal(int numWeeks) {
        
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {

        double sum = 0;
        for (double i = 0; i < prices.length; i++) {
            sum += i;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {

        for (int i = 0; i < menuItems.size(); i++) {
            String drinks = menuItems.get(i);
            System.out.println(i + " " + drinks);
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name");
        String userName = System.console().readLine();
        System.out.printf("Hello %s. ", userName);
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(userName);
        System.out.println(customers);
        

    }

    // Sensei Bonus

    public void printPriceChart(String product, double price, int maxQuantity) {
        
        System.out.printf("%s\n", product);

        for (int i = 1; i <= maxQuantity; i++) {
            double total = (price*i);
            System.out.printf("%s - $%.2f\n", i, total);
        }

    }

    // Senpai Bonus

    public void quantityDiscount(String product, double price, int maxQuantity) {

        System.out.printf("%s\n", product);

        for (int i = 1; i <= maxQuantity; i++) {
            double total = (price*i)-(.5*(i-1));
            System.out.printf("%s - $%.2f\n", i, total);
        }

    }

    public boolean displayMenu(ArrayList<String>menuItems, ArrayList<Double>prices) {
        
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s - - $%.2f\n", i, menuItems.get(i), prices.get(i));
        }
        return true;
        }

    // Sensei Bonus

    public void addCustomers2(ArrayList<String> customers2) {
        boolean done = false;
        while (!done) {
            System.out.println("Please enter a customer name or press q to quit:");
            String customer = System.console().readLine();
            if (customer.equals("q")) {
                done = true;
                return;
            }
            customers2.add(customer);

            System.out.println(customers2);
        }
    }      
        
}