package tourism.repository;


import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository(List<TouristAttraction> attractions) {
        this.attractions = attractions;
    }

    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<TouristAttraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttractions(TouristAttraction touristAttraction){
        attractions.add(touristAttraction);
    }

    public void deleteAttraction(TouristAttraction touristAttraction){
        attractions.remove(touristAttraction);
    }

    public void updateAttraction(String name, String description){
        for(TouristAttraction i: attractions){
            if(i.getName().equalsIgnoreCase(name)){
                i.setDescription(description);
            }
        }
    }
}
