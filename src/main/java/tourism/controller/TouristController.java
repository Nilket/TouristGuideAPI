package tourism.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tourism.model.TouristAttraction;

@Controller
public class TouristController {


    @RequestMapping("attractions")
    public ResponseEntity<TouristAttraction> getAttractions(){
        return null;
    }


}
