package vesalud.vesalud.controller;


import java.util.List;

import vesalud.vesalud.model.Pacient;
import vesalud.vesalud.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PacientController {
	
	@Autowired
	PacientService pacientService;
	
	@RequestMapping(value = "/getAllPacients", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getPacients(Model model) {
		
		List<Pacient> listOfPacients = pacientService.getAllPacients();
		model.addAttribute("pacient", new Pacient());
		model.addAttribute("listOfPacients", listOfPacients);
		return "pacientDetails";
	}

	@RequestMapping(value = "/getPacient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Pacient getPacientById(@PathVariable int id) {
		return pacientService.getPacient(id);
	}

	@RequestMapping(value = "/addPacient", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPacient(@ModelAttribute("pacient") Pacient pacient) {	
		if(pacient.getId()==0)
		{
			pacientService.addPacient(pacient);
		}
		else
		{	
			pacientService.updatePacient(pacient);
		}
		
		return "redirect:/getAllPacients";
	}

	@RequestMapping(value = "/updatePacient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePacient(@PathVariable("id") int id,Model model) {
		 model.addAttribute("pacient", this.pacientService.getPacient(id));
	        model.addAttribute("listOfPacients", this.pacientService.getAllPacients());
	        return "pacientDetails";
	}

	@RequestMapping(value = "/deletePacient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deletePacient(@PathVariable("id") int id) {
		pacientService.deletePacient(id);
		 return "redirect:/getAllPacients";

	}	
}
