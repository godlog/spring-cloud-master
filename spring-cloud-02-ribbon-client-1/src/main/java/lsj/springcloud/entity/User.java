package lsj.springcloud.entity;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 13:17
 * @version:1.0.0
 */
public class User {
    private String id;
    private String name;
    private int age;


    public User(){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public User(String id, String name, int age) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
