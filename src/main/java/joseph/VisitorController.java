package joseph;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VisitorController {
	@Autowired
	private   VisitorService  visitorService;

	VisitorController(VisitorService visitorService) {
		this.visitorService = visitorService;
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/project")
	public String project() {
		return "project";
	}
	@GetMapping("/skills")
	public String skills() {
		return "skills";
	}
	@GetMapping("/visitors")
	public String listStudents(Model model) {
		List<Visitor> visitors = visitorService.findAll();
		model.addAttribute("data", visitors);
		return "visitors";
	}

	
	


	@PostMapping("/save")
	public ModelAndView saveVisitor(@ModelAttribute Visitor visitor) {
		ModelAndView mv= new ModelAndView();
		visitorService.save(visitor);
		mv.addObject("message", "Your Message is Received, Thanks");
		mv.setViewName("contact");
		return mv;
	}

	
	


}
