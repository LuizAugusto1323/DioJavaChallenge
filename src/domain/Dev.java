package domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private final String name;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> finishedContent = new LinkedHashSet<>();

    public Dev(String name) {
        this.name = name;
    }

    public void signUpBootcamp(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void progress() {
        Optional<Content> content = this.subscribedContent.stream().findFirst();

        if (content.isPresent()) {
            this.subscribedContent.remove(content.get());
        } else {
            System.out.println("No subscribed");
        }
    }

    public double calculateTotalXp() {
        return this.finishedContent.stream().mapToDouble(Content::calculateXp).sum();
    }

    public String getName() {
        return name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getFinishedContent() {
        return finishedContent;
    }

    public void setFinishedContent(Set<Content> finishedContent) {
        this.finishedContent = finishedContent;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(subscribedContent, dev.subscribedContent) && Objects.equals(finishedContent, dev.finishedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContent, finishedContent);
    }
}
