package project.naver;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import project.naver.dto.SearchImageReq;
import project.naver.dto.SearchImageRes;
import project.naver.dto.SearchLocalReq;
import project.naver.dto.SearchLocalRes;

@Component
public class NaverClient {

    @Value("${naver.client.id}")
    private String naverClientId;
    
    @Value("${naver.client.secret}")
    private String naverClientSecret;
    
    @Value("${naver.url.search.local}")    
    private String naverLocalSearchUrl;
    
    @Value("${naver.url.search.image}")    
    private String naverImageSearchUrl;
    
    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){
        
        
        //uri 작성
        URI uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
            .queryParams(searchLocalReq.toMultiValueMap())
            .build()
            .encode()
            .toUri();
        
        //header 작성
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference responseType = new ParameterizedTypeReference<SearchLocalRes>() {};
        
        ResponseEntity<SearchLocalRes> responseEntity = new RestTemplate().exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return responseEntity.getBody();
    }
    
    public SearchImageRes searchImage(SearchImageReq searchImageReq){
        //uri 작성
        URI uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
            .queryParams(searchImageReq.toMultiValueMap())
            .build()
            .encode()
            .toUri();
        
        //header 작성
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret",naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference responseType = new ParameterizedTypeReference<SearchImageRes>() {};
        
        ResponseEntity<SearchImageRes> responseEntity = new RestTemplate().exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return responseEntity.getBody();
    }
}