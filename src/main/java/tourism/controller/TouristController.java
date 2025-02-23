package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.Byer;
import tourism.model.Tags;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;
import java.util.UUID;


@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }



    @GetMapping("/attractions")
    public String attractions(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "index";
    }
    /*
    @GetMapping("/suggestion")
    public String suggestion(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "add";
    } */




    @GetMapping("/attractionsList")
    public String attractionsList(Model model) {
        model.addAttribute("attractionsList", touristService.getAttractions());
        model.addAttribute("touristAttraction",new TouristAttraction());
        return "attractionList";
    }

    /*
    @GetMapping("/attractions/{name}/edit")
    public String editWindow(String name, Model model){
        model.addAttribute("editWindow", touristService.getAttractionsByName(name));

        return "edit";
    } */



    @GetMapping("attractions/{name}")
    public String getAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("attractionsByName", touristService.getAttractionsByName(name));
        return "attraction";
    }

    //_________________________
    // De tre nedenstående metoder er for at tilføje en ny attraction
    @GetMapping("/add")
    public String addTouristAttraction(Model model) {
        TouristAttraction attraction = new TouristAttraction();
        attraction.setBy(Byer.KØBENHAVN);
        model.addAttribute("attraction", attraction);
        model.addAttribute("city", Byer.values());
        model.addAttribute("tags", Tags.values());
        return "add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute TouristAttraction touristAttraction){
        touristService.addAttractions(touristAttraction);
        return "redirect:/save";
    }

    @GetMapping("/save")
    public String savedAttractions(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "save";
    }
    // Hertil
    //___________________________

    /*
    //Posts
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }

    Den her metode virker ikke, tror det fordi jeg har lavet vores update metode void,
    hvilket den også skal være, fordi den behøver ikke at retunere noget
     */
    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name){
        TouristAttraction newTouristAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }


    @GetMapping("/attraction/edit/{id}")
    public String editAttraction(@PathVariable UUID id, Model model){
        TouristAttraction touristAttraction = touristService.getOrderById(id);
        if(touristAttraction.getId() == null){
            throw new IllegalArgumentException("Id not found");
        }
        model.addAttribute("attraction", touristAttraction);
        model.addAttribute("city", Byer.values());
        model.addAttribute("tags", Tags.values());

        return "edit";
    }


    @PostMapping("/attraction/edit/{id}")
    public String postEditAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateAttraction(touristAttraction);
        return "redirect:/save";
    }


    @GetMapping("/attraction/tags/{id}")
    public String tags(Model model, @PathVariable UUID id){
        model.addAttribute("touristAttraction", touristService.getOrderById(id).getName());
        model.addAttribute("touristAttraction", touristService.getOrderById(id));
        return "tags";
    }


    @PostMapping("/attraction/delete/{id}")
    public String removeAttraction(@PathVariable UUID id){
        touristService.removeAttraction(id);
        return "redirect:/removeAttraction";
    }

    @GetMapping("/attraction/delete/{id}")
    public String removeAttractionNew(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "removeAttraction";
    }




}
