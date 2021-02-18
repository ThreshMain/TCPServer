package chat;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

public class User {
    private String userName;


    private Password password;
    private String colorCode;

    public User(String userName, Password password) {
        this(userName,password,null);
    }

    public String getUserName() {
        return userName;
    }

    public User(String userName, Password password, String colorCode) {
        this.userName = userName;
        this.password = password;
        this.colorCode = colorCode;
    }

    public boolean logIn(String password){
        try {
            return this.password.verifyPassword(password);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String toString() {
        if(colorCode!=null){
            return colorCode+userName;
        }else{
            return userName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
