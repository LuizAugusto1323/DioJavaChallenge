package domain;

public abstract class Content {

    protected static final double XP_DEFAULT = 10;
    private final String title;
    private String description;

    public Content(String title) {
        this.title = title;
    }

    public abstract double calculateXp();

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
