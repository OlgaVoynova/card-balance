package cardService;

import com.github.voynova.Main;
import com.github.voynova.entity.CardEntity;
import com.github.voynova.repository.CardRepository;
import com.github.voynova.repository.SessionRepository;
import com.github.voynova.service.CardService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)

public class AuthorizationTest {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    CardService cardService;

    @BeforeAll
    public void createData() {
        CardEntity card1= new CardEntity(UUID.randomUUID(),123,"1234","1234", LocalDate.MAX);
        CardEntity card2= new CardEntity(UUID.randomUUID(),4567,"4567","4567", LocalDate.of(2020,01,01));
        CardEntity card3= new CardEntity(UUID.randomUUID(),-7890,"7890","7890", LocalDate.MAX);
        cardRepository.saveAll(List.of(card1,card2,card3));
    }

    @AfterAll
    public void cleanRepository () {

        sessionRepository.deleteAll();
        cardRepository.deleteAll();
    }


    @Test
    public void authSuccessTest () {
        UUID response = cardService.getSession("1234","1234");
        Assertions.assertDoesNotThrow(()->cardService.getSession("1234","1234"));
        Assertions.assertNotNull(response);
    }

    @Test
    public void authFailIncorrectCredentialsTest () {
        Assertions.assertThrows(IllegalArgumentException.class,()->cardService.getSession("1234","0000"));
    }

    @Test
    public void authFailExpiredDateTest () {
        Assertions.assertThrows(IllegalStateException.class,()->cardService.getSession("4567","4567"));
    }

}
