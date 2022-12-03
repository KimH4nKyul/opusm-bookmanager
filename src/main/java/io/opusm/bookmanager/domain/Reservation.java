package io.opusm.bookmanager.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Reservation {

    private long id;
    private Book book;
    private User user;
    private LocalDate reserveDate;

    @Builder
    public Reservation(Book book, User user, LocalDate reserveDate) {
        this.book = book;
        this.user = user;
        this.reserveDate = reserveDate;
    }
}
