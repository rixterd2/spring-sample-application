import com.gmail.rixterd2.Main;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import jakarta.inject.Inject;

@SpringBootTest(classes = Main.class)
@TestPropertySource(locations = "classpath:application.yaml")
public class HibernateTest {

    @Inject
    private SessionFactory sessionFactory;

    @Test
    void simpleTest() {
        Assertions.assertNotNull(sessionFactory);
    }
}
