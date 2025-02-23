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

    @GetMapping("/attractions/{name}/tags")
    public String tags(Model model, @PathVariable String name){
        List<Tags>listOfTags = touristService.getTags(name);


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

    //Posts
    @PostMapping("attractions/update")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateAttraction(touristAttraction);
        return "redirect:/index";
    }

    @PostMapping("attractions/delete/{name}")
    public String deleteTouristAttraction(@PathVariable String name){
        touristService.deleteAttraction(name);
        return "redirect:index";
    }





}
