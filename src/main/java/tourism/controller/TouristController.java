package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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






}
