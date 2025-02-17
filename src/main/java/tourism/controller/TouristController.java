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
    public String suggestion(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "attractionSuggestion";
    }

    @GetMapping("/submit")
    public String submit(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "suggestionsSubmit";
    }

    @GetMapping("/attractionsList")
    public String attractionsList(Model model) {
        model.addAttribute("attractionsList", touristService.getAttractions());
        return "attractionList";
    }


    @GetMapping("/json")
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }


    @GetMapping("/attractions/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionsByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    //Posts
    @PostMapping("/attractions/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.addAttractions(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/attractions/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("/attractions/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction newTouristAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }


}
