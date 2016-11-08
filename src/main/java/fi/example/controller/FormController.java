package fi.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.example.entity.Kysymys;
import fi.example.entity.KysymysCRUDRepo;
import fi.example.entity.Vastaus;
import fi.example.entity.VastausCRUDRepo;




@RestController
public class FormController {
	@Autowired
	KysymysCRUDRepo kysrepo;
	@Autowired
	VastausCRUDRepo vasrepo;
	
	@GetMapping("kysymykset.JSON")
	public List<Kysymys> haeKysymyksetJSON() {
		System.out.println(kysrepo.findAll());
		 return (List<Kysymys>) kysrepo.findAll();
	}
	@PostMapping("talletavastaus")
	public ResponseEntity tallenna(@Validated @RequestBody List<Vastaus> vastauslista, Errors errors) { 
		System.out.println(errors);
		if (errors.hasErrors()) {
			
	        }
			
			System.out.println(vastauslista);
			for (Vastaus vastaus : vastauslista){
			vasrepo.save(vastaus);
			Kysymys kys = kysrepo.findOne(vastaus.getId());
			vastaus.setId(0L);
			vasrepo.save(vastaus);
			kys.getVastauslista().add(vastaus);
			kysrepo.save(kys);
			}
			
			return ResponseEntity.ok(vastauslista);
		}
	
	
	/*
	
    @GetMapping("/")
    public String lataa(Model model) {
        model.addAttribute("kysymykset",kysrepo.findAll());
        model.addAttribute("vastaus",new Vastaus());
        return "hello";
    }
    @PostMapping("/vastaa")
    public String vastausTallennus(@Valid Vastaus vastaus,BindingResult result) {
    	if (result.hasErrors()) {
			System.out.println(result);
			return "redirect:/";
		}
		else{
			System.out.println(result);
			return "redirect:/";
		}
    }*/
    
}