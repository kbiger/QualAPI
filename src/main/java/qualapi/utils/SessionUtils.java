package qualapi.utils;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Created by kbiger on 21/01/16.
 */
public final class SessionUtils {

    private static final String DOMAIN_NAME = "qualapi.model";
    private static final String SERVER_URL = "http://localhost:7474";
    private static final String USER = "neo4j";
    private static final String PASSWORD = "reverand";

    private static SessionFactory sessionFactory = new SessionFactory(DOMAIN_NAME);

    public static void renewSessionFactory() {
        sessionFactory = new SessionFactory(DOMAIN_NAME);
    }

    public static Session getSession() {
        Session session = sessionFactory.openSession(SERVER_URL,USER,PASSWORD);
        return session;
    }

}
