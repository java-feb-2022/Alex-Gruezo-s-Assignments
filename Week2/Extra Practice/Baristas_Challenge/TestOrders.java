import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {

        // Menu Items
        
        Item item1 = new Item ("Cappucino", 4.50);
        Item item2 = new Item ("Doppio", 3.00);
        Item item3 = new Item ("Mocha", 5.25);
        Item item4 = new Item ("Latte", 4.00);
        
        // 2 Orders for unspecified guests

        Order order1 = new Order();
        Order order2 = new Order();

        // 3 Orders with overload constructor to give each a Name

        Order order3 = new Order ("John");
        Order order4 = new Order ("Jane");
        Order order5 = new Order ("William");

        // Add at least 2 items to each of the ordersAndItems

        order1.addItem(item2);
        order1.addItem(item4);

        order2.addItem(item1);
        order2.addItem(item3);

        order3.addItem(item3);
        order3.addItem(item4);

        order4.addItem(item4);
        order4.addItem(item1);

        order5.addItem(item1);
        order5.addItem(item2);

        // Test result and display methods on all orders

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
        
        // Test getStatusMessage method

        String order1Status = order1.getStatusMessage();
        System.out.println("\n" + order1Status);
        order3.setReady(true);
        String order3Status = order3.getStatusMessage();
        System.out.println(order3Status);

        // Implement and test getOrderTotal method
        double order4Total = order4.getOrderTotal();
        System.out.printf("\n$%.2f\n", order4Total);

    }

}