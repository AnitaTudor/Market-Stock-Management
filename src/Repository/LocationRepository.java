package Repository;


import Model.Location;

import java.util.ArrayList;

public class LocationRepository {

    ArrayList<Location> locations= new ArrayList<Location>();
    public static LocationRepository instance =null;

    public void addLocation(Location location) {
        locations.add(location);

    }


    public ArrayList<Location> findLocations() {
        return locations;

    }

    public Location findLocationById(Integer id) {
        return locations.get(id);
    }

    public void deleteLocationsByCity(String city) {

        for(int i=0 ; i<locations.size();i++)
        {
            if(locations.get(i).getCity()==city)
            {
                locations.remove(i);
            }

        }

    }

    public void deleteLocationsByAdressLineA(String adressA) {

        for(int i=0 ; i<locations.size();i++)
        {
            if(locations.get(i).getAddressLineA()==adressA)
            {
                locations.remove(i);
            }

        }

    }



    public void updateLocation(Location location) {

        for(int i=0 ; i<locations.size();i++){
            if(locations.get(i)==location)
            {
                locations.set(i,location);

            }

        }
    }

    public static LocationRepository getInstance() {
        if (instance == null)
            instance = new LocationRepository();
        return instance;
    }


}
