package Java.Model;

import java.util.List;

public class Camel extends PackAnimal {
    public Camel(String name, List<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        String commandsStr = Mapper.mapListToStr(this.getCommands());
        return "Вьючное животное. Верблюд. Имя: " + this.getName() + ". Команды: " + commandsStr;
    }
}