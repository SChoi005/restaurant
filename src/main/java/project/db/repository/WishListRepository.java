package project.db.repository;

import org.springframework.stereotype.Repository;

import project.db.MemoryDbRepositoryAbstract;
import project.wishlist.entity.WishListEntity;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity>{
    
}