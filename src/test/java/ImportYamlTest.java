import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import qualapi.neo4jUtils.GenericService;
import qualapi.neo4jUtils.Neo4jSessionFactory;
import swagger2.model.Api;
import transfo.Swagger2ToQualAPI;

import java.io.*;

/**
 * Created by kbiger on 21/01/16.
 */
public class ImportYamlTest {


	public static void main(String[] args) throws IOException {
		InputStream input = new FileInputStream(new File("src/main/resources/input/uber.yaml"));
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		Api apiin = mapper.readValue(input, Api.class);

		Swagger2ToQualAPI transfo = new Swagger2ToQualAPI();
		qualapi.model.Api apiOut = transfo.runTransfo(apiin, "uber");

		GenericService<qualapi.model.Api> serviceAPI = new GenericService<qualapi.model.Api>() {
			@Override
			public Class<qualapi.model.Api> getEntityType() {
				return qualapi.model.Api.class;
			}
		};

		// Neo4jSessionFactory.getInstance().getNeo4jSession().purgeDatabase();
		serviceAPI.createOrUpdate(apiOut);

	}

}
