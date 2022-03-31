package project.naver;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.ApplicationTests;
import project.naver.dto.SearchImageReq;
import project.naver.dto.SearchImageRes;
import project.naver.dto.SearchLocalReq;
import project.naver.dto.SearchLocalRes;

public class NaverClientTest extends ApplicationTests{
    @Autowired
    private NaverClient naverClient;
    
    //@Test
    public void searchLocalTest(){
        SearchLocalReq search = new SearchLocalReq();
        
        search.setQuery("갈비집");
        
        SearchLocalRes result = naverClient.searchLocal(search);
        System.out.println(result);
        
    }
    
    //@Test
    public void searchImageTest(){
        SearchImageReq search = new SearchImageReq();
        
        search.setQuery("갈비집");
        
        SearchImageRes result = naverClient.searchImage(search);
        System.out.println(result);
        
    }
}