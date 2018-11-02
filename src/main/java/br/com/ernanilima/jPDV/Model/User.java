package br.com.ernanilima.jPDV.Model;

/**
 *
 * @author Ernani Lima
 */
public class User {

    private int id;
    private String name;
    private String pwd;
    private int level;

    public User() {}

    public User(int id, String name, String pwd, int level) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.level = level;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
