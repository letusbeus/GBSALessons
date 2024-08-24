package store;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(Order order) {
        //TODO: cancel order
        return true;
    }

    public boolean paymentOrder(Order order) {
        //TODO: payment order
        return true;
    }
}
