package com.davide.azienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davide.azienda.dto.PersonaDTO;
import com.davide.azienda.model.TipoPersona;
import com.davide.azienda.service.PersonaService;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/home")
    public String home(Model model) {
        List<PersonaDTO> persone = service.findAllPer();
        model.addAttribute("persone", persone);
        return "home";  
    }
    
    @GetMapping("/home/get")
    public String getPersona(@RequestParam String strId, Model model) {
        try {
            Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = service.findPerById(id);
            PersonaDTO dto = null;
            if (opDto.isPresent()) {
                dto = opDto.get();
                model.addAttribute("persona", dto);
            } else {
                model.addAttribute("error", "Persona non trovata.");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Per favore inserisci un ID valido (solo numeri).");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nel recupero dell'utente.");
        }

        Long id = Long.parseLong(strId);
        Optional<PersonaDTO> opDto = service.findPerById(id);
        PersonaDTO dto = null;
        if (opDto.isPresent()) {
            dto = opDto.get();
            model.addAttribute("persone", dto);
        }
        
        return "home";  
    }

    @PostMapping("/home/add")
    public String addPersona(
    	@RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam String matricola, 
        @RequestParam int anniAnzianita,  
        @RequestParam String tipo,
        Model model) {

        try {
            PersonaDTO dto = new PersonaDTO();
            dto.setNome(nome);
            dto.setCognome(cognome);
        	dto.setMatricola(matricola);
            dto.setAnniAnzianita(0+anniAnzianita);
        	TipoPersona tipoPersona = TipoPersona.valueOf(tipo);
            dto.setTipo(tipoPersona);
            int stipendioAmm = 130000;
            int stipendioDir = 70000;
            int stipendioPro = 40000;
            int stipendioSta = 0;
            
            if (tipoPersona == TipoPersona.Amministratore) {
            	dto.setStipendioAnnuo(stipendioAmm);
            } else if (tipoPersona == TipoPersona.Dirigente) {
            	dto.setStipendioAnnuo(stipendioDir);
            } else if (tipoPersona == TipoPersona.Progettista) {
            	dto.setStipendioAnnuo(stipendioPro);
            } else if (tipoPersona == TipoPersona.Stagista) {
            	dto.setStipendioAnnuo(stipendioSta);
            }
            
            service.savePer(dto);  // Aggiungo la persona tramite il servizio
            model.addAttribute("success", "Persona aggiunta con successo!");
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiunta della persona.");
        }
        List<PersonaDTO> persone = service.findAllPer();
        model.addAttribute("persone", persone);
        return "home";
    }

    @PostMapping("/home/update")
    public String updatePersona(
        @RequestParam String strId, 
        @RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam String matricola, 
        @RequestParam int anniAnzianita, 
        @RequestParam String tipo,
        Model model) {

        try {
        	Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = service.findPerById(id);
            PersonaDTO dto = null;
            if (opDto.isPresent()) {
            	dto = opDto.get();
            	model.addAttribute("persona", opDto.get());
            	
            	dto.setNome(nome);
            	dto.setCognome(cognome);
            	dto.setMatricola(matricola);
            	dto.setAnniAnzianita(0+anniAnzianita);
            	TipoPersona tipoPersona = TipoPersona.valueOf(tipo);
            	dto.setTipo(tipoPersona);
                int stipendioAmm = 130000;
                int stipendioDir = 70000;
                int stipendioPro = 40000;
                int stipendioSta = 0;
                
                if (tipoPersona == TipoPersona.Amministratore) {
                	dto.setStipendioAnnuo(stipendioAmm);
                } else if (tipoPersona == TipoPersona.Dirigente) {
                	dto.setStipendioAnnuo(stipendioDir);
                } else if (tipoPersona == TipoPersona.Progettista) {
                	dto.setStipendioAnnuo(stipendioPro);
                } else if (tipoPersona == TipoPersona.Stagista) {
                	dto.setStipendioAnnuo(stipendioSta);
                }
            	service.updatePer(id, dto);
            	model.addAttribute("success", "Persona aggiornata con successo!");
            	
            } else {
            	model.addAttribute("error", "Persona non trovata.");
            }

        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID non valido.");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiornamento della persona.");
        }
        Long id = Long.parseLong(strId);
        if (service.findPerById(id) != null) {
        	Optional<PersonaDTO> opDto = service.findPerById(id);
            PersonaDTO dto = null;
            if (opDto.isPresent()) {
                dto = opDto.get();
                model.addAttribute("persone", dto);
            }
        	      	
        } else {
        	List<PersonaDTO> persone = service.findAllPer();
            model.addAttribute("persone", persone); 
        }
        return "home";
    }

    @PostMapping("/home/delete")
    public String deletePersona(@RequestParam String strId, Model model) {
        try {
        	Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = null;
            opDto = service.findPerById(id);
            PersonaDTO dto = opDto.get();
            if (service.findPerById(id) == null) {
                model.addAttribute("error", "Persona non trovata.");
                return "home";
            }
            service.deletePer(id);
            model.addAttribute("success", "Persona eliminata con successo!");
        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID non valido.");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'eliminazione della persona.");
        }
        List<PersonaDTO> persone = service.findAllPer();
        model.addAttribute("persone", persone);
        return "home";
    }
}
