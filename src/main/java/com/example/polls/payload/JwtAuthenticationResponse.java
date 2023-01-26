package com.example.polls.payload;

import java.util.List;

public class JwtAuthenticationResponse {
    //private Long id;

  //  private String email;
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

  //  private String username;
   // private List<String> roles;

    /*
    public JwtAuthenticationResponse(String accessToken,Long id,String username,String email,List<String> roles) {
        this.accessToken = accessToken;
       // this.id=id;
      //  this.username = username;
       // this.email=email;
       // this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}

