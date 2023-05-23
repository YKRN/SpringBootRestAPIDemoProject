package com.example.springbootrestapidemoproject.controller;

import com.example.springbootrestapidemoproject.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    /*
        @GetMapping
        @ResponseStatus(HttpStatus.CREATED)
        public List<City> getCitiesOther(){

            City city1=new City(67,"Zonguldak");
            City city2=new City(35,"İzmir");
            List<City> cities= Arrays.asList();

            return  Arrays.asList(city1,city2);

        }

     */
    public final List<City> cities = new ArrayList<>();

    public CityController() {

        City city1 = new City(67, "Zonguldak");
        City city2 = new City(35, "İzmir");
        cities.add(city1);
        cities.add(city2);
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
/*
    City city1=new City(67,"Zonguldak");
    City city2=new City(35,"İzmir");
    List<City> cities= Arrays.asList(city1,city2);
*/
        return new ResponseEntity<>(cities, HttpStatus.OK);

    }
    private City getCityById(String id){


        return cities.stream().filter(city -> String.valueOf(city.getId()).equals(id)).findAny().orElseThrow(() -> new RuntimeException("City not found"));

    }
    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {
        City result =getCityById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCity) {
        cities.add(newCity);


        newCity.setDate(new Date());
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id,@RequestBody City newCity) {
    City oldCity = getCityById(id);
    oldCity.setName(newCity.getName());
    oldCity.setDate(new Date());
return  new ResponseEntity<>(getCityById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id){
City willDelete =getCityById(id);
cities.remove(willDelete);
return new ResponseEntity<>(HttpStatus.OK);

    }
}
