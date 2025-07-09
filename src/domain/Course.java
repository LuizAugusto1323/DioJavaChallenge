package domain;

public class Course extends Content {

    private final int workload;

    private final TypeCourse typeCourse;

    public Course(String title, int workload) {
        super(title);
        this.workload = workload;

        if (workload <= 8) {
            this.typeCourse = TypeCourse.SHORT;
        } else if (workload <= 16) {
            this.typeCourse = TypeCourse.NORMAL;
        } else {
            this.typeCourse = TypeCourse.EXTENDED;
        }
    }

    public int getWorkload() {
        return workload;
    }

    public TypeCourse getTypeCourse() {
        return typeCourse;
    }

    @Override
    public double calculateXp() {
        return XP_DEFAULT * workload;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + getTitle() + '\'' +
                "description='" + getDescription() + '\'' +
                "workload=" + workload +
                ", typeCourse=" + typeCourse +
                '}';
    }
}
