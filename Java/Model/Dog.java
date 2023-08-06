package Java.Model;

import java.util.List;

public class Dog extends Pet {
    public Dog(String name, List<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        String commandsStr = Mapper.mapListToStr(this.getCommands());
        return "Домашнее животное. Собака. Имя: " + this.getName() + ". Команды: " + commandsStr;
    }
}