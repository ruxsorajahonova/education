package Education;

import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private byte age;
    private String password;
    private int phoneNumber;



    public Student(String name, String surname, byte age, String password, int phoneNumber) {
        this.name = name;

        this.surname = surname;
        this.age = age;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && phoneNumber == student.phoneNumber && Objects.equals(name, student.name)  && Objects.equals(surname, student.surname) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, password, phoneNumber);
    }
}

