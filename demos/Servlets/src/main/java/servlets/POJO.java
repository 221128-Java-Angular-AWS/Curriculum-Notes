package servlets;

import java.util.Objects;

/*
This is just a simple POJO for the object mapper to be able to de-serialize objects from JSON strings
 */
public class POJO {
    private String firstName;
    private String lastName;
    private Integer age;

    public POJO() {
    }

    public POJO(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POJO pojo = (POJO) o;
        return Objects.equals(firstName, pojo.firstName) && Objects.equals(lastName, pojo.lastName) && Objects.equals(age, pojo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "POJO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
