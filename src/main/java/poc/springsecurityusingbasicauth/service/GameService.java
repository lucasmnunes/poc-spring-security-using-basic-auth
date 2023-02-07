package poc.springsecurityusingbasicauth.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import poc.springsecurityusingbasicauth.enums.GameGenre;
import poc.springsecurityusingbasicauth.enums.GamePlatform;
import poc.springsecurityusingbasicauth.enums.GamePublisher;
import poc.springsecurityusingbasicauth.model.Game;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class GameService {

    private List<Game> games = new ArrayList<>(List.of(
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
                    .platforms(List.of(GamePlatform.PLAYSTATION, GamePlatform.PC)).build(),

            Game.builder()
                    .id(3L)
                    .title("Halo 5: Guardians")
                    .genre(GameGenre.SHOOTER)
                    .release(LocalDate.of(2015, Month.OCTOBER, 27))
                    .publisher(GamePublisher.MICROSOFT)
                    .platforms(List.of(GamePlatform.XBOX)).build()));

    public List<Game> findAll() {
        return this.games;
    }

    public Game findById(Long id) {
        System.out.println("@@@@@@ Ola");
        return findAll().stream()
                .filter(game -> game.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        String.format("Game ID %d not found.", id)));
    }

    public Game findByTitle(String title) {
        return findAll().stream()
                .filter(game -> game.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public Game insert(Game game) {
        Game gamesExists = findByTitle(game.getTitle());

        if (nonNull(gamesExists)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Game %s already exists.", game.getTitle())
            );
        }

        // TODO Complete Insert code
        return null;
    }

}
