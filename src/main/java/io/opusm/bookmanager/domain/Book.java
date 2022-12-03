package io.opusm.bookmanager.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Book {
    private long id;
    private String mgmtNum;
    private String name;
    private LocalDate purchaseDate;
    private String publisher;
    private String author;
    private long price;
    private User user;
    private Reservation reservation;

    @Builder
    public Book(String mgmtNum, String name, LocalDate purchaseDate, String publisher, String author, long price) {
        this.mgmtNum = mgmtNum;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

    public String getReservedUser() {
        return reservation.getUser().getName();
    }

    public void reserve(Reservation reservation) {
        this.reservation = reservation;
    }
    public String getLoaner() {
        return user.getName();
    }

    public void loanBook(User user) {
        this.user = user;
    }
}
