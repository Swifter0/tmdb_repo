package hm.sb_tmdb_mvc_Homework1.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hm.sb_tmdb_mvc_Homework1.model.User;

@Repository
public class Database {

	private SessionFactory sessionFactory;	
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
		
	}

	public User getUserById(int userId) {
		
		User user = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		user = session.get(User.class, userId);
		
		
		SelectionQuery query = 
				session.createNativeQuery("SELECT s FROM seenmovies s WHERE userid = ?1", Object[].class);
		query.setParameter(1, userId);
		
		List<Object[]> rows = query.getResultList();
		
		for(int index = 0; index < rows.size(); index++) {
			
			Object[] currentRow = rows.get(index);
			int movieId = Integer.parseInt(currentRow[2].toString());
			user.addSeenMovieId(movieId);
			
		}
		
		tx.commit();
		session.close();
		
		return user;
	}

	public void persistSeenMovie(int movieId, int userId) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		NativeQuery query = 
				session.createNativeQuery("INSERT INTO seenmovies (userid,filmid) VALUES (?1,?2)",Object[].class);
		query.setParameter(1, userId);
		query.setParameter(2, movieId);
		
		query.executeUpdate();
		
		tx.commit();
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
}
