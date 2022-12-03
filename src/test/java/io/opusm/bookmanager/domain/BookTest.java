package io.opusm.bookmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * [행동 정의]
 * 책은 정보를 갖는다.
 * 책은 정보를 보여준다. (can_get_book_info)
 * 책은 대출된다. (can_loan_book)
 * 책은 예약된다. (can_reserve_book)
 */
class BookTest {

    private Book book;
    private User user;
    private Department department;

    @BeforeEach
    void init() {
        book = Book.builder()
                .mgmtNum("01-001")
                .name("객체지향의 사실과 오해")
                .purchaseDate(LocalDate.now())
                .publisher("위키북스")
                .author("조영호")
                .price(20000L)
                .build();

        department = Department.builder()
                .name("경영지원부")
                .build();

        user = User.builder()
                .name("신선아")
                .email("xeona@opusm.io")
                .department(department)
                .build();
    }

    @Test
    @DisplayName("책은 정보를 보여줌")
    void can_get_book_info() throws Exception {
        // given
        final String expectedBookName = "객체지향의 사실과 오해";
        final String expectedMgmtNum = "01-001";
        final LocalDate expectedBookPurchaseDate = LocalDate.now();

        // when
        final String mgmtNum = book.getMgmtNum();
        final String bookName = book.getName();
        final LocalDate purchaseDate = book.getPurchaseDate();

        // then
        System.out.printf("expected: %s, actual: %s%n", expectedMgmtNum, mgmtNum);
        assertEquals(expectedMgmtNum, mgmtNum);
        System.out.printf("expected: %s, actual: %s%n", expectedBookName, bookName);
        assertEquals(expectedBookName, bookName);
        System.out.printf("expected: %s, actual: %s%n", expectedBookPurchaseDate, purchaseDate);
        assertEquals(expectedBookPurchaseDate, purchaseDate);
    }

    @Test
    @DisplayName("책은 대출됨")
    void can_loan_book() throws Exception {
        // given

        // when
        book.loanBook(user);
        final String loaner = book.getLoaner();

        // then
        System.out.printf("expected: %s, actual: %s%n", user.getName(), loaner);
        assertEquals(user.getName(), loaner);
    }

    @Test
    @DisplayName("책은 예약됨")
    void can_reserve_book() throws Exception {
        // given
        final Department department2 = Department.builder()
                .name("플랫폼개발본부")
                .build();

        final User user2 = User.builder()
                .name("김한결")
                .email("kimh4nkyul@opusm.io")
                .department(department2)
                .build();

        final Reservation reservation = Reservation.builder()
                .book(book)
                .user(user2)
                .reserveDate(LocalDate.now())
                .build();

        // when
        book.reserve(reservation);

        // then
        System.out.printf("expected: %s, actual: %s%n", reservation.getUser().getName(), book.getReservedUser());
        assertEquals(reservation.getUser().getName(), book.getReservedUser());
    }
}