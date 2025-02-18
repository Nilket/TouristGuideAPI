package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

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

    @GetMapping("/suggestion")
    public String suggestion(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "attractionSuggestion";
    }
    @GetMapping("/submit")
    public String submit(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "suggestionsSubmit";
    }

    @GetMapping("/attractionsList")
    public String attractionsList(Model model) {
        model.addAttribute("attractionsList", touristService.getAttractions());
        return "attractionList";
    }

    @GetMapping("/attractions/{name}/edit")
    public String editWindow(String name, Model model){
        model.addAttribute("editWindow", touristService.getAttractionsByName(name));

        return "edit";
    }



    @GetMapping("attractions/{name}")
    public String getAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("attractionsByName", touristService.getAttractionsByName(name));
        return "attraction";
    }


    @GetMapping("/add")
    public String addTouristAttraction(@RequestBody TouristAttraction touristAttraction, Model model) {
        model.addAttribute("Tilføj", touristService.addAttractions(touristAttraction));
        return null; //Placeholder indtil vi får det tilføjet
    }


    //Posts
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name){
        TouristAttraction newTouristAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }





}
