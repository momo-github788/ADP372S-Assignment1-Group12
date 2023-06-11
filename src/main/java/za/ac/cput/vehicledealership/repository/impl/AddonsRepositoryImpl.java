package za.ac.cput.vehicledealership.repository.impl;
/*  AddonsRepositoryImpl.java
    Repository Class for Addons Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.repository.AddonsRepository;

import java.util.HashSet;
import java.util.Set;

public class AddonsRepositoryImpl implements AddonsRepository {

    private static AddonsRepositoryImpl addonsRepository = null;
    private Set<Addons> addonsDB = null;

    private AddonsRepositoryImpl(){
        addonsDB = new HashSet<Addons>();
    }

    public static AddonsRepositoryImpl getAddonsRepository(){
        if(addonsRepository == null){
            addonsRepository = new AddonsRepositoryImpl();
        }
        return addonsRepository;
    }
    @Override
    public Addons create(Addons addons) {
        boolean success = addonsDB.add(addons);
        if(!success){
            return null;
        }
        return addons;
    }

    @Override
    public Addons read(String addonId) {
        Addons addons = addonsDB
                .stream()
                .filter(a -> a.getAddonId().equals(addonId))
                .findAny()
                .orElse(null);
        return addons;
    }

    @Override
    public Addons update(Addons addons) {
       Addons oldAddons = read(addons.getAddonId());
       if(oldAddons != null){
            addonsDB.remove(oldAddons);
            addonsDB.add(addons);
            return addons;
       }
       return null;
    }

    @Override
    public boolean delete(String addonsId) {
        Addons addonsToDelete = read(addonsId);
        if(addonsToDelete == null)
            return false;
        addonsDB.remove(addonsToDelete);
        return true;
    }

    @Override
    public Set<Addons> getAll(){return addonsDB;}


}
