package Java.Model;
import java.util.List;

public class Hamster extends Pet {
    public Hamster(String name, List<String> commands) {
        super(name, commands);
    }

    @Override
    public String toString() {
        String commandsStr = Mapper.mapListToStr(this.getCommands());
        return "Домашнее животное. Хомяк. Имя: " + this.getName() + ". Команды: " + commandsStr;
    }
}