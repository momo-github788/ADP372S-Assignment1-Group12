package za.ac.cput.repository;

/*  IRepository.java
    Generic Repository Interface
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

public interface IRepository<T, ID> {
    T create(T type);
    T read(ID id);
    T update(T type);
    boolean delete(ID id);
}
