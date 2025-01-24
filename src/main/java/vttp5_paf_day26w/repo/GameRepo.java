package vttp5_paf_day26w.repo;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp5_paf_day26w.model.Game;
import static vttp5_paf_day26w.repo.Constants.*;

@Repository
public class GameRepo {

    @Autowired
    private MongoTemplate template; 

    /*
        db.games.find({})
     */
    public List<Game> getAllGames() { 

        Query query = new Query(); 
        return template.find(query, Game.class, C_GAMES);

    }

    // TASK A 
    /*
        db.games.find({})
                .limit(25)
                .skip(0)
     */
    public List<Document> getGames(int limit, int offset) {

        Query query = new Query().limit(limit).skip(offset);
        List<Document> documents = template.find(query, Document.class, C_GAMES);

        return documents;

    }

    // TASK B 
    /*
        db.games.find({
            ranking: { $exists : true}
        })
        .sort( { ranking : 1})
     */
    public List<Document> getGamesRanked(int limit, int offset) {

        Criteria criteria = Criteria.where(F_RANKING).exists(true);

        Query query = new Query().addCriteria(criteria)
            .with(Sort.by(Sort.Direction.ASC, F_RANKING))
            .limit(limit)
            .skip(offset);
        
        return template.find(query, Document.class, C_GAMES);

    }

}
