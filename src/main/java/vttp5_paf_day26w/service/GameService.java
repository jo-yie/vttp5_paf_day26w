package vttp5_paf_day26w.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day26w.model.Game;
import vttp5_paf_day26w.model.GameDetail;
import vttp5_paf_day26w.model.GameResponse;
import vttp5_paf_day26w.repo.GameRepo;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo; 

    public List<GameDetail> getAllGames() {
        return gameRepo.getAllGames();

    }

    // TASK A
    public GameResponse getResponse(int limit, int offset, boolean isRanked) {

        List<Game> games = new ArrayList<>(); 

        if (!isRanked) {

            // unranked list
            games = gameRepo.getGames(limit, offset);

        } else {

            // ranked list
            games = gameRepo.getGamesRanked(limit, offset);

        }

        GameResponse g = new GameResponse(); 

        g.setGames(games);
        g.setOffset(offset);
        g.setLimit(limit);
        g.setTotal(gameRepo.getNumberOfGames());

        return g;

    }

    // TASK C 
    public Optional<GameDetail> getGameById(String id) { 

        return gameRepo.getGameById(id);

    }
    
}
