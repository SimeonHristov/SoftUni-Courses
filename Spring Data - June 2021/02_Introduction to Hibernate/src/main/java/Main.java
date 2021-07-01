import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("softuni");
        EntityManager EntityManager = factory.createEntityManager();

        var engine = new Engine(EntityManager);
        engine.run();
    }
}
