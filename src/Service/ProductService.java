package Service;

import Model.Description;
import Model.Product;
import Model.ProductName;
import Repository.ProductRepository;

public class ProductService {

public void addProduct(Product product){
    System.out.println("Adding a product to catalog");
    ProductRepository.getInstance().addProduct(product);
    System.out.println("Done adding product");

}

}
