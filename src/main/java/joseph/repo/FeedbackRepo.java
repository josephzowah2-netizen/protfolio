package joseph.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import joseph.model.Feedback;

public interface FeedbackRepo extends MongoRepository<Feedback, String>{

}
