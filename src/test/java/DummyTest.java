import qualapi.model.Api;
import qualapi.model.Path;
import qualapi.neo4jUtils.GenericService;

import java.util.ArrayList;


/**
 * Created by kbiger on 21/01/16.
 */
public class DummyTest {


    public static void main(String[] args) {
        Api api1 = new Api("Api1");
        api1.paths = new ArrayList<Path>();
        api1.paths.add(new Path("/path/1"));
        Api api2 = new Api("Api2");

	    GenericService<Api> serviceAPI = new GenericService<qualapi.model.Api>() {
            @Override
            public Class<qualapi.model.Api> getEntityType() {
                return qualapi.model.Api.class;
            }
        };

	    // Neo4jSessionFactory.getInstance().getNeo4jSession().purgeDatabase();
	    serviceAPI.createOrUpdate(api1);
	    serviceAPI.createOrUpdate(api2);
    }

}
