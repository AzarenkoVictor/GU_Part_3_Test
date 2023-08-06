package Java.Model;

import java.util.List;

public class Horse extends PackAnimal {
    public Horse(String name, List<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        String commandsStr = Mapper.mapListToStr(this.getCommands());
        return "Вьючное животное. Лошадь. Имя: " + this.getName() + ". Команды: " + commandsStr;
    }
}