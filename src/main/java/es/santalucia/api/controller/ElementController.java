package es.santalucia.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
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
import es.santalucia.api.model.Element;
import es.santalucia.api.service.ElementService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elements")
public class ElementController {

	private static final String MSG_SUCESS_INSERT = "Element inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Element successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Element successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private ElementService elementService;

	@GetMapping
	public List<Element> index(Model model) {
		List<Element> all = elementService.findAll();
		model.addAttribute("listElement", all);
    // return "element/index";
    return all;
	}

	@GetMapping("/{id}")
	public Element show(Model model, @PathVariable("id") Integer id) {
    Element element = null;
		if (id != null) {
			element = elementService.findOne(id);
			model.addAttribute("element", element);
		}
    // return "element/show";
    return element;
	}

	// @GetMapping(value = "/new")
	// public Element create(Model model, @ModelAttribute Element entity) {
	// 	model.addAttribute("element", entity);
	// 	// return "element/form";
	// }

	@PostMapping
	public Element create(@Valid @ModelAttribute Element entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Element element = null;
		try {
			element = elementService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
    }
    return element;
		// return "redirect:/elements/" + element.getId();
	}

	// @GetMapping("/{id}/edit")
	// public Element update(Model model, @PathVariable("id") Integer id) {
	// 	try {
	// 		if (id != null) {
	// 			Element entity = elementService.findOne(id);
	// 			model.addAttribute("element", entity);
	// 		}
	// 	} catch (Exception e) {
	// 		throw new ServiceException(e.getMessage());
  //   }
  //   return entity;
	// 	// return "element/form";
	// }

	@PutMapping
	public Element update(@Valid @ModelAttribute Element entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Element element = null;
		try {
			element = elementService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			// redirectAttributes.addFlashAttribute("error", MSG_ERROR);
      // e.printStackTrace();
      throw e;
    }
    return element;
		// return "redirect:/elements/" + element.getId();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Element entity = elementService.findOne(id);
				elementService.delete(entity);
				// redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			// redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		// return "redirect:/elements/index";
	}

}
