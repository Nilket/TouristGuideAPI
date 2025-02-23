package tourism.model;

import java.util.List;
import java.util.UUID;

public class TouristAttraction {
    private String name;
    private String description;
    private List<Tags> tags;
    private Byer by;
    private String URLName;
    private UUID id;


    public TouristAttraction(String name, String description, List<Tags> tags, Byer by) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.by = by;
        this.URLName = generateURLName();
        this.id = UUID.randomUUID();


    }

    public TouristAttraction() {
    }

    public String generateURLName() {
        String URLName = "";
        for (String s : this.name.split("")) {
            if (!s.equalsIgnoreCase(" ")) {
                URLName += s;
            }
        }
        return URLName;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Byer getBy() {
        return by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBy(Byer by) {
        this.by = by;
    }

    public void setURLName(String URLName) {
        this.URLName = URLName;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }



}
