package co.nz.csoft.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.nz.csoft.elasticsearch.model.CityProperty;
import co.nz.csoft.elasticsearch.service.CityPropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/city-property")
public class CityPropertyController {

    @Autowired
    private CityPropertyService cityPropertyService;

    // Endpoint to populate the city-property index
    @PostMapping("/cityWiseProperty")
    public String createCityPropertyIndex() throws Exception {
        cityPropertyService.createCityPropertyIndex();
        return "City-Property index created successfully!";
    }

    // Endpoint to get property names by city
    @GetMapping("/by-city")
    public List<CityProperty> getPropertiesByCity(@RequestParam String city) {
        return cityPropertyService.getPropertiesByCity(city);
    }
}
