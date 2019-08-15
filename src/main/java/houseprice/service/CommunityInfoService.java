package houseprice.service;

import houseprice.nonentity.criteria.SearchCommunityCriteria;
import houseprice.nonentity.vo.CommunityInfoVo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommunityInfoService {
    private static final String URL = "http://127.0.0.1:5000/community";
    public List<CommunityInfoVo> searchCommunityInfo(SearchCommunityCriteria criteria) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SearchCommunityCriteria> request = new HttpEntity<>(criteria, headers);
        ResponseEntity<List<CommunityInfoVo>> response = restTemplate.exchange(URL, HttpMethod.POST, request,
                new ParameterizedTypeReference<List<CommunityInfoVo>>() {});
        return response.getBody();
    }
}
