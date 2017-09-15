import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import net.sf.ehcache.hibernate.HibernateUtil;

public class main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().
				configure().buildSessionFactory();
		sessionFactory.close();
	}
}