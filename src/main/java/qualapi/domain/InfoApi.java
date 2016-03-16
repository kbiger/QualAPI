package qualapi.domain;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by kbiger on 21/01/16.
 */
@NodeEntity
public class InfoApi extends Entity{

    public String title;
    public String description;
    public String version;
}
