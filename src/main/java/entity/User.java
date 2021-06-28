package entity;

public class User {
    private int id;
    private String name;
    private String password;
    private int math;
    private int chinese;
    private int english;

    public User( String name, String password, int math, int chinese, int english) {
        this.name = name;
        this.password = password;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public User(int id, String name, String password, int math, int chinese, int english) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
    }
}
