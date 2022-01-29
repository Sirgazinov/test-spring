package ru.ibs.pet.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {

    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel() {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance() {
        return instance;
    }

    public void add(Pet pet, int id) {
        model.put(id, pet);
    }

    public Pet get(int id) {
        return model.get(id);
    }

    public Map<Integer, Pet> getAll() {
        return model;
    }

    public void remove(int id) {
        model.remove(id);
    }

    public void replace(Pet pet, int id) {
        model.replace(id, pet);
    }
}
