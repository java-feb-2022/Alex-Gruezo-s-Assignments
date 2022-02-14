import java.util.ArrayList;



public class TestCafe {
    public static void main(String[] args) {
        
    /* 
      You will need add 1 line to this file to create an instance 
      of the CafeUtil class. 
      Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil appTest = new CafeUtil();
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(4));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("\n----- Price Chart Test -----");
        double price = 1.50;
        int quantity = 3;
        appTest.printPriceChart("Bustelo", price, quantity);

        System.out.println("\n----- Quantity Discount -----");
        double cost = 1.75;
        int amount = 5;
        appTest.quantityDiscount("Kona Coffee", cost, amount);

        System.out.println("\n----- Overloaded Display Menu -----");
        ArrayList<String> menu2 = new ArrayList<String>();
        menu2.add("drip coffee");
        menu2.add("cappuccino");
        menu2.add("latte");
        menu2.add("mocha");

        ArrayList<Double> price2 = new ArrayList<Double>();
        price2.add(1.50);
        price2.add(3.50);
        price2.add(4.50);
        price2.add(3.50);
        // uncomment below to return false
        // price2.add(1.50); 

        appTest.displayMenu(menu2, price2);

        // Sensei Bonus Test
        System.out.println("\n----- Add Customer Sensei Method -----");
        ArrayList<String> customers2 = new ArrayList<String>();
        appTest.addCustomers2(customers2);
    }
}
