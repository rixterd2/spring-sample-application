import com.gmail.rixterd2.Main;
import com.gmail.rixterd2.example.SimpleEntity;
import com.gmail.rixterd2.example.SimpleEntityFactory;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

@SpringBootTest(classes = Main.class)
@TestPropertySource(locations = "classpath:application.yaml")
public class HibernateTest {

    @Inject
    private SessionFactory sessionFactory;

    @Test
    void sessionFactoryIsAvailable() {
        Assertions.assertNotNull(sessionFactory);
    }

    @Test
    void createSimpleEntityAndFindIt() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        SimpleEntity simpleEntity = SimpleEntityFactory.createSimpleEntity();

        transaction.begin();
        entityManager.persist(simpleEntity);
        transaction.commit();

        List<SimpleEntity> entityList = entityManager
                .createQuery("SELECT se from SimpleEntity se", SimpleEntity.class)
                .getResultList();

        Assertions.assertFalse(entityList.isEmpty());
        Assertions.assertTrue(entityList.contains(simpleEntity));

        transaction.begin();
        entityManager.remove(simpleEntity);
        transaction.commit();

        entityManager.close();
    }
}
