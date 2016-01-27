import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.neo4j.ogm.session.Session;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import qualapi.utils.SessionUtils;
import swagger2.model.Api;
import transfo.Swagger2ToQualAPI;

import java.io.*;

/**
 * Created by kbiger on 21/01/16.
 */
public class ImportYamlTest {

/*    public static void main(String[] args) throws FileNotFoundException {
        InputStream input = new FileInputStream(new File("src/main/resources/input/uber.yaml"));
        Yaml yaml = new Yaml(new Constructor(Api.class));
//        Object apiTest = yaml.load(input);
        Api api = (Api) yaml.load(input);
        System.out.println("yeah");
    }*/

    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream(new File("src/main/resources/input/uber.yaml"));
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Api apiin = mapper.readValue(input, Api.class);

        Swagger2ToQualAPI transfo = new Swagger2ToQualAPI();
        qualapi.model.Api apiOut = transfo.runTransfo(apiin, "uber");

        Session session = SessionUtils.getSession();
        session.purgeDatabase();
        session.save(apiOut);

        System.out.println("yeah");
    }

}
