package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.City;
import za.ac.cput.vehicledealership.util.Helper;

public class CityFactory {
    public static City createCity(String name) {
        return new City.Builder()
                .setId(Helper.generateId())
                .setName(name)
                .build();
    }
}
