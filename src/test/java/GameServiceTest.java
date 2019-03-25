import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import study.basecamp.config.ApplicationConfig;
import study.basecamp.repository.NumberRepository;
import study.basecamp.service.GameService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GameServiceTest {

    @Autowired
    private GameService service;

    @Autowired
    private NumberRepository numberRepository;



    @Test
    public void makeNumberExpected(){
        service.makeNumber(10);
        Assert.assertEquals(numberRepository.findById(1).get().getNumber() ,10);
    }

    @Test
    public void numberEqualsGuessExpectedWinner(){
        service.makeNumber(10);
        Assert.assertTrue(service.equalsNumbers(10 ,1));
    }

    @Test
    public void numberEqualsGuessExpectedLooser() {
        service.makeNumber(55);
        Assert.assertFalse(service.equalsNumbers(10 , 1));
    }
}
