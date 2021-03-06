package institution;

import person.Student;
import person.consciousness.KnowledgeLevel;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Student> studentsList;

    public University(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public KnowledgeLevel getAverageLevel() {
        KnowledgeLevel averageLevel;
        if (!studentsList.isEmpty()) {
            int levelsSum = studentsList.stream().mapToInt(student -> student.getKnowledgeLevel().ordinal()).sum();
            averageLevel = KnowledgeLevel.values()[Math.round((float) levelsSum / (float) studentsList.size())];
        } else {
            averageLevel = null;
        }
        return averageLevel;
    }

    public void setStudents(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
