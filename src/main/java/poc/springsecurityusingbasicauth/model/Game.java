package poc.springsecurityusingbasicauth.model;

import lombok.Builder;
import lombok.Data;
import poc.springsecurityusingbasicauth.enums.GameGenre;
import poc.springsecurityusingbasicauth.enums.GamePlatform;
import poc.springsecurityusingbasicauth.enums.GamePublisher;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Game {

    private Long id;

    private String title;

    private GameGenre genre;

    private LocalDate release;

    private GamePublisher publisher;

    private List<GamePlatform> platforms;

}
