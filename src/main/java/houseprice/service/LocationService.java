package houseprice.service;

import houseprice.annotation.RedisCache;
import houseprice.constant.CityEnum;
import houseprice.nonentity.criteria.SearchLocationCriteria;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Value("${spider.district.url}")
    private String DISTRICT_URL;

    @Value("${spider.area.url}")
    private String AREA_URL;

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    private RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
            return restTemplate;
        } else {
            return restTemplate;
        }
    }

    private HttpHeaders getHeaders() {
        if (headers == null) {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return headers;
        } else {
            return headers;
        }
    }

    public List<Map<String, String>> searchCity() {
        return Arrays.stream(CityEnum.values()).map(cityEnum -> {
            Map<String, String> city = new HashMap<>();
            city.put(cityEnum.getCode(), cityEnum.getName());
            return city;
        }).collect(Collectors.toList());
    }

    @RedisCache
    public List<Map<String, String>> searchDistrict(SearchLocationCriteria criteria) {
        HttpEntity<SearchLocationCriteria> request = new HttpEntity<>(criteria, getHeaders());
        ResponseEntity<List<Map<String, String>>> response = getRestTemplate().exchange(DISTRICT_URL, HttpMethod.POST, request,
                new ParameterizedTypeReference<List<Map<String, String>>>() {});
        return response.getBody();
    }

    @RedisCache
    public List<Map<String, String>> searchArea(SearchLocationCriteria criteria) {
        HttpEntity<SearchLocationCriteria> request = new HttpEntity<>(criteria, getHeaders());
        ResponseEntity<List<Map<String, String>>> response = getRestTemplate().exchange(AREA_URL, HttpMethod.POST, request,
                new ParameterizedTypeReference<List<Map<String, String>>>() {});
        return response.getBody();
    }
}
