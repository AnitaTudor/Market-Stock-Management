package Repository;

import Model.ProductName;

import java.util.ArrayList;

public class ProductNameRepository {

    ArrayList<ProductName> productNames= new ArrayList<ProductName>();
    public static ProductNameRepository instance =null;

    public void addProductName(ProductName productName) {
        productNames.add(productName);

    }


    public ArrayList<ProductName> findProductNames() {
        return productNames;

    }

    public ProductName findProductNameById(Integer id) {
        return findProductNames().get(id);
    }

    public void deleteProductNameByName(String name) {

        for(int i=0 ; i<productNames.size();i++)
        {
            if(productNames.get(i).getCompanyName()==name)
            {
                productNames.remove(i);
            }

        }

    }



    public void updateProductName(ProductName productName) {

        for(int i=0 ; i<productNames.size();i++){
            if(productNames.get(i)==productName)
            {
                productNames.set(i,productName);

            }

        }
    }

    public static ProductNameRepository getInstance() {
        if (instance == null)
            instance = new ProductNameRepository();
        return instance;
    }




}
