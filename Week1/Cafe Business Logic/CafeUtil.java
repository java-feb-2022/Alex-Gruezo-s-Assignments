import java.util.ArrayList;
import java.text.*;


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

    public void printPriceChart(String product, double price, int maxQuantity) {
        
        System.out.printf("%s\n", product);

        for (int i = 1; i <= maxQuantity; i++) {
            
            double total = (price*i);

            System.out.printf("%s - $%.2f\n", i, total);
        }

    }

    public void quantityDiscount(String product, double price, int maxQuantity) {

        System.out.printf("%s\n", product);

        for (int i = 1; i <= maxQuantity; i++) {

            double total = (price*i)-(.5*(i-1));

            System.out.printf("%s - $%.2f\n", i, total);
            
        }

    }
}