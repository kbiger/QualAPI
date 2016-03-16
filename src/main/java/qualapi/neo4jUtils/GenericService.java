package qualapi.neo4jUtils;

import org.neo4j.ogm.session.Session;
import qualapi.domain.Entity;

/**
 * Created by kbiger on 16/03/16.
 */
public abstract class GenericService<T> implements Service<T> {

	private static final int DEPTH_LIST = 0;
	private static final int DEPTH_ENTITY = -1;
	protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

	public Iterable<T> findAll() {
		return session.loadAll(getEntityType(), DEPTH_LIST);
	}

	public T find(Long id) {
		return session.load(getEntityType(), id, DEPTH_ENTITY);
	}

	public void delete(Long id) {
		session.delete(session.load(getEntityType(), id));
	}

	public T createOrUpdate(T entity) {
		session.save(entity, DEPTH_ENTITY);
		return find(((Entity) entity).getId());
	}

	public abstract Class<T> getEntityType();
}
