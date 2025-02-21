package tourism.repository;


import org.springframework.stereotype.Repository;
import tourism.model.Byer;
import tourism.model.Tags;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();


    public TouristRepository(List<TouristAttraction> attractions) {
        this.attractions = attractions;
        addAttractions(new TouristAttraction("Tivoli", "Tivoli er den suverænt mest besøgte turistattraktion i Danmark med 2,3 mio. besøgende i 2021. Parken er Europas fjerdemest besøgte forlystelsespark",List.of(Tags.FORLYSTELSESPARK, Tags.UNDERHOLDNING, Tags.KONCERT, Tags.KULTUR, Tags.RESTAURANT), Byer.KØBENHAVN));
        addAttractions(new TouristAttraction("DR Byen", "DR Byen er hovedkvarteret for Danmarks Radio (DR) og et imponerende mediehus i København. Bygningen består af fire segmenter, der huser DR's tv- og radioproduktion, nyheder og koncerthuset. DR Koncerthuset, designet af arkitekten Jean Nouvel, er en af Europas mest anerkendte koncertsale med fantastisk akustik og et futuristisk udseende.", List.of(Tags.GRATIS, Tags.KONCERT, Tags.UNDERHOLDNING), Byer.KØBENHAVN));
        addAttractions(new TouristAttraction("Den Lille Havfrue", "Inspireret af H.C. Andersens eventyr, denne lille, men berømte bronzestatue sidder på en sten ved Langelinie. Selvom den ofte kaldes skuffende lille af turister, er den stadig et must-see og en af Københavns mest kendte vartegn.", List.of(Tags.KUNST, Tags.KULTUR, Tags.GRATIS), Byer.KØBENHAVN));
        addAttractions(new TouristAttraction("Nyhavn", "Den ikoniske havnepromenade med farverige bygninger, hyggelige restauranter og gamle træskibe. Nyhavn var engang hjem for forfatteren H.C. Andersen og er i dag et af de mest fotograferede steder i København. Perfekt til en gåtur langs vandet eller en bådtur i kanalerne.", List.of(Tags.GRATIS, Tags.RESTAURANT, Tags.BØRNEVENLIG), Byer.KØBENHAVN));

    }

    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    public List<Tags> getTags(String name){
        for(TouristAttraction i: attractions){
            if(i.getName().equalsIgnoreCase(name)){
                return i.getTags();
            }
        }
        return null;
    }

    public TouristAttraction getAttractionsByName(String name) {
        for (TouristAttraction i : attractions) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public void setAttractions(List<TouristAttraction> attractions) {
        this.attractions = attractions;
    }

    public TouristAttraction addAttractions(TouristAttraction touristAttraction) {
        attractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction deleteAttraction(String name) {
       TouristAttraction touristAttraction1 = null;
        for(TouristAttraction t : attractions){
            if(t.getName().equalsIgnoreCase(name)){
                touristAttraction1=t;
                attractions.remove(t);
            }
        }
        return touristAttraction1;
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction i : attractions) {
            if (i.getName().equalsIgnoreCase(touristAttraction.getName())) {
                i.setDescription(touristAttraction.getDescription());
                return i;
            }
        }
        return null;
    }
}
