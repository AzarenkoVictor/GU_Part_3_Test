package Java;
import Java.Controller;
import Java.Model.FileOperation;
import Java.Model.Repository;
import Java.View;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation("Animals.csv");
        Repository repository = new Repository(fileOperation);
        Controller controller = new Controller(repository);
        View view = new View(controller);
        view.run();
    }
}