package com.springboot.elisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.elisa.model.Fakultas;
import com.springboot.elisa.repository.FakultasRepository;

@Controller
@RequestMapping("/fakultas")
public class FakultasController {
// Autowired sebagai pengganti new NamaClass();
	@Autowired
	FakultasRepository fks;
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String fak(Model model) {	
		List<Fakultas> lfakultas=fks.findAll();
		model.addAttribute("fakultas", lfakultas);
		return "fakultas";
	}
	
	// CRUD FAKULTAS_____________________________________________________________________//

		@RequestMapping (value="/create", method = RequestMethod.GET)
		public String tambah_fkl(Model model) {
			model.addAttribute("pfakultas",new Fakultas());
			return "Fakultas_Create"; 
		}
		
		@RequestMapping (value="/create", method = RequestMethod.POST)
		public String save_fak(Fakultas pfakultas) {
			fks.save(pfakultas);
			return "redirect:/fakultas/tampil";
		}

		
		@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
		public String edit_fks(Model model, @PathVariable Long id) {
		Fakultas fakultas = fks.findById(id).get();
			model.addAttribute("pfakultas",fakultas);
			return "Fakultas_Create";
		}

		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String delete_fks(@PathVariable Long id) {
			fks.deleteById(id);
			return "redirect:/fakultas/tampil";
		}


	
}
