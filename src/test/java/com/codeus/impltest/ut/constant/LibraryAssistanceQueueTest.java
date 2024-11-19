package com.codeus.impltest.ut.constant;

import com.codeus.impltest.constant.BookGenre;
import com.codeus.impltest.constant.InquiryType;
import com.codeus.impltest.constant.LibraryAssistanceQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

@DisplayName("Library Assistance Match Queue Test")
class LibraryAssistanceQueueTest {

    @Nested
    class FictionAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "SCIENCE_FICTION", "ROMANCE"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertEquals(LibraryAssistanceQueue.FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "SCIENCE_FICTION", "ROMANCE"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreNoMatchAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertNotEquals(LibraryAssistanceQueue.FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = InquiryType.class, names = {"GENERAL"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreMatchAndInquiryTypeNoMatch(final InquiryType inquiryType) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(BookGenre.FANTASY), inquiryType);

            Assertions.assertNotEquals(LibraryAssistanceQueue.FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "SCIENCE_FICTION", "ROMANCE"}, mode = EnumSource.Mode.EXCLUDE)
            // TODO go trough all inquiry types
        void neitherBookGenreNorInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.PAYMENT_ISSUE);

            Assertions.assertNotEquals(LibraryAssistanceQueue.FICTION_ASSISTANCE, actual);
        }
    }

    @Nested
    class NonFictionAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"HISTORY"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertEquals(LibraryAssistanceQueue.NON_FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"HISTORY"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreNoMatchAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertNotEquals(LibraryAssistanceQueue.NON_FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = InquiryType.class, names = {"GENERAL"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreMatchAndInquiryTypeNoMatch(final InquiryType inquiryType) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(BookGenre.HISTORY), inquiryType);

            Assertions.assertNotEquals(LibraryAssistanceQueue.NON_FICTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"HISTORY"}, mode = EnumSource.Mode.EXCLUDE)
            // TODO go trough all inquiry types
        void neitherBookGenreNorInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.RARE_ITEM_REQUEST);

            Assertions.assertNotEquals(LibraryAssistanceQueue.NON_FICTION_ASSISTANCE, actual);
        }
    }

    @Nested
    class KidsSectionAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"CHILDREN"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertEquals(LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"CHILDREN"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreNoMatchAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertNotEquals(LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = InquiryType.class, names = {"GENERAL"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreMatchAndInquiryTypeNoMatch(final InquiryType inquiryType) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(BookGenre.CHILDREN), inquiryType);

            Assertions.assertNotEquals(LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"CHILDREN"}, mode = EnumSource.Mode.EXCLUDE)
            // TODO go trough all inquiry types
        void neitherBookGenreNorInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.PAYMENT_ISSUE);

            Assertions.assertNotEquals(LibraryAssistanceQueue.KIDS_SECTION_ASSISTANCE, actual);
        }
    }

    @Nested
    class RareBooksAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"RARE_BOOKS", "ARCHIVAL"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.RARE_ITEM_REQUEST);

            Assertions.assertEquals(LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"RARE_BOOKS", "ARCHIVAL"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreNoMatchAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.RARE_ITEM_REQUEST);

            Assertions.assertNotEquals(LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = InquiryType.class, names = {"RARE_ITEM_REQUEST", "GENERAL"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreMatchAndInquiryTypeNoMatch(final InquiryType inquiryType) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(BookGenre.RARE_BOOKS), inquiryType);

            Assertions.assertNotEquals(LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"RARE_BOOKS", "ARCHIVAL"}, mode = EnumSource.Mode.EXCLUDE)
            // TODO go trough all inquiry types
        void neitherBookGenreNorInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.PAYMENT_ISSUE);

            Assertions.assertNotEquals(LibraryAssistanceQueue.RARE_BOOKS_ASSISTANCE, actual);
        }
    }

    @Nested
    class PaymentAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "ROMANCE", "HISTORY"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.PAYMENT_ISSUE);

            Assertions.assertEquals(LibraryAssistanceQueue.PAYMENT_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "ROMANCE", "HISTORY"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreNoMatchAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.PAYMENT_ISSUE);

            Assertions.assertNotEquals(LibraryAssistanceQueue.PAYMENT_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = InquiryType.class, names = {"PAYMENT_ISSUE"}, mode = EnumSource.Mode.EXCLUDE)
        void bookGenreMatchAndInquiryTypeNoMatch(final InquiryType inquiryType) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(BookGenre.FANTASY), inquiryType);

            Assertions.assertNotEquals(LibraryAssistanceQueue.PAYMENT_ASSISTANCE, actual);
        }

        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"FANTASY", "ROMANCE", "HISTORY"}, mode = EnumSource.Mode.EXCLUDE)
            // TODO go trough all inquiry types
        void neitherBookGenreNorInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertNotEquals(LibraryAssistanceQueue.PAYMENT_ASSISTANCE, actual);
        }
    }

    @Nested
    class GeneralAssistance {


        @ParameterizedTest
        @EnumSource(value = BookGenre.class, names = {"SCIENCE_FICTION", "ARCHIVAL"})
        void bookGenreAndInquiryTypeMatch(final BookGenre bookGenre) {
            final var actual = LibraryAssistanceQueue.matchQueue(List.of(bookGenre), InquiryType.GENERAL);

            Assertions.assertEquals(LibraryAssistanceQueue.GENERAL_ASSISTANCE, actual);
        }
    }

    //  TODO cover default behavior
}
