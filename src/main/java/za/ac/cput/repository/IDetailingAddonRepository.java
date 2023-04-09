package za.ac.cput.repository;

import za.ac.cput.domain.DetailingAddon;

import java.util.Set;

public interface IDetailingAddonRepository extends IRepository<DetailingAddon, String>{

    public Set<DetailingAddon> getAll();
}
