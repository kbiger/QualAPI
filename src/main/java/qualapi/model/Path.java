package qualapi.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by kbiger on 24/09/15.
 */
@NodeEntity
public class Path {

    @GraphId
    private Long id;
    private String name;

    public String uri;

    public Path(String uri){
        this.uri = uri;
    }

    @Relationship(type = "HAS", direction = "OUTGOING")
    public List<Operation> operations;

    public String getMainResource() {
        String result = "";
        //TODO
        return result;
    }

}
