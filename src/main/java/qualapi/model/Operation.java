package qualapi.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by kbiger on 24/09/15.
 */
@NodeEntity
public class Operation {

    public Operation(String name){
        this.name = name;
    }

    @GraphId
    public Long id;
    public String name;

    public Verb verb;
    public String nickname;

    @Relationship(type = "HAS", direction = "OUTGOING")
    public List<ScopeSecu> scopesConsumed;

}