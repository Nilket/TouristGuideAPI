package tourism.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<Tags> tags;
    private Byer by;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
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
