package store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        Store store = new Store();

        Product product1 = new Product("AA1", 100);
        Product product2 = new Product("BB1", 200);
        Product product3 = new Product("CC1", 150);

        Buyer buyer1 = new Buyer("Buyer1");
        Buyer buyer2 = new Buyer("Buyer2");

        OrderItem orderItem1 = new OrderItem(product1, 2);
        OrderItem orderItem2 = new OrderItem(product2, 3);
        OrderItem orderItem3 = new OrderItem(product3, 1);

        List<OrderItem> items = new ArrayList<>();
        items.add(orderItem1);
        items.add(orderItem2);
        items.add(orderItem3);

        Order order1 = new Order(LocalDateTime.now(), "Address1", "+79876543210", buyer1, items);

        store.addOrder(order1);

        System.out.println(order1);

    }

}
