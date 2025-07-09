package domain;

import java.time.LocalDate;

public class Mentoring extends Content {

    private final LocalDate date;

    public Mentoring(String title) {
        super(title);
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public double calculateXp() {
        return XP_DEFAULT + 20;
    }


    @Override
    public String toString() {
        return "Mentoring{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", date=" + date +
                '}';
    }
}
