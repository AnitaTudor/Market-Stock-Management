package Utils;

import Model.*;

import java.util.HashMap;

public class IdGenerator {

    private static IdGenerator instance= null;
    private HashMap<Class<?>, Integer> idMap;

    private IdGenerator()
    {
        idMap = new HashMap<>();
        idMap.put(Category.class, 0);
        idMap.put(Company.class, 0);
        idMap.put(Description.class, 0);
        idMap.put(Location.class, 0);
        idMap.put(Product.class, 0);
        idMap.put(ProductName.class, 0);
        idMap.put(Provider.class, 0);
        idMap.put(Stock.class, 0);
        idMap.put(SubCategory.class,0);

    }

    public static IdGenerator getInstance() {
        if (instance == null)
            instance = new IdGenerator();
        return instance;
    }

    public Integer genId(Class<?> cls) {
        idMap.put(cls, idMap.get(cls) + 1);
        return idMap.get(cls);
    }

}
