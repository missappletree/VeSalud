package vesalud.vesalud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vesalud.vesalud.model.Pacient;

@Repository
public class PacientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Pacient> getAllPacients() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pacient> pacientList = session.createQuery("from pacientes").list();
		return pacientList;
	}
	
	public Pacient getPacient(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pacient pacient = (Pacient) session.get(Pacient.class, new Integer(id));
		return pacient;
	}

	public Pacient addPacient(Pacient pacient) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pacient);
		return pacient;
	}

	public void updatePacient(Pacient pacient) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pacient);
	}

	public void deletePacient(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pacient p = (Pacient) session.load(Pacient.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
