package vttp5_paf_day26w.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp5_paf_day26w.model.Game;
import vttp5_paf_day26w.model.GameDetail;
import static vttp5_paf_day26w.repo.Constants.*;

@Repository
public class GameRepo {

    @Autowired
    private MongoTemplate template; 

    /*
        db.games.find({})
     */
    public List<GameDetail> getAllGames() { 

        Query query = new Query()
            .limit(10); 
        return template.find(query, GameDetail.class, C_GAMES);

    }

    /*
        db.games.count({})
     */
    public int getNumberOfGames() { 

        return (int) template.count(new Query(), C_GAMES);

    }
    
    // TASK A 
    /*
        db.games.find({})
                .limit(25)
                .skip(0)
     */
    public List<Game> getGames(int limit, int offset) {

        Query query = new Query().limit(limit).skip(offset);
        List<Game> games = template.find(query, Game.class, C_GAMES);

        return games;

    }

    // TASK B 
    /*
        db.games.find({
            ranking: { $exists : true}
        })
        .sort( { ranking : 1})
     */
    public List<Game> getGamesRanked(int limit, int offset) {

        Criteria criteria = Criteria.where(F_RANKING).exists(true);

        Query query = new Query().addCriteria(criteria)
            .with(Sort.by(Sort.Direction.ASC, F_RANKING))
            .limit(limit)
            .skip(offset);
        
        return template.find(query, Game.class, C_GAMES);

    }

    // TASK C 
    /*
        db.games.find({
            _id : ObjectId(<object_id>)
        })
     */
    public Optional<GameDetail> getGameById(String id) {

        Criteria criteria = Criteria.where(F_ID).is(id);
        Query query = new Query().addCriteria(criteria);

        Optional<GameDetail> gameDetail = Optional.ofNullable
            (template.findOne(query, GameDetail.class, C_GAMES));

        return gameDetail;

    }

}
