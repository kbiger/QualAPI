package qualapi.service;

import qualapi.domain.Api;
import qualapi.neo4jUtils.GenericService;

import java.util.Collection;

/**
 * Created by kbiger on 16/03/16.
 */
public class ApiService extends GenericService<Api> {

	@Override
	public Class<Api> getEntityType() {
		return Api.class;
	}

	public Api find(String title) {
		Collection<Api> apis = session.loadAll(Api.class, -1);
		for (Api api : apis) {
			if (api.name.equals(title)) {
				return session.load(getEntityType(),api.getId());
			}
		}
		return null;
	}
}
