package project.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T>{
    
    Optional<T> findById(Integer index); //r
    T save(T entity);                //c
    void deleteById(Integer index);      //d
    List<T> listAll();               //r
    
}