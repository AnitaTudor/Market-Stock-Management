
package Model;

public class ProductName {
    private final Integer id;
    private String companyName;
    private String product;


    public ProductName(Integer id,String companyName, String product) {
        this.id = id;
        this.companyName = companyName;
        this.product = product;

    }

    public Integer getId() {
        return id;
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

}