package store;

public class OrderItem {

    private static int counter = 5000;

    private int id;
    private Product product;
    private int qty;
    {
        id = ++counter;
    }
    public OrderItem(Product product){
        this.product = product;
        qty = 1;
    }
    public OrderItem(Product product, int qty){
        this.product = product;
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tid: ").append(id)
                .append(", product: ").append(product.getName())
                .append(", qty: ").append(qty).append("\n");
        return sb.toString();
    }
}
