package project.wishlist.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;
import project.ApplicationTests;
import project.wishlist.dto.WishListDto;


public class WishListServiceTest extends ApplicationTests{

    
    @Autowired
    private WishListService wishListService;
    
    //@Test
    public void searchTest(){
        WishListDto result = wishListService.search("갈비집");
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}