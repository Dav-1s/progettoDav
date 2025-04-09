package com.davide.azienda.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.davide.azienda.dto.AmministratoreDTO;
import com.davide.azienda.dto.DirigenteDTO;
import com.davide.azienda.dto.DivisioneDTO;
import com.davide.azienda.dto.PersonaDTO;
import com.davide.azienda.dto.ProgettistaDTO;
import com.davide.azienda.dto.StagistaDTO;
import com.davide.azienda.model.TipoPersona;
import com.davide.azienda.service.AmministratoreService;
import com.davide.azienda.service.DivisioneService;
import com.davide.azienda.service.PersonaService;
import com.davide.azienda.service.DirigenteService;
import com.davide.azienda.service.ProgettistaService;
import com.davide.azienda.service.StagistaService;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private PersonaService servicePer;
    
    @Autowired
    private AmministratoreService serviceAmm;
    
    @Autowired
    private DirigenteService serviceDir;
    
    @Autowired
    private ProgettistaService servicePro;
    
    @Autowired
    private StagistaService serviceSta;
    
    @Autowired
    private DivisioneService serviceDiv;

    @GetMapping("/home")
    public String home(Model model) {
        List<PersonaDTO> persone = servicePer.findAllPer();
        model.addAttribute("persone", persone);
        
        List<DivisioneDTO> divisioni = serviceDiv.findAllDiv();
        model.addAttribute("divisioni", divisioni);
        
        return "home";  
    }
    
    @GetMapping("/home/get")
    public String getPersona(@RequestParam String strId, Model model) {
        try {
            Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = servicePer.findPerById(id);
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
        Optional<PersonaDTO> opDto = servicePer.findPerById(id);
        PersonaDTO dto = null;
        if (opDto.isPresent()) {
            dto = opDto.get();
            model.addAttribute("persone", dto);
        }
        
        return "home";  
    }
    
    @PostMapping("/home/addDivisione")
    public String addDivisione(
        @RequestParam String nome, 
        @RequestParam(required = false) Long idDirigente, 
        Model model) {

        try {
            
            DivisioneDTO dto = new DivisioneDTO();
            dto.setNome(nome);
            dto.setIdDirigente(idDirigente);  
            
            
            serviceDiv.saveDiv(dto); 
            
            model.addAttribute("success", "Divisione aggiunta con successo!");
            
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiunta della divisione.");
        }
        List<PersonaDTO> persone = servicePer.findAllPer();
        model.addAttribute("persone", persone);
        
        List<DivisioneDTO> divisioni = serviceDiv.findAllDiv();
        model.addAttribute("divisioni", divisioni);
        
        
        return "home";
    }


    @PostMapping("/home/add")
    public String addPersona(
    	@RequestParam String nome, 
        @RequestParam String cognome,
        Model model) {

        try {
            PersonaDTO dto = new PersonaDTO();
            dto.setNome(nome);
            dto.setCognome(cognome);
            
            
            servicePer.savePer(dto);  // Aggiungo la persona tramite il servizio
            model.addAttribute("success", "Persona aggiunta con successo!");
            
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'aggiunta della persona.");
        }
        List<PersonaDTO> persone = servicePer.findAllPer();
        model.addAttribute("persone", persone);
        
        List<DivisioneDTO> divisioni = serviceDiv.findAllDiv();
        model.addAttribute("divisioni", divisioni);
        return "home";
    }

    @PostMapping("/home/update")
    public String updatePersona(
        @RequestParam String strId, 
        @RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam String matricola, 
        @RequestParam Integer anniAnzianita, 
        @RequestParam String tipo,
        @RequestParam(required = false) BigDecimal premioDicembre,
        @RequestParam(required = false) Long strIdDivisione,
        @RequestParam(required = false) Integer oreStage,
        Model model) {

        try {
        	Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = servicePer.findPerById(id);
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
                int stipendioStaA = 30000;
                
                if (tipoPersona == TipoPersona.Amministratore) {
                	dto.setStipendioAnnuo(stipendioAmm);
                	servicePer.updatePer(id, dto);
                	AmministratoreDTO ammDto =new AmministratoreDTO();
                	ammDto.setIdPersona(id);
                	serviceAmm.saveAmm(ammDto);
                } else if (tipoPersona == TipoPersona.Dirigente) {
                	dto.setStipendioAnnuo(stipendioDir);
                	servicePer.updatePer(id, dto);
                	DirigenteDTO dirDto = new DirigenteDTO();
                	dirDto.setPremioDicembre(premioDicembre);
                	dirDto.setIdDivisione(strIdDivisione);
                	dirDto.setIdPersona(id);
                	serviceDir.saveDir(dirDto);
                } else if (tipoPersona == TipoPersona.Progettista) {
                	dto.setStipendioAnnuo(stipendioPro);
                	servicePer.updatePer(id, dto);
                	ProgettistaDTO proDto = new ProgettistaDTO();
                	proDto.setIdDivisione(strIdDivisione);
                	proDto.setIdPersona(id);
                	servicePro.savePro(proDto);
                } else if (tipoPersona == TipoPersona.Stagista) {
                	dto.setStipendioAnnuo(stipendioSta);
                	servicePer.updatePer(id, dto);
                	StagistaDTO staDto =new StagistaDTO();
                	staDto.setIdPersona(id);
                	serviceSta.saveSta(staDto);
                	int oreAccumulate = 0 + serviceSta.findStaById(id).get().getOreStage();
                	staDto.setOreStage(oreAccumulate + oreStage);
                	serviceSta.saveSta(staDto);
                	oreAccumulate = 0 + serviceSta.findStaById(id).get().getOreStage();
                	if (oreAccumulate >= 100) {
                		dto.setStipendioAnnuo(stipendioStaA);
                		servicePer.updatePer(id, dto);
                	}
                	
                }
                servicePer.updatePer(id, dto);
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
        if (servicePer.findPerById(id) != null) {
        	Optional<PersonaDTO> opDto = servicePer.findPerById(id);
            PersonaDTO dto = null;
            if (opDto.isPresent()) {
                dto = opDto.get();
                model.addAttribute("persone", dto);
            }
        	      	
        } else {
        	List<PersonaDTO> persone = servicePer.findAllPer();
            model.addAttribute("persone", persone);
            
        }
        List<DivisioneDTO> divisioni = serviceDiv.findAllDiv();
        model.addAttribute("divisioni", divisioni);
        return "home";
    }

    @PostMapping("/home/delete")
    public String deletePersona(@RequestParam String strId, Model model) {
        try {
        	Long id = Long.parseLong(strId);
            Optional<PersonaDTO> opDto = null;
            opDto = servicePer.findPerById(id);
            PersonaDTO dto = opDto.get();
            if (servicePer.findPerById(id) == null) {
                model.addAttribute("error", "Persona non trovata.");
                return "home";
            }
            servicePer.deletePer(id);
            model.addAttribute("success", "Persona eliminata con successo!");
        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID non valido.");
        } catch (NullPointerException e) {
        	String errorMessage = "Persona non trovata.";
            model.addAttribute("error", errorMessage);
        } catch (Exception e) {
            model.addAttribute("error", "Errore nell'eliminazione della persona.");
        }
        List<PersonaDTO> persone = servicePer.findAllPer();
        model.addAttribute("persone", persone);
        
        List<DivisioneDTO> divisioni = serviceDiv.findAllDiv();
        model.addAttribute("divisioni", divisioni);
        return "home";
    }
}
