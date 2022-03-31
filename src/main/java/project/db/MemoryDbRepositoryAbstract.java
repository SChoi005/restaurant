package project.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{
    
    private final List<T> db = new ArrayList<>();
    private Integer index = 0;
    
    @Override
    public Optional<T> findById(Integer index) {
        return db.stream().filter(it->it.getIndex()==index).findFirst();
    }
    
    @Override
    public T save(T entity) {
        
        Optional<T> optionalEntity = db.stream().filter(it -> it.getIndex()==entity.getIndex()).findFirst();
        
        if(optionalEntity.isPresent()==false){
            // db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{
            // db에 데이터가 이미 있는 경우
            Integer preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);
            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }
    
    @Override
    public void deleteById(Integer index) {
        Optional<T> optionalEntity = db.stream().filter(it -> it.getIndex()==index ).findFirst();
        
        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());
        }
    }
    
    @Override
    public List<T> listAll() {
        return db;
    }
    
}