package Main;

import Model.*;
import Repository.*;
import Service.ProductService;
import Utils.DbHandler;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //DbHandler.getInstance();
        Description test_desc = new Description(1,"produs in brutaria personala");
        Description test_desc1 = new Description(2,"crescut in conditii bio");
        ProductName test_prod_name = new ProductName(1,"Milka","biscuiti ciocolata");
        Stock test_stock = new Stock(1,1200,10);
        Product test_produc = new Product(1,test_prod_name,test_stock,test_desc,"30");
        Category test_cat=new Category(1,"Brutarie",test_desc);
        Category test_update = new Category(4,"Macelarie",test_desc);
       // System.out.println(test_cat.getName());
        //System.out.println(test_cat.getDescription().toString());
        //DescriptionRepository.getInstance().addDescription(test_desc1);
        //CategoryRepository.getInstance().addCategory(test_cat);
        //System.out.println( CategoryRepository.getInstance().findCategoryById(2));
        //HashSet<Category> categories = CategoryRepository.getInstance().findCategories();
        //for (Category c : categories)
          //  System.out.println(c);
       // CategoryRepository.getInstance().deleteCategoryByName("Brutarie");
        //CategoryRepository.getInstance().updateCategory(test_update);
     //   HashSet<Description> descriptions = DescriptionRepository.getInstance().findDescriptions();
       // for (Description d : descriptions)
         // System.out.println(d);

        //System.out.println( DescriptionRepository.getInstance().findDescriptionById(1));
        //DescriptionRepository.getInstance().deleteDescriptionByName("crescut in conditii bio");


       // ProductNameRepository.getInstance().addProductName(test_prod_name);
        //StockRepository.getInstance().addStock(test_stock);
        //ProductRepository.getInstance().addProduct(test_produc);
        ProductService userService = new ProductService();
        userService.addProduct(test_produc);

    }
}
