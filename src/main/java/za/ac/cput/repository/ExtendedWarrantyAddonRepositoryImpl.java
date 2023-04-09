package za.ac.cput.repository;
/*  ExtendedWarrantyAddonRepositoryImpl.java
    Repository Class for ExtendedWarrantyAddon Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 8 April 2023
*/


import za.ac.cput.domain.ExtendedWarrantyAddon;

import java.util.HashSet;
import java.util.Set;

public class ExtendedWarrantyAddonRepositoryImpl implements IExtendedWarrantyAddonRepository{

    private static ExtendedWarrantyAddonRepositoryImpl extendedWarrantyAddonRepository = null;

    private Set<ExtendedWarrantyAddon> extendedWarrantyAddonDB = null;

    private ExtendedWarrantyAddonRepositoryImpl(){
        this.extendedWarrantyAddonDB = new HashSet<>();
    }

    public static ExtendedWarrantyAddonRepositoryImpl getExtendedWarrantyAddonRepository(){
        if(extendedWarrantyAddonRepository == null) {
            extendedWarrantyAddonRepository = new ExtendedWarrantyAddonRepositoryImpl();
        }
        return extendedWarrantyAddonRepository;
    }
    @Override
    public ExtendedWarrantyAddon create(ExtendedWarrantyAddon extendedWarrantyAddon) {
        boolean success = extendedWarrantyAddonDB.add(extendedWarrantyAddon);

        if(!success){
            return null;
        }
        return extendedWarrantyAddon;
    }

    @Override
    public ExtendedWarrantyAddon read(String addonId) {
    ExtendedWarrantyAddon extendedWarrantyAddon = extendedWarrantyAddonDB
                .stream()
                .filter(e -> e.getAddonId().equals(addonId))
                .findAny()
                .orElse(null);
    return extendedWarrantyAddon;
    }


    @Override
    public ExtendedWarrantyAddon update(ExtendedWarrantyAddon extendedWarrantyAddon) {
        ExtendedWarrantyAddon oldExtendedWarrantyAddon = read(extendedWarrantyAddon.getAddonId());
        if(oldExtendedWarrantyAddon != null){
            extendedWarrantyAddonDB.remove(oldExtendedWarrantyAddon);
            extendedWarrantyAddonDB.add(extendedWarrantyAddon);
            return extendedWarrantyAddon;
        }
        return null;
    }

    @Override
    public boolean delete(String addonId) {
        ExtendedWarrantyAddon extendedWarrantyAddon = read(addonId);
        if(extendedWarrantyAddon == null){
        return false;}
        extendedWarrantyAddonDB.remove(extendedWarrantyAddon);
        return true;
    }

    @Override
    public Set<ExtendedWarrantyAddon> getAll() { return extendedWarrantyAddonDB;}
}
