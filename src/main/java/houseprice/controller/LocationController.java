package houseprice.controller;

import houseprice.nonentity.criteria.SearchLocationCriteria;
import houseprice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping("/city")
    public List<Map<String, String>> searchCity() {
        return locationService.searchCity();
    }

    @RequestMapping("/district")
    public List<Map<String, String>> searchDistrict(@RequestBody SearchLocationCriteria criteria) {
        return locationService.searchDistrict(criteria);
    }

    @RequestMapping("/area")
    public List<Map<String, String>> searchArea(@RequestBody SearchLocationCriteria criteria) {
        return locationService.searchArea(criteria);
    }
}
