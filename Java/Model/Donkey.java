package Java.Model;

import java.util.List;

public class Donkey extends PackAnimal {
    public Donkey(String name, List<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        String commandsStr = Mapper.mapListToStr(this.getCommands());
        return "Вьючное животное. Осел. Имя: " + this.getName() + ". Команды: " + commandsStr;
    }
}