package br.ufg.smge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufg.smge.domain.model.ClassRoom;
import br.ufg.smge.domain.model.User;
import br.ufg.smge.domain.repository.ClassRoomRepository;
import br.ufg.smge.domain.repository.UserRepository;

@Controller
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPosts(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "admin/users/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		userRepository.delete(id);
		return new ModelAndView("redirect:/admin/class");
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newProject() {
		return "admin/class/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("name") String name) {
		userRepository.save(new User());
		return new ModelAndView("redirect:/admin/users");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("classroom_id") long id, @RequestParam("name") String name) {
		User user = userRepository.findOne(id);

		userRepository.save(user);
		return new ModelAndView("redirect:/admin/users");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable long id, Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "admin/users/edit";
	}
}
