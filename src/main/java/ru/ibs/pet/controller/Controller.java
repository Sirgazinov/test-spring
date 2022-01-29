package ru.ibs.pet.controller;

import org.springframework.web.bind.annotation.*;
import ru.ibs.pet.logic.Pet;
import ru.ibs.pet.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {

    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger();

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public String createPet(@RequestBody Pet pet) {
        int id = newId.getAndIncrement();
        petModel.add(pet, id);

        if (id == 0) {
            return "Поздравляем, Вы создали своего первого домашнего питомца";
        } else {
            return "Вы создали домашнего питомца";
        }
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAllPets() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json; charset=utf-8")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.get(id.get("id"));
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json; charset=utf-8")
    public Map<Integer, Pet> delete(@RequestBody Map<String, Integer> id) {
        petModel.remove(id.get("id"));
        return petModel.getAll();
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json; charset=utf-8")
    public Map<Integer, Pet> update(@RequestBody Map<String, String> newPet) {
        Pet pet = new Pet();
        pet.setName(newPet.get("name"));
        pet.setType(newPet.get("type"));
        pet.setAge(Integer.parseInt(newPet.get("age")));
        int id = Integer.parseInt(newPet.get("id"));

        petModel.replace(pet, id);

        return petModel.getAll();
    }
}
