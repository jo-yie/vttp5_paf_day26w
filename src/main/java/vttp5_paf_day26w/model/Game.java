package vttp5_paf_day26w.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Game {

    @Field("_id")
    private String game_id; 
    private String name;

    public Game() {
    }

    public String getGame_id() {
        return game_id;
    }
    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
    
}
