package com.codeus.impltest.ut.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.codeus.impltest.constant.BookGenre;
import com.codeus.impltest.constant.InquiryType;
import com.codeus.impltest.constant.LibraryAssistanceQueue;

@DisplayName("Library Assistance Match Queue Test")
class LibraryAssistanceQueueTest {
    @ParameterizedTest
    @MethodSource("argumentsStream")
    void matchQueue(List<BookGenre> bookGenres, InquiryType inquiryType, LibraryAssistanceQueue libraryAssistanceQueue) {
        assertEquals(libraryAssistanceQueue, LibraryAssistanceQueue.matchQueue(bookGenres, inquiryType));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
          Arguments.of(List.of(BookGenre.FANTASY), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
          Arguments.of(List.of(BookGenre.SCIENCE_FICTION), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE),
          Arguments.of(List.of(BookGenre.ROMANCE), InquiryType.GENERAL, LibraryAssistanceQueue.FICTION_ASSISTANCE)
        );
    }
}
