package com.quixorder.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Account {
    private final UUID id;

    @NotBlank
    private final String type;
    private final String username;
    private final String password;

    public Account(@JsonProperty("id") UUID id,
                   @JsonProperty("type") String type,
                   @JsonProperty("username") String username,
                   @JsonProperty("password") String password) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
