
package Model;

public class ProductName {
    private String companyName;
    private String product;
    private Description description;

    public ProductName(String companyName, String product, Description description) {
        this.companyName = companyName;
        this.product = product;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}