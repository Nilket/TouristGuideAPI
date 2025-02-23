package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.Tags;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tags> getTags(String name){
        return touristRepository.getTags(name);
    }

    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }

    public TouristAttraction getAttractionsByName(String name) {
        return touristRepository.getAttractionsByName(name);
    }

    public TouristRepository setAttractions(List<TouristAttraction> attractions) {
        touristRepository.setAttractions(attractions);
        return touristRepository;
    }

    public TouristAttraction addAttractions(TouristAttraction touristAttraction) {
        touristRepository.addAttractions(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction deleteAttraction(String name) {
        return touristRepository.deleteAttraction(name);

    }

    public void updateAttraction(TouristAttraction touristAttraction) {
        touristRepository.updateAttraction(touristAttraction);
    }


    public TouristAttraction getOrderById(UUID id){
        return touristRepository.getOrderById(id);
    }

    public void removeAttraction(UUID id){
        touristRepository.removeAttraction(id);
    }

}
