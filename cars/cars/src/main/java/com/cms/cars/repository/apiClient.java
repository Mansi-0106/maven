package com.cms.cars.repository;

import com.cms.cars.model.todos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "jplaceholder",url = "https://jsonplaceholder.typicode.com/")
public interface apiClient {
    @GetMapping("/todos")
    List<todos> getAlltodos();

    @GetMapping("/todos/{id}")
    todos gettodobyId(@PathVariable("id") int id);
}
