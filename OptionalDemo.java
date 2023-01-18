import java.util.*;

public class OptionalDemo
{


    public static void main(String args[])
    {
        student st = new student(null,34);
    java.util.Optional optionalName = java.util.Optional.ofNullable( st.getName() );
        optionalName.orElse( "Vivek" );
    }
}

class student {

    public String name;
    public int age;

    public  student(String name, int age)
    {
        this.name = name;
        this.age = age;

    }
    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

}
