package vesalud.vesalud.service;

import java.util.List;
import vesalud.vesalud.dao.PacientDAO;
import vesalud.vesalud.model.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pacientService")
public class PacientService {

	@Autowired
	PacientDAO pacientDao;
	
	@Transactional
	public List<Pacient> getAllPacients() {
		return pacientDao.getAllPacients();
	}

	@Transactional
	public Pacient getPacient(int id) {
		return pacientDao.getPacient(id);
	}

	@Transactional
	public void addPacient(Pacient pacient) {
		pacientDao.addPacient(pacient);
	}

	@Transactional
	public void updatePacient(Pacient pacient) {
		pacientDao.updatePacient(pacient);

	}

	@Transactional
	public void deletePacient(int id) {
		pacientDao.deletePacient(id);
	}
}
