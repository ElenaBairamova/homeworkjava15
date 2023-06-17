import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

    public class GameTest {
        Game game = new Game();

        Player player1 = new Player(1, "Иван", 10);
        Player player2 = new Player(2, "Ольга", 5);
        Player player3 = new Player(3, "Петр", 15);
        Player player4 = new Player(4, "Алена", 35);
        Player player5 = new Player(5, "Денис", 15);

        @Test
        public void shouldExceptionIfFirstPlayerNotRegister() {
            game.register(player1);
            game.register(player2);

            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Player1", "Player3");
            });
        }
        @Test
        public void shouldExceptionIfBothPlayerNotRegister() {
            game.register(player1);
            game.register(player2);

            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Player3", "Player4");
            });
        }
        @Test
        public void shouldExceptionIfSecondPlayerNotRegister() {
            game.register(player1);
            game.register(player2);

            Assertions.assertThrows(NotRegisteredException.class, () -> {
                game.round("Player2", "Player3");
            });
        }
        @Test
        public void shouldReturn1IfWinPlayer1() {
            game.register(player1);
            game.register(player2);
            Assertions.assertEquals(1, game.round("Иван", "Ольга"));

        }
        @Test
        public void shouldReturn2IfWinPlayer2() {
            game.register(player3);
            game.register(player4);
            Assertions.assertEquals(2, game.round("Петр", "Алена"));

        }
        @Test
        public void shouldReturn0IfDraw() {
            game.register(player3);
            game.register(player5);
            Assertions.assertEquals(0, game.round("Петр", "Денис"));

        }
    }

