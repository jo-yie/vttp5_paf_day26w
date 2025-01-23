package vttp5_paf_day26w.model;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @Field("gid")
    private int gid; 

    @JsonProperty("name")
    private String name;

    public Game() {
    }

    public Game(int gid, String name) {
        this.gid = gid;
        this.name = name;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
