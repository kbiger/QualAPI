package transfo;

import qualapi.model.InfoApi;
import qualapi.model.Path;
import swagger2.model.Api;
import swagger2.model.Definition;
import swagger2.model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kbiger on 21/01/16.
 */
public class Swagger2ToQualAPI {

    public qualapi.model.Api runTransfo(Api in, String name) {
        qualapi.model.Api out = new qualapi.model.Api();
        out.name = name;
        out.swagger = in.swagger;

        //Info bloc
        /*out.info = new InfoApi();
        if (in.info == null || in.info.title == null) {
            out.info.title = "toto";
        } else {
            out.info.title = in.info.title;
        }
        out.info.description = in.info.description;
        out.info.version = in.info.version;*/

        out.host = in.host;
        out.schemes = in.schemes;
        out.basePath = in.basePath;

        //securityDefinitions; //TODO
        out.produces = in.produces;
        out.consumes = in.consumes;

        //paths; //TODO
        out.paths = new ArrayList<Path>();
        for (Map.Entry<String, Map<String, Operation>> entry : in.paths.entrySet())
        {
            Path tempPath = new Path(entry.getKey());
            out.paths.add(tempPath);
            tempPath.operations = new ArrayList<qualapi.model.Operation>();
            for(Map.Entry<String, Operation> entryOp : entry.getValue().entrySet()){
                tempPath.operations.add(new qualapi.model.Operation(entryOp.getKey()));
            }
        }


        //definitions; //TODO
        return out;
    }

}
