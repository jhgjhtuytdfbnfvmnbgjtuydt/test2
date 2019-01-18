package es.santalucia.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import es.santalucia.model.Page;
import es.santalucia.service.PageService;

@Controller
@RequestMapping("/pages")
public class PageController {

	private static final String MSG_SUCESS_INSERT = "Page inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Page successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Page successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PageService pageService;

	@GetMapping
	public String index(Model model) {
		List<Page> all = pageService.findAll();
		model.addAttribute("listPage", all);
		return "page/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Page page = pageService.findOne(id);
			model.addAttribute("page", page);
		}
		return "page/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Page entity) {
		model.addAttribute("page", entity);
		return "page/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Page entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Page page = null;
		try {
			page = pageService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pages/" + page.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Page entity = pageService.findOne(id);
				model.addAttribute("page", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "page/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Page entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Page page = null;
		try {
			page = pageService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/pages/" + page.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Page entity = pageService.findOne(id);
				pageService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/pages/index";
	}

}
