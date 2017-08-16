package net.hemisoft.financial.calculator.web

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

import javax.management.modelmbean.RequiredModelMBean
import javax.validation.Valid
import javax.websocket.server.PathParam

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import net.hemisoft.financial.calculator.service.DeprecationService

@Controller
@RequestMapping
class DeprecationController {
	final AtomicLong idGenerator = new AtomicLong(0)
	final def db = [:]
	
	DeprecationService service;
	
	@Autowired
	public DeprecationController(DeprecationService service) {
		this.service = service;
	}
	
	@GetMapping
	public ModelAndView view() {
		new ModelAndView("deprecation/list", "deprecations", db.values())
	}

	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		def deprecation = db.get(id)
		
		ModelMap model = new ModelMap()
		model.put("deprecations", db.values())
		model.put("deprecation", deprecation)
		model.put("plan", service.calculatePlan(deprecation))
		new ModelAndView("deprecation/list", model)
	}

	@GetMapping(params = "form")
	public String createForm(@ModelAttribute Deprecation deprecation) {
		"deprecation/form";
	}

	@PostMapping
	public ModelAndView create(@Valid Deprecation deprecation, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("deprecation/form");
			mav.addObject("formErrors", result.getAllErrors());
			mav.addObject("fieldErrors", getFieldErrors(result));
			mav;
		} else {
			new ModelAndView("redirect:/{deprecation.id}", "deprecation.id", save(deprecation).id)
		}
	}

	private Map<String, ObjectError> getFieldErrors(BindingResult result) {
		def map = [:];
		
		result.getFieldErrors().each {
			error -> map.put(error.getField(), error)
		}
		
		map;
	}

	//
		
	private Deprecation createDeprecation(capital, interest) {
		new Deprecation(capital, interest)
	}
	
	private Deprecation save(Deprecation deprecation) {
		def id = idGenerator.incrementAndGet()
		deprecation.id = id
		db.put(id, deprecation)
		deprecation
	}
}
