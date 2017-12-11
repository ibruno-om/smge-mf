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
import br.ufg.smge.domain.repository.ClassRoomRepository;

@Controller
@RequestMapping("/admin/class")
public class ClassRoomController {

	@Autowired
	private ClassRoomRepository repository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPosts(Model model) {
		model.addAttribute("classRooms", repository.findAll());
		return "admin/class/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		repository.delete(id);
		return new ModelAndView("redirect:/admin/class");
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newProject() {
		return "admin/class/new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("name") String name) {
		repository.save(new ClassRoom(name));
		return new ModelAndView("redirect:/admin/class");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("classroom_id") long id, @RequestParam("name") String name) {
		ClassRoom classRoom = repository.findOne(id);
		classRoom.setName(name);
		repository.save(classRoom);
		return new ModelAndView("redirect:/admin/class");
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable long id, Model model) {
		ClassRoom classRoom = repository.findOne(id);
		model.addAttribute("classRoom", classRoom);
		return "admin/class/edit";
	}
}
