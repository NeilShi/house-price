import houseprice.Application;
import houseprice.nonentity.criteria.SearchLocationCriteria;
import houseprice.service.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void testGetDistrict() {
        SearchLocationCriteria criteria = new SearchLocationCriteria();
        criteria.setCity("cq");
        List<Map<String, String>> districtMap = locationService.searchDistrict(criteria);
        Assert.assertThat(districtMap.size(), greaterThan(0));
    }

    @Test
    public void testGetArea() {
        SearchLocationCriteria criteria = new SearchLocationCriteria();
        criteria.setCity("cq");
        criteria.setDistrict("jiangbei");
        List<Map<String, String>> areaMap = locationService.searchArea(criteria);
        Assert.assertThat(areaMap.size(), greaterThan(0));
    }
}
