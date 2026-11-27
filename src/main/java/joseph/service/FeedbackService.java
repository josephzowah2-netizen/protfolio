package joseph.service;

import java.util.List;


import org.springframework.stereotype.Service;

import joseph.model.Feedback;
import joseph.repo.FeedbackRepo;

@Service
public class FeedbackService {
	private  final FeedbackRepo  repo;

	FeedbackService(FeedbackRepo repo) {
		this.repo = repo;
	}
	public Feedback save(Feedback entity) {
		return repo.save(entity);
	}

	public List<Feedback> findAll() {
		return repo.findAll();
	}


}
