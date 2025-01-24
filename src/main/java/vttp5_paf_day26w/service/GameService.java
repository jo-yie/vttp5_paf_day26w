package vttp5_paf_day26w.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonValue;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;
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

    public int getNumberOfGames() { 
        return gameRepo.getAllGames().size();

    }

    // public GameDetail documentToGame(Document document) {

    //     GameDetail g = new GameDetail(); 

    //     g.set_id(document.get("_id").toString());
    //     g.setName(document.getString("name"));

    //     return g;

    // }

    // public List<GameDetail> gamesToDocuments(List<Document> documents) {

    //     List<GameDetail> games = new ArrayList<>();

    //     for (Document d : documents) {

    //         GameDetail g = documentToGame(d);

    //         games.add(g);

    //     }

    //     return games;

    // }

    public GameResponse getTest(int limit, int offset) {

        List<Game> games = gameRepo.getGames(limit, offset);

        GameResponse g = new GameResponse(); 

        g.setGames(games);
        g.setOffset(offset);
        g.setLimit(limit);

        int total = (int) gameRepo.getNumberOfGames().intValue();
        g.setTotal(total);

        return g;

    }

    // // TASK A + B
    // public JsonObject getResponse(int limit, int offset, boolean isRanked) {

    //     List<Document> documents = new ArrayList<>(); 
    //     List<GameDetail> games = new ArrayList<>(); 

    //     // unranked normal list
    //     if (!isRanked) {

    //         documents = gameRepo.getGames(limit, offset); 
    //         games = gamesToDocuments(documents);

    //     } else {

    //         // isRanked == true 
    //         // ranked list
    //         documents = gameRepo.getGamesRanked(limit, offset);
    //         games = gamesToDocuments(documents);

    //     }

    //     JsonArrayBuilder jab = Json.createArrayBuilder();

    //     for (GameDetail g : games) {

    //         JsonObject jo = Json.createObjectBuilder()
    //                             .add("game_id", g.get_id())
    //                             .add("name", g.getName())
    //                             .build();

    //         jab.add(jo);

    //     }

    //     String timestamp = LocalDateTime.now().toString();

    //     JsonObject jo = Json.createObjectBuilder()
    //                         .add("games",jab)
    //                         .add("offset", offset)
    //                         .add("limit", limit)
    //                         .add("total", getNumberOfGames())
    //                         .add("timestamp", timestamp)
    //                         .build();

    //     return jo;

    // }

    // TASK C 
    public GameDetail getGameById(String id) { 

        return gameRepo.getGameById(id);

    }
    
}
