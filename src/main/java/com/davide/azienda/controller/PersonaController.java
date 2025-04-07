package com.davide.azienda.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.davide.azienda.dto.PersonaDto;
import com.davide.azienda.service.PersonaService;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/home")
    public String home(Model model) {
        List<PersonaDto> persone = service.getAllPersona();
        model.addAttribute("persone", persone);
        return "home";  
    }

//    @PostMapping("/home/getDetail")
//    public String getPersonaDetail(@RequestParam String strId, Model model) {
//        try {
//            int id = Integer.parseInt(strId);
//            PersonaDto dto = service.getPersona(id);
//            if (dto != null) {
//                model.addAttribute("persona", dto);  
//            } else {
//                model.addAttribute("error", "Persona non trovata.");
//            }
//        } catch (NumberFormatException e) {
//            model.addAttribute("error", "Per favore inserisci un ID valido (solo numeri).");
//        } catch (Exception e) {
//            model.addAttribute("error", "Errore nel recupero dell'utente.");
//        }
//        return "home";  
//    }
    
    @GetMapping("/home/get")
    public String getPersona(@RequestParam String strId, Model model) {
        try {
            int id = Integer.parseInt(strId);
            PersonaDto dto = null;
            dto = service.getPersona(id);
            dto.getId();
            model.addAttribute("persona", dto);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Per favore inserisci un ID valido (solo numeri).");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nel recupero dell'utente.");
        }

        int id = Integer.parseInt(strId);
        model.addAttribute("persone", service.getPersona(id));
        
        return "home";  
    }

    @PostMapping("/home/add")
    public String addPersona(
        @RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam int anniAnzianitaLavorativa, 
        @RequestParam int retribuzioneAnnua, 
        Model model) {

        try {
            PersonaDto dto = new PersonaDto();
            dto.setNome(nome);
            dto.setCognome(cognome);
            dto.setAnniAnzianitaLavorativa(anniAnzianitaLavorativa);
            dto.setRetribuzioneAnnua(retribuzioneAnnua);
            
            service.addPersona(dto);  // Aggiungo la persona tramite il servizio
            model.addAttribute("success", "Persona aggiunta con successo!");
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiunta della persona.");
        }
        List<PersonaDto> persone = service.getAllPersona();
        model.addAttribute("persone", persone);
        return "home";
    }

    @PostMapping("/home/update")
    public String updatePersona(
        @RequestParam String strId, 
        @RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam int anniAnzianitaLavorativa, 
        @RequestParam int retribuzioneAnnua, 
        Model model) {

        try {
            int id = Integer.parseInt(strId);
            PersonaDto dto = null;
            dto = service.getPersona(id);
            dto.getId();
            if (service.getPersona(id) == null) {
                model.addAttribute("error", "Persona non trovata.");
            } else {
            	
            	dto.setNome(nome);
            	dto.setCognome(cognome);
            	dto.setAnniAnzianitaLavorativa(anniAnzianitaLavorativa);
            	dto.setRetribuzioneAnnua(retribuzioneAnnua);
            	service.updatePersona(id, dto);
            	model.addAttribute("success", "Persona aggiornata con successo!");
            }

        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID non valido.");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiornamento della persona.");
        }
        int id = Integer.parseInt(strId);
        if (service.getPersona(id) != null) {
        	model.addAttribute("persone", service.getPersona(id));        	
        } else {
        	List<PersonaDto> persone = service.getAllPersona();
            model.addAttribute("persone", persone);
        }
        return "home";
    }

    @PostMapping("/home/delete")
    public String deletePersona(@RequestParam String strId, Model model) {
        try {
            int id = Integer.parseInt(strId);
            PersonaDto dto = null;
            dto = service.getPersona(id);
            dto.getId();
            if (service.getPersona(id) == null) {
                model.addAttribute("error", "Persona non trovata.");
                return "home";
            }
            service.deletePersona(id);
            model.addAttribute("success", "Persona eliminata con successo!");
        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID non valido.");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'eliminazione della persona.");
        }
        List<PersonaDto> persone = service.getAllPersona();
        model.addAttribute("persone", persone);
        return "home";
    }
}
