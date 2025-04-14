public class Student {
    private String name;
    private int age;
    private int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getStudentName() {
        return this.name;
    }

    public int getStudentAge() {
        return this.age;
    }

    public int getStudentId() {
        return this.id;
    }
    
    public void setStudentName(String name) {
        this.name = name;
    }

    public void setStudentAge(int age) {
        this.age = age;
    }

    public void setStudentId(int id) {
        this.id = id;
    }
}
