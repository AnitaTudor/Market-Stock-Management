package Repository;

import Model.Company;
import Model.Description;

import java.util.ArrayList;

public class DescriptionRepository {

    ArrayList<Description> descriptions= new ArrayList<Description>();
    public static DescriptionRepository instance = null;

    public void addDescription(Description description) {
        descriptions.add(description);

    }


    public ArrayList<Description> findDescriptions() {
        return descriptions;

    }

    public Description findDescriptionById(Integer id) {
        return descriptions.get(id);
    }

    public void deleteDescriptionByName(String name) {

        for(int i=0 ; i<descriptions.size();i++)
        {
            if(descriptions.get(i).getName()==name)
            {
                descriptions.remove(i);
            }

        }

    }

    public void updateDescription(Description description) {

        for(int i=0 ; i<descriptions.size();i++){
            if(descriptions.get(i)==description)
            {
                descriptions.set(i,description);

            }

        }
    }

    public static DescriptionRepository getInstance() {
        if (instance == null)
            instance = new DescriptionRepository();
        return instance;
    }



}
