package Repository;

import Model.Category;

import java.util.ArrayList;

public class CategoryRepository {

    ArrayList<Category> categories= new ArrayList<Category>();


    public void addCategory (Category category) {
        categories.add(category);
    }


    public ArrayList<Category> findCategory() {
        return categories;

    }

    public Category findCategoryById(Integer id) {
        return categories.get(id);
    }

    public void deleteCategoryByName(String name) {

        for(int i=0 ; i<categories.size();i++)
        {
            if(categories.get(i).getName()==name)
            {
                categories.remove(i);
            }

        }

    }

    public void updateCategory(Category category) {

        for(int i=0 ; i<categories.size();i++){
            if(categories.get(i)==category)
            {
                categories.set(i,category);

            }

        }
    }


}