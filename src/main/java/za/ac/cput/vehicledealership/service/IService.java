package za.ac.cput.vehicledealership.service;

/*  IService.java
    Generic Service Interface
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

public interface IService<T, ID> {
    T create(T type);
    T read(ID id);
    T update(T type);
    boolean delete(ID id);
}
