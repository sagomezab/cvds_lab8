package edu.eci.cvds.servlet.backingBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserBean {
    private String userName;

    public UserBean(){

    }

    public void setUserName(String newName){
        this.userName = newName;
    }

    public String getUserName() {
        return userName;
    }

}
