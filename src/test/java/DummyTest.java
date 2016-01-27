import org.neo4j.ogm.session.Session;
import qualapi.model.Api;
import qualapi.model.Path;
import qualapi.utils.SessionUtils;

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
        Session session = SessionUtils.getSession();
//        session.purgeDatabase();
        session.save(api1);
        session.save(api2);
    }

}
