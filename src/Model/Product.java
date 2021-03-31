package Model;

public class Product {

    private final Integer id;
    private ProductName name;
    private Stock stock ;
    private Description description;
    private String Quantity;

    public Product(Integer id, ProductName name, Stock stock, Description description, String quantity) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.description = description;
        Quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public void setName(ProductName name) {
        this.name = name;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
