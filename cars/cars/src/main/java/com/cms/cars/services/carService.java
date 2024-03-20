package com.cms.cars.services;

import com.cms.cars.model.cars;
import com.cms.cars.repository.carRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class carService {
    @Autowired
    private carRepository stdc;
    public cars createCars(cars car) {
        cars newCar = null;
        newCar = this.stdc.save(car);
        return newCar;
    }

    public List<cars> fetchCars() {
        List<cars> car =new ArrayList<>();
        car = this.stdc.findAll();
        return car;
    }

    public cars fetchCarbyId(String id) {
        Optional<cars> user = this.stdc.findById(id);
        if(user.isEmpty())return null;
        return user.get();
    }

    public cars updateCar(cars car,String id) {
        cars oldCar = this.fetchCarbyId(id);
         if(oldCar==null)return null;
        car = new cars(oldCar.id(), car.type(), car.manufactureDate(), car.company(),car.Model(),car.cost(),car.carName(),car.insurance());
        this.stdc.save(car);
        return car;
    }

    public void deleteCar(String id) {
        this.stdc.deleteById(id);
    }

    public List<cars> fetchbyTypeandsortbyDate(String type){
        List<cars> data = new ArrayList<>();
        data = stdc.getCarByType(type);
        data = stdc.Sortcarbydate(type);
        if(data==null)return null;
        return data;
    }
}
