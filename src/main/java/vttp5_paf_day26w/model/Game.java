package vttp5_paf_day26w.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Game {

    @Field("gid")
    private int game_id; 
    private String name;

    public Game() {
    }
    public Game(int game_id, String name) {
        this.game_id = game_id;
        this.name = name;
    }
    public int getGame_id() {
        return game_id;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
