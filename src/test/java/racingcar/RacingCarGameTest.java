package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {
    @Test
    void setPlayers_사용자_1명_설정할_수_있다() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("dadi");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(1);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
    }
    @Test
    void setPlayers_사용자_여러명_설정할_수_있다() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("dadi,dodi");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(2);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
        assertThat(racingCars.get(1).getName()).isEqualTo("dodi");
    }
    @Test
    void setPlayers_입력값_없으면_예외_처리() {
        RacingCarGame game = new RacingCarGame();

        assertThatThrownBy(() -> game.setPlayers(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setPlayers_콤마_2개_연속_처리() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("dadi,,dodi");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(2);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
        assertThat(racingCars.get(1).getName()).isEqualTo("dodi");
    }
    @Test
    void setPlayers_공백_처리() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("  dadi, ,dodi  ");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(2);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
        assertThat(racingCars.get(1).getName()).isEqualTo("dodi");
    }
    @Test
    void setPlayers_글자수_5이상_예외_처리() {
        RacingCarGame game = new RacingCarGame();

        assertThatThrownBy(() -> game.setPlayers("dodi, dadidudedo"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setGameCount_정수_아닌_입력_예외_처리() {
        RacingCarGame game = new RacingCarGame();

        assertThatThrownBy(() -> game.setGameCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
