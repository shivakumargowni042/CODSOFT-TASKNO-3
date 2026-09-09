package src;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String orderId;
    private String customerName;
    private String customerEmail;
    private String address;
    private String phone;
    private List<CartItem> items;
    private double subtotal;
    private double gst;
    private double total;
    private long timestamp;

    public Booking() {}

    public Booking(String orderId, String customerName, String customerEmail, String address,
                   String phone, List<CartItem> items, double subtotal, double gst, double total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.address = address;
        this.phone = phone;
        this.items = new ArrayList<>(items);
        this.subtotal = subtotal;
        this.gst = gst;
        this.total = total;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getGst() { return gst; }
    public void setGst(double gst) { this.gst = gst; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
