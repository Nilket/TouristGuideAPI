package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }


    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    /*
    @GetMapping("/all")
    public String getAttractions(Model model) {
        model.addAllAttributes(touristService.getAttractions());
        return "all-attractions";
    }
    */

    @GetMapping("/about")
    public String getAboutUs(Model model) {

        return "about-us";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionsByName(name);
        return new ResponseEntity<TouristAttraction>(touristAttraction, HttpStatus.OK);
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




    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "index";
    }


}
