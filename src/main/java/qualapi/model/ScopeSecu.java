package qualapi.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by kbiger on 30/09/15.
 */
@NodeEntity
public class ScopeSecu {

    @GraphId
    private Long id;
    private String name;

}
