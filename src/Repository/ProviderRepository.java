package Repository;

import Model.Provider;

import java.util.ArrayList;

public class ProviderRepository {
    ArrayList<Provider> providers= new ArrayList<Provider>();
    public static ProviderRepository instance =null;

    public void addProvider(Provider provider) {
        providers.add(provider);

    }


    public ArrayList<Provider> findProviders() {
        return providers;

    }

    public Provider findProviderById(Integer id) {
        return providers.get(id);
    }

    public void deleteProviderByName(String name) {

        for(int i=0 ; i<providers.size();i++)
        {
            if(providers.get(i).getName()==name)
            {
                providers.remove(i);
            }

        }

    }

    public void updateProvider(Provider provider) {

        for(int i=0 ; i<providers.size();i++){
            if(providers.get(i)==provider)
            {
                providers.set(i,provider);

            }

        }
    }

    public static ProviderRepository getInstance() {
        if (instance == null)
            instance = new ProviderRepository();
        return instance;
    }


}
