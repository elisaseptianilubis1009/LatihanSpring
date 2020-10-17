package com.springboot.elisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.springboot.elisa.model.Jurusan;
import com.springboot.elisa.model.Mahasiswa;
import com.springboot.elisa.repository.JurusanRepository;
import com.springboot.elisa.repository.MahasiswaRepository;


//import org.springframework.web.servlet.ModelAndView;
//@RestController = ini dipake kalo methodnya nge return string atau json, misal mau bikin web service
@Controller//hanya dapat mengembalikan file.html
@RequestMapping("/mahasiswa")
public class MahasiswaController {
	@Autowired// kalau autowired itu buat pengganti new NamaClass()
	MahasiswaRepository mhs;
	@Autowired
	JurusanRepository jrs;
	


	
	//type data Model di parameter adalah class bawaaan spring, di dalamnya ada method AddAttribute yang berfungsi untuk mengirim data ke view 
	@RequestMapping (value="/tampil", method = RequestMethod.GET)
	public String mhs(Model model) {	
		List<Mahasiswa> lmahasiswa=mhs.findAll();
		model.addAttribute("mahasiswa", lmahasiswa);
		return "mahasiswa";
	}
	
	

// CRUD MAHASISWA____________________________________________________________________//
 
	@RequestMapping (value="/create", method = RequestMethod.GET)
	public String tambah_mhs(Model model) {
		
		model.addAttribute("mahasiswa",new Mahasiswa());//"mahasiswa" sebagai parameter (value kosong)
		List<Jurusan> ljurusan=jrs.findAll();
		model.addAttribute("jurusan", ljurusan);//"jurusan" itu parameter yang akan dilempar ke file.html(nama bebas)
		return "Mahasiswa_Create";
	}
 
	@RequestMapping (value="/create", method = RequestMethod.POST)
	public String save(Mahasiswa mahasiswa) {
		mhs.save(mahasiswa);
		return "redirect:/mahasiswa/tampil";
	}

	@RequestMapping (value="/edit/{id}", method = RequestMethod.GET)
	public String edit_mhs(Model model, @PathVariable Long id ) {
		Mahasiswa mahasiswa = mhs.findById(id).get();
		model.addAttribute("mahasiswa",mahasiswa);

		List<Jurusan> ljurusan=jrs.findAll();
		model.addAttribute("jurusan", ljurusan);
		return "Mahasiswa_Create";
	}

	@RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
	public String delete_mhs(@PathVariable Long id) {
		mhs.deleteById(id);
		return "redirect:/mahasiswa/tampil";
	}






	/*@equestMapping (value="/coba", method = RequestMethod.GET)
	public ModelAndView coba() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.html");
		return modelAndView;
	}*/
	

	
}
