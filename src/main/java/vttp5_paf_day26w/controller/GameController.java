package vttp5_paf_day26w.controller;

import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day26w.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GameController {

    @Autowired
    private GameService gameService; 

    // GET /
    // get all games
    @GetMapping("")
    public ResponseEntity<Object> getAllGames() {
        
        try {
            return ResponseEntity.ok().body(gameService.getAllGames());

        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());

        }
    }

    // TASK A 
    // GET /games?limit=10&offset=3
    @GetMapping("/games")
    public ResponseEntity<Object> getGames(@RequestParam(name="limit", defaultValue = "25") int limit, 
                                            @RequestParam(name="offset", defaultValue = "0") int offset) {

        try {

            return ResponseEntity.ok().header("Content-Type", "application/json").body(gameService.getResponse(limit, offset));

        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());

        }
    }

    // TASK B 
    // GET /games/rank
    @GetMapping("/games/rank")
    public ResponseEntity<Object> getGamesByRank(@RequestParam(name="limit", defaultValue = "25") int limit, 
                                                    @RequestParam(name="offset", defaultValue = "0") int offset) {

        return ResponseEntity.ok().body(gameService.getGamesRanked(limit, offset)); 

    }
    
    
}
