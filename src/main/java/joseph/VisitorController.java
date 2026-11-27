package joseph;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;


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
	


	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }
	

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        if ("joseph".equals(username) && "1991".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/visitors";
        }
        model.addAttribute("error", "Invalid login");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
	
    @GetMapping("/visitors")
	public String listStudents(HttpSession session,Model model) {
		if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
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
