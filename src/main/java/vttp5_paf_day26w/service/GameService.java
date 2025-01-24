package vttp5_paf_day26w.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    public List<Game> gameToDocument(List<Document> documents) {

        List<Game> games = new ArrayList<>();

        for (Document d : documents) {

            Game g = new Game(); 

            g.setGid(d.getInteger("gid"));
            g.setName(d.getString("name"));

            games.add(g);

        }

        return games;

    }

    // TASK A + B
    public JsonObject getResponse(int limit, int offset, boolean isRanked) {

        List<Document> documents = new ArrayList<>(); 
        List<Game> games = new ArrayList<>(); 

        // unranked normal list
        if (!isRanked) {

            documents = gameRepo.getGames(limit, offset); 
            games = gameToDocument(documents);

        } else {

            // isRanked == true 
            // ranked list
            documents = gameRepo.getGamesRanked(limit, offset);
            games = gameToDocument(documents);

        }

        JsonArrayBuilder jab = Json.createArrayBuilder();

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
    
}
