package com.codeus.impltest.ut.constant;

import com.codeus.impltest.constant.BookGenre;
import com.codeus.impltest.constant.InquiryType;
import com.codeus.impltest.constant.LibraryAssistanceQueue;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeus.impltest.constant.BookGenre.ARCHIVAL;
import static com.codeus.impltest.constant.BookGenre.CHILDREN;
import static com.codeus.impltest.constant.BookGenre.FANTASY;
import static com.codeus.impltest.constant.BookGenre.HISTORY;
import static com.codeus.impltest.constant.BookGenre.RARE_BOOKS;
import static com.codeus.impltest.constant.BookGenre.ROMANCE;
import static com.codeus.impltest.constant.BookGenre.SCIENCE_FICTION;
import static com.codeus.impltest.constant.InquiryType.GENERAL;
import static com.codeus.impltest.constant.InquiryType.PAYMENT_ISSUE;
import static com.codeus.impltest.constant.InquiryType.RARE_ITEM_REQUEST;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.FICTION_ASSISTANCE;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.GENERAL_ASSISTANCE;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.NON_FICTION_ASSISTANCE;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.PAYMENT_ASSISTANCE;
import static com.codeus.impltest.constant.LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE;

@DisplayName("Library Assistance Match Queue Test")
public class LibraryAssistanceQueueTest {

    @ParameterizedTest(name = "Match queue expect [{2}] when bookGenre=[{0}] and inquiryType=[{1}]")
    @DisplayName("Test match queue")
    @MethodSource("fictionAssistanceBookGenres")
    public void matchQueue(
            BookGenre bookGenre,
            InquiryType inquiryType,
            LibraryAssistanceQueue expectedLibraryAssistanceQueue
    ) {
        // Act
        LibraryAssistanceQueue actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), inquiryType);

        // Assert
        Assertions.assertEquals(expectedLibraryAssistanceQueue, actual);
    }

    @Test
    public void matchQueue_EmptyGenreList() {
        // Assert
        List<BookGenre> emptyGenreList = List.of();

        // Act
        LibraryAssistanceQueue actual = LibraryAssistanceQueue.matchQueue(emptyGenreList, GENERAL);

        // Assert
        Assertions.assertEquals(GENERAL_ASSISTANCE, actual);
    }

    private static Stream<Arguments> fictionAssistanceBookGenres() {
        return Stream.of(
                Arguments.of(FANTASY, GENERAL, FICTION_ASSISTANCE),
                Arguments.of(SCIENCE_FICTION, GENERAL, FICTION_ASSISTANCE),
                Arguments.of(ROMANCE,  GENERAL, FICTION_ASSISTANCE),
                Arguments.of(HISTORY,  GENERAL, NON_FICTION_ASSISTANCE),
                Arguments.of(CHILDREN,  GENERAL, KIDS_SECTION_ASSISTANCE),
                Arguments.of(RARE_BOOKS,  RARE_ITEM_REQUEST, RARE_BOOKS_ASSISTANCE),
                Arguments.of(ARCHIVAL,  RARE_ITEM_REQUEST, RARE_BOOKS_ASSISTANCE),
                Arguments.of(RARE_BOOKS,  GENERAL, RARE_BOOKS_ASSISTANCE),
                Arguments.of(ARCHIVAL,  GENERAL, RARE_BOOKS_ASSISTANCE),
                Arguments.of(FANTASY,  PAYMENT_ISSUE, PAYMENT_ASSISTANCE),
                Arguments.of(ROMANCE,  PAYMENT_ISSUE, PAYMENT_ASSISTANCE),
                Arguments.of(HISTORY,  PAYMENT_ISSUE, PAYMENT_ASSISTANCE)
        );
    }
}
