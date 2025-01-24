package vttp5_paf_day26w.model;

import java.time.LocalDateTime;
import java.util.List;

public class GameResponse {

    private List<Game> games; 
    private int offset; 
    private int limit; 
    private int total; 
    private String timestamp;

    public GameResponse() {
        this.timestamp = LocalDateTime.now().toString(); 
    }

    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    } 
    
}
