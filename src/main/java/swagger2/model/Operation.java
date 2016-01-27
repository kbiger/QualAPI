package swagger2.model;

import java.util.List;

/**
 * Created by kbiger on 21/01/16.
 */
public class Operation {

    public String summary;
    public String description;
    public List<Parameter> parameters;
    public Object security; //TODO
    public List<String> tags;
    public Object responses; //TODO

}
