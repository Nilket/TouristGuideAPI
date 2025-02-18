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



@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @PostMapping("/attractions/{name}/tags")
    public String tags(Model model, @ModelAttribute("touristAttraction") TouristAttraction touristAttraction){
        model.addAttribute("touristAttraction", touristAttraction);
        return "tags";
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


    @GetMapping("/submit")
    public String submit(Model model){
        model.addAttribute("attractions", touristService.getAttractions());
        return "save";
    }

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


    @GetMapping("/add")
    public String addTouristAttraction(Model model) {
        TouristAttraction attraction = new TouristAttraction();
        attraction.setBy(Byer.KØBENHAVN);
        model.addAttribute("attraction", attraction);
        model.addAttribute("city", Byer.values());
        model.addAttribute("tags", Tags.values());
        return "add";
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
