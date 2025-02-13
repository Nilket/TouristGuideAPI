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
        addAttractions(new TouristAttraction("Tivoli", "Tivoli er den suverænt mest besøgte turistattraktion i Danmark med 2,3 mio. besøgende i 2021. Parken er Europas fjerdemest besøgte forlystelsespark"));
        addAttractions(new TouristAttraction("DR Byen", "DR Byen er hovedkvarteret for Danmarks Radio (DR) og et imponerende mediehus i København. Bygningen består af fire segmenter, der huser DR's tv- og radioproduktion, nyheder og koncerthuset. DR Koncerthuset, designet af arkitekten Jean Nouvel, er en af Europas mest anerkendte koncertsale med fantastisk akustik og et futuristisk udseende."));
        addAttractions(new TouristAttraction("Den Lille Havfrue", "Inspireret af H.C. Andersens eventyr, denne lille, men berømte bronzestatue sidder på en sten ved Langelinie. Selvom den ofte kaldes skuffende lille af turister, er den stadig et must-see og en af Københavns mest kendte vartegn."));
        addAttractions(new TouristAttraction("Nyhavn", "Den ikoniske havnepromenade med farverige bygninger, hyggelige restauranter og gamle træskibe. Nyhavn var engang hjem for forfatteren H.C. Andersen og er i dag et af de mest fotograferede steder i København. Perfekt til en gåtur langs vandet eller en bådtur i kanalerne."));

    }

    public List<TouristAttraction> getAttractions() {
        return attractions;
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

    public List<TouristAttraction> deleteAttraction(TouristAttraction touristAttraction) {
        attractions.remove(touristAttraction);
        return attractions;
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
