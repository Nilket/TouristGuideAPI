package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

//@SuppressWarnings("ALL")
@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public String test(Model model) {
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


    @GetMapping("/json")
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionsByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    //Posts
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.addAttractions(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

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
