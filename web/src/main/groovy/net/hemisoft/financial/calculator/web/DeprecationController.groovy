package net.hemisoft.financial.calculator.web

import java.util.concurrent.atomic.AtomicInteger

import javax.validation.Valid

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping
class DeprecationController {
	
	AtomicInteger idGenerator = new AtomicInteger(0)
	private final def db = [:]
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("messages/list", "messages", db.values());
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		return new ModelAndView("messages/view", "message", db.get(id));
	}

	@GetMapping(params = "form")
	public String createForm(@ModelAttribute Message message) {
		return "messages/form";
	}

	@PostMapping
	public ModelAndView create(@Valid Message message, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("messages/form");
			mav.addObject("formErrors", result.getAllErrors());
			mav.addObject("fieldErrors", getFieldErrors(result));
			return mav;
		}
		def id = idGenerator.incrementAndGet();
		message.id = id;
		db.put(id.longValue(), message)
		redirect.addFlashAttribute("globalMessage", "Successfully created a new message")
		return new ModelAndView("redirect:/{message.id}", "message.id", message.id)
	}

	private Map<String, ObjectError> getFieldErrors(BindingResult result) {
		Map<String, ObjectError> map = new HashMap<>();
		for (FieldError error : result.getFieldErrors()) {
			map.put(error.getField(), error);
		}
		return map;
	}

	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}
	
	
	private Message createMessage(Long id, String text) {
		Message m = new Message()
		m.setId(id)
		m.setText(text)
		m.setSummary(text)
		m.setCreated(new Date())
		return m
	}
}
