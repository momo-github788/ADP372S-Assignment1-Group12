package za.ac.cput.repository;
/*  DetailingAddonRepositoryImpl.java
    Repository Class for DetailingAddon Domain
    Author: Junaid Cedrass (219090912)
    Date: 8 April 2023
*/
import za.ac.cput.domain.DetailingAddon;
import za.ac.cput.domain.ServicingAddon;

import java.util.HashSet;
import java.util.Set;

public class DetailingAddonRepositoryImpl implements IDetailingAddonRepository{


    private static DetailingAddonRepositoryImpl detailingAddonRepository = null;

    private Set<DetailingAddon> detailingAddonDB = null;

    private DetailingAddonRepositoryImpl(){this.detailingAddonDB = new HashSet<>();
    }

    public static DetailingAddonRepositoryImpl getDetailingAddonRepository(){
        if(detailingAddonRepository == null){
            detailingAddonRepository = new DetailingAddonRepositoryImpl();
        }
        return detailingAddonRepository;
    }

    @Override
    public DetailingAddon create(DetailingAddon detailingAddon) {
        boolean success = detailingAddonDB.add(detailingAddon);

        if (!success) {
            return null;
        }
        return detailingAddon;
    }

    @Override
    public DetailingAddon read(String addonId) {
        DetailingAddon detailingAddon = detailingAddonDB
                .stream()
                .filter(s -> s.getAddonId().equals(addonId))
                .findAny()
                .orElse(null);
        return detailingAddon;
    }

    @Override
    public DetailingAddon update(DetailingAddon detailingAddon) {
        DetailingAddon oldDetailingAddon = read(detailingAddon.getAddonId());
        if(oldDetailingAddon != null){
            detailingAddonDB.remove(oldDetailingAddon);
            detailingAddonDB.add(detailingAddon);
            return detailingAddon;
        }
        return null;
    }

    @Override
    public boolean delete(String addonId) {
        DetailingAddon detailingAddon = read(addonId);
        if(detailingAddon == null){
            return false;}
        detailingAddonDB.remove(detailingAddon);
        return true;
    }

    @Override
    public Set<DetailingAddon> getAll() {return detailingAddonDB;}


}