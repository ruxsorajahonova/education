package Education;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {
    private String gruopName;
    Set<Student> students=new HashSet<>();

    public Group(){}

    public Group(String gruopName) {
        this.gruopName = gruopName;

    }

    public String getGruopName() {
        return gruopName;
    }

    public void setGruopName(String gruopName) {
        this.gruopName = gruopName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(gruopName, group.gruopName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gruopName, students);
    }
}
