package joseph;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
	@Autowired
	private  VisitorRepo vistitorRepo;

	VisitorService(VisitorRepo vistitorRepo) {
		this.vistitorRepo = vistitorRepo;
	}

	public Visitor save(Visitor entity) {
		return vistitorRepo.save(entity);
	}

	public List<Visitor> findAll() {
		return vistitorRepo.findAll();
	}

	public Visitor findById(Integer id) {
		return vistitorRepo.findById(id).orElse(null);
	}

	public void deleteById(Integer id) {
		vistitorRepo.deleteById(id);
	}

}
