package qualapi.neo4jUtils;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Created by kbiger on 16/03/16.
 */
public class Neo4jSessionFactory {

	private static final String DOMAIN_NAME = "qualapi.model";
	private static final String SERVER_URL = "http://localhost:7474";
	private static final String USER = "neo4j";
	private static final String PASSWORD = "changeme";

	private final static SessionFactory sessionFactory = new SessionFactory(DOMAIN_NAME);
	private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

	public static Neo4jSessionFactory getInstance() {
		return factory;
	}

	private Neo4jSessionFactory() {
	}

	public Session getNeo4jSession() {
		return sessionFactory.openSession(SERVER_URL,USER,PASSWORD);
	}
}