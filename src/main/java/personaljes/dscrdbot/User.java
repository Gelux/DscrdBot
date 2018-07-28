package personaljes.dscrdbot;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private Date regDate;
    private String userMail;

    public User(String name, Date regDate, String userMail) {
        this.name = name;
        this.regDate = new Date();
        this.userMail = userMail;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
