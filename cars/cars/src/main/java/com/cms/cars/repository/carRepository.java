package com.cms.cars.repository;

import com.cms.cars.model.cars;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface carRepository extends MongoRepository<cars,String> {

    //here were are finding cars by their respective types
    @Query("{'type': ?0}")
    List<cars>  getCarByType(String type);

    //here were are finding car by types and sorting the data by manufacture date
    @Aggregation(pipeline = {
            "{'$match':{'type': ?0}}",
            "{'$sort':{'manufactureDate':1}}"
    })
    List<cars> Sortcarbydate(String type);
}
