package tourism.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<Tags> tags;
    private Byer by;
    private String URLName;


    public TouristAttraction(String name, String description, List<Tags> tags, Byer by) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.by = by;
        this.URLName = generateURLName();

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


}
