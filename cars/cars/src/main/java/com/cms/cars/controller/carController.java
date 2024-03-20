package com.cms.cars.controller;

import com.cms.cars.model.cars;
import com.cms.cars.model.response;
import com.cms.cars.services.carService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class carController {
    @Autowired private carService service;

    /*
     Method: Post,
     description: it will create car entry in our database
     response: response model with status code
     */

    @PostMapping("/register")
    public response addCar(@RequestBody cars car){
        cars newcar = null;
        try{
            newcar = service.createCars(car);
            return new response("201","car created successfully",newcar);
        }catch (Exception e){
            System.out.println(e);
            return new response("500","Internal server error",newcar);
        }
    }

      /*
     Method: Get,
     description: it will fetch details of car entry from our database
     response: response model with status code
     */

    @GetMapping("/allcars")
    public response getCars(){
        List<cars> carsList = new ArrayList<>();
        carsList = service.fetchCars();
        if(carsList!=null){
            return new response("200","Data fetched successfully",carsList);
        }
        return new response("404","Data not found",carsList);
    }

    /*
   Method: Put,
   description: it will update car entry in our database
   response: response model with status code
   */
    @PutMapping("/{id}")
    public  response updateCar(@RequestBody cars car,@PathVariable("id") String id){
        cars newcar=null;
        newcar = service.updateCar(car,id);
        if(newcar!=null){
            return new response("200","Data updated successfully",newcar);
        }
        return new response("500","Internal Server error",newcar);
    }

    /*
   Method: delete,
   description: it will delete car entry in our database
   response: response model with status code
   */
    @DeleteMapping("/{id}")
    public response deleteCustomer(@PathVariable("id") String id){
        try{
            service.deleteCar(id);
            return new response("204","car deleted successfully",id);
        }
        catch (Exception e){
            return new response("500","Internal server error",id);
        }
    }

    /*
   Method: Get,
   description: it will first filter the data by type in our database and then will sort it according to manufacture date
   response: response model with status code
   */
    @GetMapping("/fetchandsort/{type}")
    public response fetchandsort(@PathVariable("type") String type){
        List<cars> carsList = new ArrayList<>();
        carsList = service.fetchbyTypeandsortbyDate(type);
        if(carsList!=null){
            return new response("200","Data fetched successfully",carsList);
        }
        return new response("404","Data not found",carsList);
    }

}
