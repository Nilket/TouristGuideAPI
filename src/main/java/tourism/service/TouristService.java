package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }

    public TouristAttraction getAttractionsByName(String name){
        return touristRepository.getAttractionsByName(name);
    }

    public TouristRepository setAttractions(List<TouristAttraction> attractions) {
        touristRepository.setAttractions(attractions);
        return touristRepository;
    }



    public List<TouristAttraction> addAttractions(TouristAttraction touristAttraction){
        touristRepository.addAttractions(touristAttraction);
        return touristRepository.getAttractions();
    }

    public TouristRepository deleteAttraction(TouristAttraction touristAttraction){
        touristRepository.deleteAttraction(touristAttraction);
        return touristRepository;
    }

    public TouristRepository updateAttraction(String name, String description) {
        touristRepository.updateAttraction(name, description);
        return touristRepository;
    }

}
