package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.wishlist.dto.WishListDto;
import project.wishlist.service.WishListService;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController{
    
    private final WishListService wishListService;
    
    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }
    
    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto){
        log.info("{}",wishListDto);
        return wishListService.add(wishListDto);
    }
    
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }
    
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }
    
    @PostMapping("/{index}")
    public void addVisit(int index){
        wishListService.addVisit(index);
    }
}