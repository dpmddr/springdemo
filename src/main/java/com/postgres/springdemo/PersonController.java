package com.postgres.springdemo;


import com.postgres.springdemo.model.Person;
import com.postgres.springdemo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired

    PersonRepo repo;
    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        repo.save(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return repo.findAll();
    }





    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestParam String name) {
        Optional<Person> optionalPerson = repo.findById(id);

        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();

            // Update the name of the existing person
            existingPerson.setName(name);

            // Save the updated person
            repo.save(existingPerson);

            return ResponseEntity.ok("Person updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
