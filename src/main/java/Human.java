import java.util.Objects;

public class Human
{
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    public Human()
    {
        firstName = "";
        middleName = "";
        lastName = "";
        age = 0;
    }
    public Human(String firstName, String middleName, String lastName, int age)
    {
        if(firstName == null)
            throw new IllegalArgumentException("firstName is null");
        this.firstName = firstName;
        if(middleName == null)
            throw new IllegalArgumentException("middleName is null");
        this.middleName = middleName;
        if(lastName == null)
            throw new IllegalArgumentException("lastName is null");
        this.lastName = lastName;
        if(age<0)
        {
            throw new IllegalArgumentException("Wrong age");
        }
        this.age = age;
    }
    public Human(String firstName, String middleName, int age)
    {
        if(firstName == null)
            throw new IllegalArgumentException("firstName is null");
        this.firstName = firstName;
        if(middleName == null)
            throw new IllegalArgumentException("middleName is null");
        this.middleName = middleName;
        if(age<0)
        {
            throw new IllegalArgumentException("Wrong age");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName()
    {
        if(lastName == null)
            throw new IllegalArgumentException("His person doesn't have a father");
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(middleName, human.middleName) && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, age);
    }
}

