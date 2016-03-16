import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import qualapi.neo4jUtils.GenericService;
import qualapi.neo4jUtils.Neo4jSessionFactory;
import qualapi.service.ApiService;
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


		ApiService serviceAPI = new ApiService();
		qualapi.domain.Api apiOut = transfo.runTransfo(apiin, serviceAPI.find(apiin.info.title));
		//Neo4jSessionFactory.getInstance().getNeo4jSession().purgeDatabase();
		serviceAPI.createOrUpdate(apiOut);

	}

}
