package qualapi.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by kbiger on 21/01/16.
 */
@NodeEntity
public class InfoApi {

    @GraphId
    public String title;
    public String description;
    public String version;
}
