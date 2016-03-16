package qualapi.neo4jUtils;

/**
 * Created by kbiger on 16/03/16.
 */
public interface Service<T> {

	Iterable<T> findAll();

	T find(Long id);

	void delete(Long id);

	T createOrUpdate(T object);

}
