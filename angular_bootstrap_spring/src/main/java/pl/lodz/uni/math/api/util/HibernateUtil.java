package pl.lodz.uni.math.api.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateUtil {  
	
	private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);
	

    private static final SessionFactory sessionFactory;  
  
    static {  
        try {  
            sessionFactory = new Configuration().configure().buildSessionFactory();  
        } catch (Throwable ex) {  
        	log.error("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
  
}  