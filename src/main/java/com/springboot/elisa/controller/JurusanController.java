package com.springboot.elisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.elisa.model.Fakultas;
import com.springboot.elisa.model.Jurusan;
import com.springboot.elisa.repository.FakultasRepository;
import com.springboot.elisa.repository.JurusanRepository;

@Controller
@RequestMapping("/jurusan")
public class JurusanController {
	@Autowired
	JurusanRepository jrs;
	
	@Autowired
	FakultasRepository fks;
	
	
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String jur(Model model) {
		List<Jurusan> ljurusan=jrs.findAll();
		model.addAttribute("jurusan", ljurusan);
		return "jurusan";
	}

	// CRUD JURUSAN ____________________________________________________________________//
	
		@RequestMapping (value="/create", method = RequestMethod.GET)
		public String tambah_jrs(Model model) {
			model.addAttribute("jurusan",new Jurusan());
			List<Fakultas> lfakultas=fks.findAll();
			model.addAttribute("fakultas", lfakultas);
			return "Jurusan_Create";
		}
		
		@RequestMapping (value="/create", method = RequestMethod.POST)
		public String save_jur(Jurusan jurusan) {
			jrs.save(jurusan);
			return "redirect:/jurusan/tampil";
		}



		@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
		public String edit_jrs(Model model, @PathVariable Long id) {
		Jurusan jurusan = jrs.findById(id).get();
			model.addAttribute("jurusan",jurusan);

			List<Fakultas> lfakultas=fks.findAll();
			model.addAttribute("fakultas", lfakultas);
			return "Jurusan_Create";
		}

		@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
		public String delete_jrs(@PathVariable Long id) {
			jrs.deleteById(id);
			return "redirect:/jurusan/tampil";
		}


}
