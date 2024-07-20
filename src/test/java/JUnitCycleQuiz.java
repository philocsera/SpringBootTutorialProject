import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {
    @BeforeEach
    public void sayHello(){
        System.out.println("Hello!");
    }
    
    @AfterAll
    static void sayGoodBye(){
        System.out.println("Bye!");
    }

    @Test
    public void Quiz3(){
        System.out.println("First Test");
    }

    @Test
    public void Quiz4(){
        System.out.println("Second Test");
    }
}
