package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    private long id;
    private String name;
    private String description;
    private String longDescription;
    private List<String[]> specs;
    private double price;
    private double originalPrice;
    private String category;
    private String image;
    private double rating;
    private int reviews;
    private boolean inStock;
    private String brand;
    private double discount;

    public Product(long id, String name, String description, double price, double originalPrice,
                   String category, String image, double rating, int reviews, boolean inStock,
                   String brand, double discount) {
        this(id, name, description, description, new ArrayList<>(), price, originalPrice,
             category, image, rating, reviews, inStock, brand, discount);
    }

    public Product(long id, String name, String description, String longDescription, List<String[]> specs,
                   double price, double originalPrice, String category, String image, double rating,
                   int reviews, boolean inStock, String brand, double discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        this.specs = specs;
        this.price = price;
        this.originalPrice = originalPrice;
        this.category = category;
        this.image = image;
        this.rating = rating;
        this.reviews = reviews;
        this.inStock = inStock;
        this.brand = brand;
        this.discount = discount;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLongDescription() { return longDescription; }
    public List<String[]> getSpecs() { return specs; }
    public double getPrice() { return price; }
    public double getOriginalPrice() { return originalPrice; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
    public double getRating() { return rating; }
    public int getReviews() { return reviews; }
    public boolean isInStock() { return inStock; }
    public String getBrand() { return brand; }
    public double getDiscount() { return discount; }

    static List<String[]> specs(String[][] rows) {
        return new ArrayList<>(Arrays.asList(rows));
    }
}
