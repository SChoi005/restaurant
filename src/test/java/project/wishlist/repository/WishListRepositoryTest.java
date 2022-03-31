package project.wishlist.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.ApplicationTests;
import project.db.repository.WishListRepository;
import project.wishlist.entity.WishListEntity;

public class WishListRepositoryTest extends ApplicationTests{
    
    @Autowired
    private WishListRepository wishListRepository;
    
    private WishListEntity create(){
        WishListEntity wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("roadAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }
    
    //@Test
    public void saveTest(){
        WishListEntity wishListEntity = create();
        WishListEntity expected = wishListRepository.save(wishListEntity);
        
        Assert.assertNotNull(expected);
        //Assert.assertEquals(1, expected.getIndex());
        
    }
    
    //@Test
    public void updateTest(){
        WishListEntity wishListEntity = create();
        WishListEntity expected = wishListRepository.save(wishListEntity);
        
        System.out.println(expected);
        
        expected.setTitle("update test");
        WishListEntity saveEntity = wishListRepository.save(expected);

        System.out.println(saveEntity);
        
        Assert.assertNotNull("update test", saveEntity.getTitle());
        Assert.assertEquals(1, wishListRepository.listAll().size());
        
    }
    
    //@Test
    public void findByIdTest(){
        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);
        Optional<WishListEntity> expected = wishListRepository.findById(1);
        
        Assert.assertEquals(true, expected.isPresent());
        //Assert.assertEquals(1, expected.get().getIndex());
        
    }
    
    //@Test
    public void deleteTest(){
        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);
        
        wishListRepository.deleteById(1);
        
        int count = wishListRepository.listAll().size();
        Assert.assertEquals(0, count);
    }
    
    //@Test
    public void listAllTest(){
        WishListEntity wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);
        WishListEntity wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);
        
        int count = wishListRepository.listAll().size();
        Assert.assertEquals(2, count);
    }
}