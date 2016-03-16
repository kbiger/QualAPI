package transfo;

import qualapi.domain.Path;
import swagger2.model.Api;
import swagger2.model.Operation;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kbiger on 21/01/16.
 */
public class Swagger2ToQualAPI {

    public qualapi.domain.Api runTransfo(Api in, qualapi.domain.Api out) {
        qualapi.domain.Api result;
        if (out == null){
            result = new qualapi.domain.Api();
            result.name = in.info.title;
            result.swagger = in.swagger;
            result.host = in.host;
            result.schemes = in.schemes;
            result.basePath = in.basePath;
            result.produces = in.produces;
            result.consumes = in.consumes;
            result.paths = new ArrayList<Path>();
        } else {
            result = out;
        }

        //paths; //TODO
        for (Map.Entry<String, Map<String, Operation>> entry : in.paths.entrySet())
        {
            Path tempPath = new Path(entry.getKey());
            result.paths.add(tempPath);
            tempPath.operations = new ArrayList<qualapi.domain.Operation>();
            for(Map.Entry<String, Operation> entryOp : entry.getValue().entrySet()){
                tempPath.operations.add(new qualapi.domain.Operation(entryOp.getKey()));
            }
        }

        return result;
    }

}
