package za.ac.cput.repository;
/*  ServicingAddonRepositoryImpl.java
    Repository Class for ServicingAddon Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/
import za.ac.cput.domain.ServicingAddon;

import java.util.HashSet;
import java.util.Set;

public class ServicingAddonRepositoryImpl implements IServicingAddon{


    private static ServicingAddonRepositoryImpl servicingAddonRepository = null;

    private Set<ServicingAddon> servicingAddonDB = null;

    private ServicingAddonRepositoryImpl(){this.servicingAddonDB = new HashSet<>();
    }

    public static ServicingAddonRepositoryImpl getServicingAddonRepository(){
        if(servicingAddonRepository == null){
            servicingAddonRepository = new ServicingAddonRepositoryImpl();
        }
        return servicingAddonRepository;
    }

    @Override
    public ServicingAddon create(ServicingAddon servicingAddon) {
        boolean success = servicingAddonDB.add(servicingAddon);

        if (!success) {
            return null;
        }
        return servicingAddon;
    }

    @Override
    public ServicingAddon read(String addonId) {
        ServicingAddon servicingAddon = servicingAddonDB
                .stream()
                .filter(s -> s.getAddonId().equals(addonId))
                .findAny()
                .orElse(null);
        return servicingAddon;
    }

    @Override
    public ServicingAddon update(ServicingAddon servicingAddon) {
       ServicingAddon oldServicingAddon = read(servicingAddon.getAddonId());
       if(oldServicingAddon != null){
           servicingAddonDB.remove(oldServicingAddon);
           servicingAddonDB.add(servicingAddon);
           return servicingAddon;
       }
       return null;
    }

    @Override
    public boolean delete(String addonId) {
        ServicingAddon servicingAddon = read(addonId);
        if(servicingAddon == null){
        return false;}
        servicingAddonDB.remove(servicingAddon);
        return true;
    }

    @Override
    public Set<ServicingAddon> getAll() {return servicingAddonDB;}


}
