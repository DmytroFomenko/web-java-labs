package fdv.fomenkolr6.model;



public class LoginData {
    private int id;
    private String userlogin;
    private String userpassword;


    public LoginData() {
    }

    public LoginData(int id, String userlogin, String userpassword) {
        this.id = id;
        this.userlogin = userlogin;
        this.userpassword = userpassword;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {this.userlogin = userlogin;}


    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

}
