package cardService;

import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.entity.CardEntity;
import com.github.voynova.repository.CardRepository;
import com.github.voynova.repository.SessionRepository;
import com.github.voynova.service.CardService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Disabled
@SpringBootTest(classes = {CardRepository.class,CardService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class CardBalanceTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardService cardService;


    @BeforeAll
    public void createData() {
        CardEntity card1= new CardEntity(UUID.randomUUID(),123,"1234","1234", LocalDate.MAX);
        CardEntity card2= new CardEntity(UUID.randomUUID(),4567,"4567","4567", LocalDate.MIN);
        CardEntity card3= new CardEntity(UUID.randomUUID(),-7890,"7890","7890", LocalDate.MAX);
        /*Mockito.when(cardRepository.findCardEntityByNumberAndPin("1234","1234")).thenReturn(card1);
        Mockito.when(cardRepository.findCardEntityByNumberAndPin("4567","4567")).thenReturn(card2);
        Mockito.when(cardRepository.findCardEntityByNumberAndPin("7890","7890")).thenReturn(card3);*/
        cardRepository.saveAll(List.of(card1,card2,card3));
    }

    @Test
    public void getBalanceTest() {
        UUID session = cardService.getSession("1234","1234");
        CardBalanceDto balance;
        try {
            balance = cardService.getCardBalance(session);
            Assertions.assertEquals(123,balance.getBalance());
        } catch (IllegalAccessException e) {
            Assertions.fail();
        }

    }

    @Test
    public void getBalanceRandomSessionTest() {
        Assertions.assertThrows(IllegalAccessException.class,() -> cardService.getCardBalance(UUID.randomUUID()));
        }

    @Test
    @SneakyThrows
    public void getBalanceTimeoutTest() {
        UUID session = cardService.getSession("7890","7890");
        CardBalanceDto balance;
        Thread.sleep(130000); /*больше 2 минут (120 тыс мс)*/
        Assertions.assertThrows(IllegalAccessException.class,() -> cardService.getCardBalance(session));
    }


}
