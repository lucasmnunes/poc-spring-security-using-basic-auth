package poc.springsecurityusingbasicauth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import poc.springsecurityusingbasicauth.enums.GameGenre;
import poc.springsecurityusingbasicauth.enums.GamePlatform;
import poc.springsecurityusingbasicauth.enums.GamePublisher;
import poc.springsecurityusingbasicauth.model.Game;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GameServiceTest {

    @Mock
    GameService gameService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(gameService.findAll()).thenReturn(getListGamesMock());
        when(gameService.findById(1L)).thenReturn(getOneGameMock());
        when(gameService.findByTitle(anyString())).thenReturn(getOneGameMock());
    }

    @Test
    @DisplayName("GameService FindAll Test")
    public void whenFindAll_thenReturnAllGames() {
        var allGamesCount = gameService.findAll().size();
        assertEquals(2, allGamesCount);
    }

    @Test
    @DisplayName("GameService FindById Test")
    public void givenAGameId_whenFindById_thenReturnOneGame() {
        var game = gameService.findById(1L);
        assertEquals("The Legend of Zelda: Breath of the Wild", game.getTitle());
    }

    @Test
    @DisplayName("GameService FindById Test ResponseStatusException")
    public void givenAGameId_whenFindById_thenReturnOneGamee() {
        // TODO Complete the Test case
    }

    @Test
    @DisplayName("GameService FindByTitle Test")
    public void givenAGameTitle_whenFindByTitle_thenReturnOneGame() {
        var game = gameService.findByTitle("The Legend of Zelda: Breath of the Wild");
        assertEquals("The Legend of Zelda: Breath of the Wild", game.getTitle());
    }

    private List<Game> getListGamesMock() {
        return new ArrayList<>(List.of(
                Game.builder()
                        .id(1L)
                        .title("The Legend of Zelda: Breath of the Wild")
                        .genre(GameGenre.ACTION_ADVENTURE)
                        .release(LocalDate.of(2017, Month.MARCH, 3))
                        .publisher(GamePublisher.NINTENDO)
                        .platforms(List.of(GamePlatform.SWITCH)).build(),

                Game.builder()
                        .id(2L)
                        .title("God of War")
                        .genre(GameGenre.ACTION_ADVENTURE)
                        .release(LocalDate.of(2018, Month.APRIL, 20))
                        .publisher(GamePublisher.SONY)
                        .platforms(List.of(GamePlatform.PLAYSTATION, GamePlatform.PC)).build()));
    }

    private Game getOneGameMock() {
        return Game.builder()
                        .id(1L)
                        .title("The Legend of Zelda: Breath of the Wild")
                        .genre(GameGenre.ACTION_ADVENTURE)
                        .release(LocalDate.of(2017, Month.MARCH, 3))
                        .publisher(GamePublisher.NINTENDO)
                        .platforms(List.of(GamePlatform.SWITCH))
                        .build();
    }

}
