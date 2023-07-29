package learning_1.week_4;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String categorieString;
    private double price;

    public Product() {

    }

    public Product(String id, String name, String categorieString, double price) {
        super();
        this.id = id;
        this.name = name;
        this.categorieString = categorieString;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorieString() {
        return categorieString;
    }

    public void setCategorieString(String categorieString) {
        this.categorieString = categorieString;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*@Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", categorieString=" + categorieString + ", price=" + price
                + "]";
    }*/
}
