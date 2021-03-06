package qualapi.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by kbiger on 24/09/15.
 */
@NodeEntity
public class Api extends Entity{

    public String name;

    public String swagger;
    public InfoApi info;
    public String host;
    public List<String> schemes;
    public String basePath;
    //    private SecurityDefinition securityDefinition;
    public List<String> produces;
    public List<String> consumes;

    public Api() {

    }

    public Api(String name) {
        this.name = name;
    }

    @Relationship(type = "HAS", direction = "OUTGOING")
    public List<Path> paths;

}
