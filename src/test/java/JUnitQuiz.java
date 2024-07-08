import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {
    @Test
    public void Quiz1() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void Quiz2(){
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        assertThat(num1).isPositive();
        assertThat(num2).isZero();
        assertThat(num3).isNegative();
        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);
    }
}
