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


@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // Get mappings
    @GetMapping("/attractions/{name}/tags")
    public String tags(Model model, @PathVariable String name) {
        List<Tags> listOfTags = touristService.getTags(name);


        return "tags";
    }

    @GetMapping("/attractions")
    public String attractions(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "index";
    }

    @GetMapping("/attractionsList")
    public String attractionsList(Model model) {
        model.addAttribute("attractionsList", touristService.getAttractions());
        model.addAttribute("touristAttraction", new TouristAttraction());
        return "attractionList";
    }


    @GetMapping("attractions/{name}")
    public String getAttractionByName(@PathVariable String name, Model model) {
        model.addAttribute("attractionsByName", touristService.getAttractionsByName(name));
        return "attraction";
    }


    @GetMapping("/add")
    public String addTouristAttraction(Model model) {
        TouristAttraction attraction = new TouristAttraction();
        attraction.setBy(Byer.KØBENHAVN);
        model.addAttribute("attraction", attraction);
        model.addAttribute("city", Byer.values());
        model.addAttribute("tags", Tags.values());
        return "add";
    }

    @GetMapping("/save")
    public String savedAttractions(Model model) {
        model.addAttribute("attractions", touristService.getAttractions());
        return "save";
    }


    //Post mappings
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction newTouristAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String save(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.addAttractions(touristAttraction);
        return "redirect:/save";
    }

}