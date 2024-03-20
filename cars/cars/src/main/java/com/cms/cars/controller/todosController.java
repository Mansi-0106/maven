package com.cms.cars.controller;

import com.cms.cars.model.todos;
import com.cms.cars.repository.apiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class todosController {
    @Autowired
    private apiClient client;

      /*
     Method: Get,
     description: it will fetch all todos from given api
     response: List of all todos
     */

    @GetMapping("/getallTodos")
    public List<todos> getAlltodos(){
        return client.getAlltodos();
    }

    /*
   Method: GET,
   description: it will fetch  todos according to the id from given api
   response: todos object
   */
    @GetMapping("/getTodos/{id}")
    public todos getAlltodosbyId(@PathVariable("id") int id){
        return client.gettodobyId(id);
    }

}
