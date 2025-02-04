package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController (TouristService touristService){
        this.touristService = touristService;
    }


    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAttractions(){
    List<TouristAttraction> touristAttractions = touristService.getAttractions();
    return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    /*
    Vi har lavet metoderne i service og repository void, det må de ikke være, vi kigger på det,
    på et andet tidspunkt..


    @PostMapping("/add")
        public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.addAttractions(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

     */




}
