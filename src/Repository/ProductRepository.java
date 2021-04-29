package Repository;

import Model.Product;

import java.util.ArrayList;

public class ProductRepository {

    ArrayList<Product> products= new ArrayList<Product>();
    public static ProductRepository instance = null;

    public void addProduct(Product product) {
        products.add(product);

    }


    public ArrayList<Product> findProducts() {
        return products;

    }

    public Product findProductById(Integer id) {
        return products.get(id);
    }

    public void deleteProductByName(String name) {

        for(int i=0 ; i<products.size();i++)
        {
            if(products.get(i).getName().getCompanyName()==name)
            {
                products.remove(i);
            }

        }

    }

    public void updateProduct(Product product) {

        for(int i=0 ; i<products.size();i++){
            if(products.get(i)==product)
            {
                products.set(i,product);

            }

        }
    }
    public static ProductRepository getInstance() {
        if (instance == null)
            instance = new ProductRepository();
        return instance;
    }


}
