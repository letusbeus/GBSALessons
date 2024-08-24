package store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 10000;
    private int id;
    private LocalDateTime orderDate;
    private String address;
    private String phone;
    private Buyer buyer;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private List<OrderItem> items = new ArrayList<>();
    {
        id = ++counter;
    }

    public Order(LocalDateTime orderDate, String address, String phone, Buyer buyer, List<OrderItem> items) {

        if (buyer == null) {
            throw new RuntimeException("Buyer cannot be null");
        }
        if (items == null || items.size() == 0) {
            throw new RuntimeException("Order cannot be empty");
        }
        this.orderDate = orderDate;
        this.address = address;
        this.phone = phone;
        this.buyer = buyer;
        this.items = items;


    }

    @Override
    public String toString() {
        return "Order: \n" +
                "\tid: " + id +
                ",\n\torderDate: " + orderDate.toString() +
                ",\n\taddress: " + address +
                ",\n\tphone: " + phone +
                ",\n\tbuyer: " + buyer.getName() +
                ",\n\titems:\n" + items;
    }

}
