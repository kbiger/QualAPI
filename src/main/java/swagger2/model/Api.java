package swagger2.model;

import java.util.List;
import java.util.Map;

/**
 * Created by kbiger on 21/01/16.
 */
public class Api {
    public String swagger;
    public Info info;
    public String host;
    public List<String> schemes;
    public String basePath;
    public Map<String,SecurityDefinition> securityDefinitions;
    public List<String> produces;
    public List<String> consumes;
    public Map<String,Map<String, Operation>> paths;
    public Map<String, Definition> definitions;
}
