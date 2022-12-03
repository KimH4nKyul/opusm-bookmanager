package io.opusm.bookmanager.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private long id;
    private String name;
    private String email;
    private Department department;

    @Builder
    public User(String name, String email, Department department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }
}
