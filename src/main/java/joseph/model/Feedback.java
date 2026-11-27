package joseph.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document
public class Feedback {
	@Id
	private String id;
	private String name, email, message;

}
