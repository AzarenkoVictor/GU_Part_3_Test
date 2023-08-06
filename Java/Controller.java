package Java;

import Java.Model.Animal;
import Java.Model.Repository;

import java.util.List;

public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void validateAnimalData(Animal animal) {
        if (animal.getName().isEmpty()) {
            throw new IllegalStateException(Fields are empty!);
        }
    }

    public void saveAnimal(Animal animal) {
        validateAnimalData(animal);
        repository.createAnimal(animal);
    }

    public Animal readAnimal(String name) throws Exception {
        ListAnimal animals = repository.getAllAnimals();
        for (Animal animal  animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        throw new Exception(Animal not found!);
    }

    public ListAnimal readAnimals() {
        return repository.getAllAnimals();
    }

    public boolean checkAnimal(String name) {
        ListAnimal animals = repository.getAllAnimals();
        for (Animal animal  animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void teachNewCommand(String name, ListString newCommands) {
        Animal animal = null;
        try {
            animal = readAnimal(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        animal.addCommands(newCommands);
        repository.updateAnimal(animal);
    }
}