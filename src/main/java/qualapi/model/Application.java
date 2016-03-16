package qualapi.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by kbiger on 24/09/15.
 */
@NodeEntity
public class Application extends Entity{

    private String name;

    @Relationship(type = "CONSUMES", direction = "OUTGOING")
    public List<Api> apisConsumed;
    @Relationship(type = "CONSUMES", direction = "OUTGOING")
    public List<ScopeSecu> scopesConsumed;

}
