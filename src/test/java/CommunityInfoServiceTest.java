import houseprice.Application;
import houseprice.domain.Community;
import houseprice.nonentity.criteria.SearchCommunityCriteria;
import houseprice.nonentity.vo.CommunityInfoVo;
import houseprice.service.CommunityInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CommunityInfoServiceTest {
    @Autowired
    private CommunityInfoService communityInfoService;

    @Test
    public void testCrawlCommunityInfo() {
        SearchCommunityCriteria criteria = new SearchCommunityCriteria();
        criteria.setCity("cq");
        criteria.setDistrict("yubei");
        criteria.setArea("zhaomushan");
        List<CommunityInfoVo> resultVoList = communityInfoService.crawlCommunityInfo(criteria);
        Assert.assertThat(resultVoList.size(), greaterThan(0));
    }

    @Test
    public void testSearchCommunity() {
        String id = "67";
        Community result = communityInfoService.searchCommunity(id);
        Assert.assertThat(result, notNullValue(Community.class));
    }

    /**
     *  @Transactional注解
     *  支持事务回滚，不会持久化数据
     *  添加 @Rollback(false) 关闭回滚
     */
    @Test
    @Transactional
    public void testSaveCommunity() {
        List<CommunityInfoVo> communityInfoVoList = new ArrayList<>();
        communityInfoVoList.add(new CommunityInfoVo(2019, 8, "aaa", "aaa",
                "aaa", "aaa", "0", "0"));
        int result = communityInfoService.saveCommunity(communityInfoVoList);
        Assert.assertThat(result, is(1));
    }
}
