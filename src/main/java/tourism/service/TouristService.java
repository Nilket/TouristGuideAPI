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

    public void setAttractions(List<TouristAttraction> attractions) {
        touristRepository.setAttractions(attractions);
    }

    public void addAttractions(TouristAttraction touristAttraction){
        touristRepository.addAttractions(touristAttraction);
    }

    public void deleteAttraction(TouristAttraction touristAttraction){
        touristRepository.deleteAttraction(touristAttraction);
    }

    public void updateAttraction(String name, String description) {
        touristRepository.updateAttraction(name, description);
    }
}
