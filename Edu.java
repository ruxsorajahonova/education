package Education;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Edu {
    private String eduName;
    private String address;
    private int phoneNumber;

    Set<Group> groups=new HashSet<>();
    Set<Student>students=new HashSet<>();

    public Edu(String groupName){}

    public Edu(String eduName, String address, int phoneNumber) {
        this.eduName = eduName;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addGroupInEdu(Group group){
        getGroups().add(group);
        System.out.println("saved");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edu edu = (Edu) o;
        return phoneNumber == edu.phoneNumber && Objects.equals(eduName, edu.eduName) && Objects.equals(address, edu.address) && Objects.equals(groups, edu.groups) && Objects.equals(students, edu.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eduName, address, phoneNumber, groups, students);
    }
}
