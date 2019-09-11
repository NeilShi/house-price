package houseprice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import houseprice.domain.Community;
import houseprice.nonentity.criteria.SearchCommunityCriteria;
import houseprice.nonentity.result.SearchCommunityInfoResult;
import houseprice.nonentity.vo.CommunityInfoVo;
import houseprice.service.CommunityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Community")
public class CommunityPriceController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CommunityInfoService communityInfoService;

    @RequestMapping("/crawling")
    public SearchCommunityInfoResult crawlingCommunityInfo(@RequestBody SearchCommunityCriteria criteria) {
        SearchCommunityInfoResult result = new SearchCommunityInfoResult();
        List<CommunityInfoVo> communityInfoVoList = communityInfoService.crawlCommunityInfo(criteria);
        communityInfoService.saveCommunity(communityInfoVoList);
        result.setSuccess(true);
        result.setCommunityInfoVoList(communityInfoVoList);
        try {
            mapper.writeValueAsString(result);  // todo return json or object?
        } catch (IOException e) {
            // todo
        }
        return result;
    }

    @RequestMapping("/search/{id}")
    public Community searchCommunity(@PathVariable("id") String id) {
        return communityInfoService.searchCommunity(id);
    }
}
