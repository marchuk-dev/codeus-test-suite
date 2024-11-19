package com.codeus.impltest.ut.constant;

import com.codeus.impltest.constant.BookGenre;
import com.codeus.impltest.constant.InquiryType;
import com.codeus.impltest.constant.LibraryAssistanceQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Library Assistance Match Queue Test")
class LibraryAssistanceQueueTest {

    static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(List.of(BookGenre.FANTASY, BookGenre.ROMANCE), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
                Arguments.of(List.of(BookGenre.HISTORY), InquiryType.GENERAL, LibraryAssistanceQueue.NON_FICTION_ASSISTANCE),
                Arguments.of(List.of(BookGenre.CHILDREN), InquiryType.GENERAL, LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE),
                Arguments.of(List.of(BookGenre.RARE_BOOKS), InquiryType.RARE_ITEM_REQUEST, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),
                Arguments.of(List.of(BookGenre.ARCHIVAL), InquiryType.GENERAL, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE),
                Arguments.of(List.of(BookGenre.HISTORY), InquiryType.PAYMENT_ISSUE, LibraryAssistanceQueue.PAYMENT_ASSISTANCE),
//                Arguments.of(List.of(BookGenre.SCIENCE_FICTION), InquiryType.GENERAL, LibraryAssistanceQueue.GENERAL_ASSISTANCE),
                Arguments.of(Collections.EMPTY_LIST, InquiryType.GENERAL, LibraryAssistanceQueue.GENERAL_ASSISTANCE),
                Arguments.of(List.of(BookGenre.FANTASY, BookGenre.HISTORY, BookGenre.RARE_BOOKS), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
                Arguments.of(List.of(BookGenre.FANTASY, BookGenre.RARE_BOOKS), InquiryType.RARE_ITEM_REQUEST, LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void testLibraryAssistanceQueueMatch(List<BookGenre> bookGenres, InquiryType inquiryType, LibraryAssistanceQueue expectedQueue) {
        LibraryAssistanceQueue queue = LibraryAssistanceQueue.matchQueue(bookGenres, inquiryType);
        assertEquals(expectedQueue, queue);
    }
}
