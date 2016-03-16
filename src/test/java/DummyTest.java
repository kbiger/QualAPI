import qualapi.domain.Api;
import qualapi.domain.Path;
import qualapi.neo4jUtils.GenericService;
import qualapi.service.ApiService;

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

	    ApiService serviceAPI = new ApiService();

	    // Neo4jSessionFactory.getInstance().getNeo4jSession().purgeDatabase();
	    serviceAPI.createOrUpdate(api1);
	    serviceAPI.createOrUpdate(api2);
    }

}
