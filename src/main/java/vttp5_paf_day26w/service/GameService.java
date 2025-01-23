package vttp5_paf_day26w.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp5_paf_day26w.model.Game;
import vttp5_paf_day26w.repo.GameRepo;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo; 

    public List<Game> getAllGames() {

        return gameRepo.getAllGames();

    }

    public int getNumberOfGames() { 

        return gameRepo.getAllGames().size();

    }

    public List<Game> getGames(int limit, int offset) {

        return gameRepo.getGames(limit, offset);

    }

    // TASK A
    public JsonObject getResponse(int limit, int offset) {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        List<Game> games = getGames(limit, offset);

        for (Game g : games) {

            JsonObject jo = Json.createObjectBuilder()
                                .add("gid", g.getGid())
                                .add("name", g.getName())
                                .build();

            jab.add(jo);

        }

        String timestamp = LocalDateTime.now().toString();

        JsonObject jo = Json.createObjectBuilder()
                            .add("games",jab)
                            .add("offset", offset)
                            .add("limit", limit)
                            .add("total", getNumberOfGames())
                            .add("timestamp", timestamp)
                            .build();

        return jo;

    }

    // TASK B
    public List<Game> getGamesRanked(int limit, int offset) {

        return gameRepo.getGamesRanked(limit, offset);

    }
    
}
