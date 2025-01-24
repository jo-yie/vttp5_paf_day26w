package vttp5_paf_day26w.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDetail {

    @Field("_id")
    private String game_id; 
    private String name;
    private int year; 
    private int ranking; 
    private int users_rated;
    private String url; 

    @Field("image")
    private String thumbnail; 

    private String timestamp;

    public GameDetail() {
        this.timestamp = LocalDateTime.now().toString();
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getUsers_rated() {
        return users_rated;
    }

    public void setUsers_rated(int users_rated) {
        this.users_rated = users_rated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
}
