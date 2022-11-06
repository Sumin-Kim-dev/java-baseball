package baseball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @RepeatedTest(value = 100, name = "생성_확인() #{currentRepetition}")
    void generateAnswer_올바른_생성_확인() {
        Computer computer = Computer.generateAnswer();
        try {
            Field field = computer.getClass().getDeclaredField("answer");
            field.setAccessible(true);
            Numbers answer = (Numbers) field.get(computer);
            boolean result = true;
            assertThat(result).isEqualTo(answer.validation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void strike_확인() {
        try {
            Constructor<Computer> constructor = Computer.class.getDeclaredConstructor(Numbers.class);
            constructor.setAccessible(true);
            Computer test = constructor.newInstance(new Numbers(List.of(1, 2, 3)));
            User user = new User();
            user.guess = new Numbers(List.of(1, 2, 4));
            int result = 2;
            assertThat(result).isEqualTo(test.strike(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void ball_확인() {
        try {
            Constructor<Computer> constructor = Computer.class.getDeclaredConstructor(Numbers.class);
            constructor.setAccessible(true);
            Computer test = constructor.newInstance(new Numbers(List.of(1, 2, 3)));
            User user = new User();
            user.guess = new Numbers(List.of(2, 1, 3));
            int result = 2;
            assertThat(result).isEqualTo(test.ball(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void status_확인() {
        try {
            Constructor<Computer> constructor = Computer.class.getDeclaredConstructor(Numbers.class);
            constructor.setAccessible(true);
            Computer test = constructor.newInstance(new Numbers(List.of(1, 2, 3)));
            User user = new User();
            user.guess = new Numbers(List.of(1, 4, 2));
            String result = "1볼 1스트라이크";
            assertThat(result).isEqualTo(test.status(user).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
