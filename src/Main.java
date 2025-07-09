import domain.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Course javaCourse = new Course("Java Course", 8);
        javaCourse.setDescription("This is a Java Course");

        System.out.println("--------------------------------------------------");

        switch (javaCourse.getTypeCourse()) {
            case SHORT -> System.out.println("This is a Short Course");
            case NORMAL -> System.out.println("This is a Normal Course");
            case EXTENDED -> System.out.println("This is a Extended Course");
        }

        System.out.println("--------------------------------------------------");

        Course kotlinCourse = new Course("Kotlin Course", 16);
        kotlinCourse.setDescription("This is a Kotlin Course");

        System.out.printf("This course has %s hours\n", kotlinCourse.getWorkload());

        System.out.println("--------------------------------------------------");

        Mentoring javaMentoring = new Mentoring("Java Mentoring");
        javaMentoring.setDescription("This is a Java Mentoring");

        System.out.printf("This mentoring began at %s\n", javaMentoring.getDate());

        System.out.println("--------------------------------------------------");

        Set<Content> contents = new LinkedHashSet<>();
        contents.add(javaCourse);
        contents.add(kotlinCourse);
        contents.add(javaMentoring);

        System.out.printf("Current content: %s\n", contents);

        System.out.println("--------------------------------------------------");

        Dev dev0 = new Dev("Luiz Augusto");
        dev0.setSubscribedContent(contents);

        Set<Dev> devs = new HashSet<>();
        devs.add(dev0);

        System.out.printf("Current devs: %s\n", devs);

        System.out.println("--------------------------------------------------");

        Bootcamp bootcamp = new Bootcamp("Java", "This is a Java Bootcamp");
        bootcamp.setName("Java Bootcamp");
        bootcamp.setDescription("This is a Bootcamp with Java");
        bootcamp.setContents(contents);

        System.out.printf("Bootcamp name: %s\n", bootcamp.getName());
        System.out.printf("Bootcamp description: %s\n", bootcamp.getDescription());
        System.out.printf("Bootcamp initial date: %s\n", bootcamp.getInitialDate());
        System.out.printf("Bootcamp final date: %s\n", bootcamp.getFinalDate());
        System.out.printf("Bootcamp subscribed devs: %s\n", bootcamp.getSubscribedDevs());
        System.out.printf("Bootcamp content: %s\n", bootcamp.getContents());

        System.out.println("--------------------------------------------------");

        dev0.signUpBootcamp(bootcamp);
        System.out.printf("Bootcamp new subscribed devs: %s\n", bootcamp.getSubscribedDevs());
        System.out.printf("Subscribed content: %s, by dev = %s\n", dev0.getSubscribedContent(), dev0.getName());

        System.out.println("--------------------------------------------------");

        Set<Content> finishedContent = Set.of(javaCourse, kotlinCourse);
        dev0.setFinishedContent(finishedContent);
        dev0.progress();

        System.out.printf("Finished content: %s, by dev = %s\n", dev0.getFinishedContent(), dev0.getName());
        System.out.printf("Current XP = %s, by dev = %s\n", dev0.calculateTotalXp(), dev0.getName());

        System.out.println("--------------------------------------------------");
    }

}
