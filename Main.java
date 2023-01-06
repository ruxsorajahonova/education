package Education;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Edu> edu = new HashSet<>();
        Set<Group> group = new HashSet<>();
        Set<Student> students = new HashSet<>();


        int step = -1;
        while (step != 0) {
            System.out.println("0=>exit, 1=>addEdu, 2=>editEdu, 3=>deleteEdu, 4=>getEduList, 5=>addGroupInEdu, 6=>getGroupInEdu," +
                    "7=>getGroupList, 8=>deleteGroupInEdu, 9=>editGroupInEdu, 10=>addStudentInGroupInEdu, " +
                    "11=>getStudentInGroupInEdu, 12=>deleteStudentInGroupInEdu");
            step = scanner.nextInt();
            switch (step) {
                case 0:
                    break;
                case 1:
                    System.out.println("education nomini kiriting");
                    String nameEdu = scanner.next();
                    System.out.println("manzilini kiriting");
                    String address = scanner.next();
                    System.out.println("telefon raqamini kiriting");
                    int phoneNumber = scanner.nextInt();
                    edu.add(new Edu(nameEdu, address, phoneNumber));
                    System.out.println("successfully saved education");
                    break;
                case 2:
                    getEducationList(edu);
                    System.out.println("tanlang");
                    int chooseEdu = scanner.nextInt();
                    int tr = 0;
                    for (Edu edu1 : edu) {
                        tr++;
                        System.out.println(tr + "." + edu1.getEduName());
                        if (chooseEdu == tr) {
                            System.out.println("yangi education nomini kiriting");
                            String newEduName = scanner.next();
                            edu1.setEduName(newEduName);
                            System.out.println("successfully edited education ");
                        }
                    }
                    break;
                case 3:
                    getEducationList(edu);
                    System.out.println("tanla");
                    int chooseEdu1 = scanner.nextInt();
                    int tr1 = 0;
                    for (Edu edu1 : edu) {
                        tr1++;
                        if (chooseEdu1 == tr1) {
                            edu.remove(edu1);
                            System.out.println("o'chirildi");
                        }

                    }
                    break;
                case 4:
                    getEducationList(edu);
                    break;
                case 5:
                    getEducationList(edu);
                    System.out.println("eduni tanlang");
                    int chooseEdu2 = scanner.nextInt();
                    int tr2 = 0;
                    for (Edu edu1 : edu) {
                        tr2++;
                        if (chooseEdu2 == tr2) {
                            System.out.println("guruh nomini kiriting");
                            String name1 = scanner.next();
                            group.add(new Group(name1));
                            edu1.getGroups().add(new Group(name1));
                            System.out.println("saqlandi");
                            break;
                        }
                    }
                case 6:
                    getEducationList(edu);
                    System.out.println("education nomini tanlang");
                    int choooseEdu = scanner.nextInt();
                    int tr3 = 0;
                    for (Edu edu1 : edu) {
                        tr3++;
                        if (choooseEdu == tr3) {
                            for (Group group1 : edu1.getGroups()) {
                                System.out.println(group1.getGruopName());
                            }

                        } else {
                            System.out.println("bunday malumot mavjud emas");
                        }
                    }
                    break;
                case 7:
                    getGroupList(group);
                    break;
                case 8:
                    getEducationList(edu);
                    System.out.println("tanla");
                    int chooseEd1 = scanner.nextInt();
                    int tr4 = 0;
                    for (Edu edu1 : edu) {
                        tr4++;
                        if (chooseEd1 == tr4) {
                            getGroupList(edu1.getGroups());
                            System.out.println("guruhni tanlang");
                            int choose = scanner.nextInt();
                            int tr5 = 0;
                            for (Group groups : edu1.getGroups()) {
                                tr5++;
                                if (choose == tr5) {
                                    group.remove(groups);
                                    edu1.getGroups().remove(groups);
                                    System.out.println("o'chirildi");
                                    break;
                                }
                            }
                        }
                    }
                case 9:
                    getEducationList(edu);
                    System.out.println("tanla");
                    int chooseEd2 = scanner.nextInt();
                    int tr5 = 0;
                    for (Edu edu1 : edu) {
                        tr5++;
                        if (chooseEd2 == tr5) {
                            getGroupList(edu1.getGroups());
                            System.out.println("guruhni tanlang");
                            int choose = scanner.nextInt();
                            int tr6 = 0;
                            for (Group groups : edu1.getGroups()) {
                                tr6++;
                                if (choose == tr6) {
                                    for (Group group1 : group) {
                                        System.out.println("yangi nom kiriting");
                                        String newGroupName = scanner.next();
                                        group1.setGruopName(newGroupName);
                                        groups.setGruopName(newGroupName);
                                        System.out.println("tahrirlandi");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                case 10:
                    getEducationList(edu);
                    System.out.println("eduni tanla");
                    int chooseEd3 = scanner.nextInt();
                    int tr6 = 0;
                    for (Edu edu1 : edu) {
                        tr6++;
                        if (chooseEd3 == tr6) {
                            getGroupList(edu1.getGroups());
                            System.out.println("guruhni tanlang");
                            int choose = scanner.nextInt();
                            int tr7 = 0;
                            for (Group groups : edu1.getGroups()) {
                                tr7++;
                                if (choose == tr7) {
                                    System.out.println("studentni ismini kiriting");
                                    String name = scanner.next();
                                    System.out.println("studentni familiyasini kiriting");
                                    String surname = scanner.next();
                                    System.out.println("studentni yoshini kiriting");
                                    byte age = scanner.nextByte();
                                    System.out.println("password");
                                    String code = scanner.next();
                                    System.out.println("telefon raqamni kiriting");
                                    int phoneNumber1 = scanner.nextInt();
                                    edu1.getStudents().add(new Student(name, surname, age, code, phoneNumber1));
                                    groups.getStudents().add(new Student(name, surname, age, code, phoneNumber1));
                                    System.out.println("saqlandi");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 11:
                    getEducationList(edu);
                    System.out.println("tanla");
                    int chooseEd5 = scanner.nextInt();
                    int tr7 = 0;
                    for (Edu edu1 : edu) {
                        tr7++;
                        if (chooseEd5 == tr7) {
                            getGroupList(edu1.getGroups());
                            System.out.println("guruhni tanlang");
                            int choose = scanner.nextInt();
                            int tr8 = 0;
                            for (Group groups : edu1.getGroups()) {
                                tr8++;
                                if (choose == tr8) {
                                    for (Student student : groups.getStudents()) {
                                        System.out.println(tr8+" "+student.getName());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 12:
                    getEducationList(edu);
                    System.out.println(" edu tanla");
                    int chooseEd4 = scanner.nextInt();
                    int tr0 = 0;
                    for (Edu edu1 : edu) {
                        tr0++;
                        if (chooseEd4 == tr0) {
                            getGroupList(edu1.getGroups());
                            System.out.println("guruhni tanlang");
                            int choose = scanner.nextInt();
                            int aylanGruop = 0;
                            for (Group groups : edu1.getGroups()) {
                                aylanGruop++;
                                if (choose == aylanGruop) {
                                    getStudent(groups.getStudents());
                                    System.out.println("studentni tanlang");
                                    int chooseStudent = scanner.nextInt();
                                    int tr52 = 0;
                                    for (Student student : groups.getStudents()) {
                                        tr52++;
                                        if (chooseStudent == tr52) {
                                            String deleteStudent=student.getName()+" "+student.getSurname();
                                            edu1.getStudents().remove(students);
                                            groups.getStudents().remove(student);
                                            System.out.println("o'chirildi "+deleteStudent);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }

    }
    public static void getEducationList(Set<Edu> edu) {
        int tr = 0;
        for (Edu edu1 : edu) {
            tr++;
            System.out.println(tr + "." + edu1.getEduName());

            

        }

    }

    public static void getGroupList(Set<Group> groups) {
        int tr = 0;
        for (Group group : groups) {
            tr++;
            System.out.println(tr + "." + group.getGruopName());

        }
    }

    public static void getStudent(Set<Student> students) {
        int tr = 0;
        for (Student student : students) {
            tr++;
            System.out.println(tr + "." + student.getName() + " " + student.getSurname());
        }
    }

}
