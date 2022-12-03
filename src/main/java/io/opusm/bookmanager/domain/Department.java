package io.opusm.bookmanager.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Department {
    private long id;
    private String name;

    @Builder
    public Department(String name) {
        this.name = name;
    }
}
