import java.util.Objects;

public class MyTestingClass { //creating new class for testing MyHashTable
private int id; //new variable id
private String name;//new variable name

public MyTestingClass(int it, String name) {
    this.id = id;
    this.name = name;
}

public int getId(){
    return id; //getter retrieves and returns id
}
public String getName(){
    return name; // getter retrieves and returns name
}

@Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MyTestingClass that = (MyTestingClass) o;
    return id == that.id && Objects.equals(name, that.name);
}
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}