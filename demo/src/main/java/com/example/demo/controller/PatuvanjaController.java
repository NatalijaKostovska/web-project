package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class PatuvanjaController {
    private final PatuvanjaService patuvanjaService;
    private final KorisnikService korisnikService;
    private final ResoranService restoranService;
    private final GradService gradService;
    private final HotelService hotelService;


    public PatuvanjaController(PatuvanjaService patuvanjaService, KorisnikService korisnikService,
                               ResoranService restoranService, GradService gradService, HotelService hotelService) {
        this.patuvanjaService = patuvanjaService;
        this.korisnikService = korisnikService;
        this.restoranService = restoranService;
        this.gradService = gradService;
        this.hotelService = hotelService;
    }
    //PRIKAZ NA SITE ENTITETI
    @GetMapping
    public String showAll(Model model){
    List<Patuvanja> patuvanjaList = this.patuvanjaService.findAllTrips();
    model.addAttribute("patuvanjaList",patuvanjaList);
    return "trips";
    }

    @GetMapping("/restorani")
    public String showAllRestorani(Model model){
        List<Restoran> restoranList = this.restoranService.getAllRestorani();
        model.addAttribute("restoranList",restoranList);
        return "restorani";
    }

    @GetMapping("/korisnici")
    public String showAllKorisnici(Model model){
        List<Korisnik> korisnici = this.korisnikService.getAllKorisnici();
        model.addAttribute("korisnici", korisnici);
        return "korisnici";
    }

    @GetMapping("/hoteli")
    public String showAllHoteli(Model model){
        List<Hotel> hoteli = this.hotelService.findAllHotels();
        model.addAttribute("hoteli", hoteli);
        return "hoteli";
    }

    @GetMapping("/gradovi")
    public String showAllGradovi(Model model){
        List<Grad> gradovi = this.gradService.findAll();
        model.addAttribute("gradovi", gradovi);
        return "gradovi";
    }

    @PostMapping("/{id}/delete")
    public String deletePatuvanje(@PathVariable Long id){
        this.patuvanjaService.deleteById(id);
        return "redirect:/trips";
    }

    @GetMapping("/add-new-trip")
    public String addNewTrip(Model model){
        List<Hotel>hotelList = this.hotelService.findAllHotels();
        List<Grad>gradList = this.gradService.findAll();
        List<Restoran>restoranList = this.restoranService.getAllRestorani();
        model.addAttribute("gradovi",gradList);
        model.addAttribute("restoran",restoranList);
        model.addAttribute("hotel",hotelList);
        model.addAttribute("patuvanje", new Patuvanja());
        return "add-trip";
    }


    @GetMapping("/add-new-grad")
    public String addNewGrad(Model model){
        model.addAttribute("grad", new Grad());
        return "add-grad";
    }

    @GetMapping("/add-new-korisnik")
    public String addNewKorisnik(Model model){
        List<Patuvanja>patuvanjaList = this.patuvanjaService.findAllTrips();
        model.addAttribute("patuvanjaList",patuvanjaList);
        model.addAttribute("korisnik", new Korisnik());
        return "add-korisnik";
    }

    @GetMapping("/add-new-restoran")
    public String addNewRestoran(Model model){
        model.addAttribute("restoran", new Restoran());
        return "add-restoran";
    }


    @GetMapping("/add-new-hotel")
    public String addNewHotel(Model model){
        List<Grad>gradList =this.gradService.findAll();
        model.addAttribute("gradList",gradList);
        model.addAttribute("hotel", new Hotel());
        return "add-hotel";
    }

    @GetMapping("/{id}/edit-patuvanje")
    public String editPatuvanje(Model model, @PathVariable Long id){
        try{
            Patuvanja patuvanja = this.patuvanjaService.findById(id);
            List<Hotel>hotelList = this.hotelService.findAllHotels();
            List<Grad>gradList = this.gradService.findAll();
            List<Restoran>restoranList = this.restoranService.getAllRestorani();
            model.addAttribute("gradovi",gradList);
            model.addAttribute("restoran",restoranList);
            model.addAttribute("hotel",hotelList);
            model.addAttribute("patuvanje",patuvanja);
            return "add-trip";
        }catch(RuntimeException ex){
            return "redirect:/patuvanje?error=" + ex.getMessage();
        }
    }

    @GetMapping("/{id}/edit-hotel")
    public String editHotel(Model model, @PathVariable Long id){
        try{
            Hotel hotel = this.hotelService.findById(id);
            List<Grad>gradList = this.gradService.findAll();
            model.addAttribute("gradList",gradList);
            model.addAttribute("hotel", hotel);
            return "add-hotel";
        }catch(RuntimeException ex){
            return "redirect:/hotel?error=" + ex.getMessage();
        }
    }

    @GetMapping("/{id}/edit-grad")
    public String editGrad(Model model, @PathVariable Long id){
        try{
            Grad grad= this.gradService.findById(id);
            model.addAttribute("grad", grad);
            return "add-grad";
        }catch(RuntimeException ex){
            return "redirect:/grad?error=" + ex.getMessage();
        }
    }

    @GetMapping("/{id}/edit-korisnik")
    public String editKorisnik(Model model, @PathVariable Long id){
        try{
            Korisnik korisnik = this.korisnikService.findById(id);
            List<Patuvanja>patuvanjaList = this.patuvanjaService.findAllTrips();
            model.addAttribute("patuvanjaList",patuvanjaList);
            model.addAttribute("korisnik", korisnik);
            return "add-korisnik";
        }catch(RuntimeException ex){
            return "redirect:/korisnik?error=" + ex.getMessage();
        }
    }

    @GetMapping("/{id}/edit-restoran")
    public String editRestoran(Model model, @PathVariable Long id){
        try{
            Restoran restoran = this.restoranService.findById(id);
            model.addAttribute("restoran", restoran);
            return "add-restoran";
        }catch(RuntimeException ex){
            return "redirect:/restoran?error=" + ex.getMessage();
        }
    }
    @PostMapping("/add-new-trip")
    public String save(@Valid Patuvanja patuvanja, Model model, BindingResult bindingResult, MultipartFile image) {
        if (bindingResult.hasErrors()) {
            List<Hotel>hotelList = this.hotelService.findAllHotels();
            List<Grad>gradList = this.gradService.findAll();
            List<Restoran>restoranList = this.restoranService.getAllRestorani();
            model.addAttribute("hotelList", hotelList);
            model.addAttribute("gradList", gradList);
            model.addAttribute("restoranList", restoranList);
            return "/add-trip";
        }
        try {
            this.patuvanjaService.saveTrip(patuvanja,image);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return "redirect:/trips";

    }
    @PostMapping("/add-new-grad")
    public String saveGrad(@Valid Grad grad)
     {
        this.gradService.save(grad);
        return "redirect:/trips/gradovi";
    }
    @PostMapping("/add-new-hotel")
    public String saveHotel(
            @Valid Hotel hotel,
            BindingResult bindingResult,
            Model model) throws IOException {
        if(bindingResult.hasErrors()){
            model.addAttribute("hotel", new Hotel());
            return "add-hotel";
        }
        this.hotelService.saveHotel(hotel);
        return "redirect:/trips/hoteli";
    }

    @PostMapping("/add-new-korisnik")
    public String saveKorisnik(
            @Valid Korisnik korisnik,
            BindingResult bindingResult,
            Model model) {
        if(bindingResult.hasErrors()){
            List<Patuvanja>patuvanjaList = this.patuvanjaService.findAllTrips();
            model.addAttribute("patuvanjaList",patuvanjaList);
            model.addAttribute("korisnik", new Korisnik());
            return "add-korisnik";
        }
        this.korisnikService.saveKorisnik(korisnik);
        return "redirect:/trips/korisnici";
    }

    @PostMapping("/add-new-restoran")
    public String saveRestoran(@Valid Restoran restoran,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("restoran", new Restoran());
            return "add-restoran";
        }
        this.restoranService.saveRestoran(restoran);
        return "redirect:/trips/restorani";
    }
}

