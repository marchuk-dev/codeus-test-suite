package com.codeus.impltest.ut.constant;

import com.codeus.impltest.constant.BookGenre;
import com.codeus.impltest.constant.InquiryType;
import com.codeus.impltest.constant.LibraryAssistanceQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Library Assistance Match Queue Test")
class LibraryAssistanceQueueTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideValidParameters")
    @DisplayName("Test valid results of matchQueue")
    public void testMatchQueue(List<BookGenre> genres, InquiryType inquiryType, LibraryAssistanceQueue expected) {
        var queue = LibraryAssistanceQueue.matchQueue(genres, inquiryType);
        assertEquals(expected, queue);
    }

    private static Stream<Arguments> provideValidParameters() {
        return Stream.of(
                Arguments.of(Named.named("[BookGenre.FANTASY], InquiryType.GENERAL -> FICTION_ASSISTANCE", List.of(BookGenre.FANTASY)), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.SCIENCE_FICTION], InquiryType.GENERAL -> FICTION_ASSISTANCE", List.of(BookGenre.SCIENCE_FICTION)), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.ROMANCE], InquiryType.GENERAL -> FICTION_ASSISTANCE", List.of(BookGenre.ROMANCE)), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),

                Arguments.of(Named.named("[BookGenre.HISTORY], InquiryType.GENERAL -> NON_FICTION_ASSISTANCE", List.of(BookGenre.HISTORY)), InquiryType.GENERAL, LibraryAssistanceQueue.NON_FICTION_ASSISTANCE),

                Arguments.of(Named.named("[BookGenre.CHILDREN], InquiryType.GENERAL -> KIDS_SECTION_ASSISTANCE", List.of(BookGenre.CHILDREN)), InquiryType.GENERAL, LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE),

                Arguments.of(Named.named("[BookGenre.RARE_BOOKS], InquiryType.GENERAL -> RARE_BOOKS_ASSISTANCE", List.of(BookGenre.RARE_BOOKS)), InquiryType.GENERAL, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.ARCHIVAL], InquiryType.GENERAL -> RARE_BOOKS_ASSISTANCE", List.of(BookGenre.ARCHIVAL)), InquiryType.GENERAL, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.ARCHIVAL], InquiryType.RARE_ITEM_REQUEST -> RARE_BOOKS_ASSISTANCE", List.of(BookGenre.ARCHIVAL)), InquiryType.RARE_ITEM_REQUEST, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.RARE_BOOKS], InquiryType.RARE_ITEM_REQUEST -> RARE_BOOKS_ASSISTANCE", List.of(BookGenre.RARE_BOOKS)), InquiryType.RARE_ITEM_REQUEST, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),

                Arguments.of(Named.named("[BookGenre.FANTASY], InquiryType.PAYMENT_ISSUE -> PAYMENT_ASSISTANCE", List.of(BookGenre.FANTASY)), InquiryType.PAYMENT_ISSUE, LibraryAssistanceQueue.PAYMENT_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.ROMANCE], InquiryType.PAYMENT_ISSUE -> PAYMENT_ASSISTANCE", List.of(BookGenre.ROMANCE)), InquiryType.PAYMENT_ISSUE, LibraryAssistanceQueue.PAYMENT_ASSISTANCE),
                Arguments.of(Named.named("[BookGenre.HISTORY], InquiryType.PAYMENT_ISSUE -> PAYMENT_ASSISTANCE", List.of(BookGenre.HISTORY)), InquiryType.PAYMENT_ISSUE, LibraryAssistanceQueue.PAYMENT_ASSISTANCE),

                Arguments.of(Named.named("[BookGenre.FANTASY], null -> GENERAL_ASSISTANCE", List.of(BookGenre.FANTASY)), null, LibraryAssistanceQueue.GENERAL_ASSISTANCE),
                Arguments.of(Named.named("[], null -> GENERAL_ASSISTANCE", List.of()), null, LibraryAssistanceQueue.GENERAL_ASSISTANCE),

                Arguments.of(Named.named("[HISTORY, CHILDREN, RARE_BOOKS, ARCHIVAL], null -> GENERAL_ASSISTANCE", List.of(BookGenre.HISTORY, BookGenre.CHILDREN, BookGenre.RARE_BOOKS, BookGenre.ARCHIVAL)), null, LibraryAssistanceQueue.GENERAL_ASSISTANCE)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidParameters")
    @DisplayName("Test invalid inputs of matchQueue")
    public void testThrowsNullPointer(List<BookGenre> genres, InquiryType inquiryType, Class<? extends Exception> expected) {
        assertThrows(expected, () -> LibraryAssistanceQueue.matchQueue(genres, inquiryType));
    }

    private static Stream<Arguments> provideInvalidParameters() {
        return Stream.of(
                Arguments.of(Named.named("null, null -> NullPointerException", null), null, NullPointerException.class),
                Arguments.of(Named.named("null, InquiryType.GENERAL -> NullPointerException", null), InquiryType.GENERAL, NullPointerException.class)
        );
    }

}