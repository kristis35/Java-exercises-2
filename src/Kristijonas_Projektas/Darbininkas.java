
package Kristijonas_Projektas;

import java.util.Comparator;

/**
 *
 * @author Kristijonas_Projektas
 */
public class Darbininkas implements Comparable<Darbininkas> {

    private String name;
    private String surname;
    private String age;
    private String university;
    private String speciality;

    public Darbininkas() {

    }

    public Darbininkas(String Name, String Surname, String Age, String University, String Speciality) {
        this.name = Name;
        this.surname = Surname;
        this.age = Age;
        this.university = University;
        this.speciality = Speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String Group) {
        this.age = Group;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String University) {
        this.university = University;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String Speciality) {
        this.speciality = Speciality;
    }

    @Override
    public String toString() {
        return "Name: " + name + " surname: " + surname
                + " age: " + age + " university: " + university
                + " specialize in: " + speciality;
    }

    @Override
    public int compareTo(Darbininkas o) {
        if (o == null) {
            return 0;
        }
        if (name.compareTo(o.name) != 0) {
            return name.compareTo(o.name);
        }
        if (surname.compareTo(o.surname) != 0) {
            return surname.compareTo(o.surname);
        }
        if (age.compareTo(o.age) != 0) {
            return age.compareTo(o.age);
        }
        if (university.compareTo(o.university) != 0) {
            return university.compareTo(o.university);
        }
        return speciality.compareTo(o.speciality);
    }
}
