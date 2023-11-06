package Suite.Models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthCredentials {

    @JsonProperty("username")
    private String UserName;
    @JsonProperty("password")
    private String Password;

    public AuthCredentials(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
