package com.codeus.impltest.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum LibraryAssistanceQueue {

    FICTION_ASSISTANCE(
            "Fiction-Assistance",
            (bookGenres, inquiryType) -> bookGenres.stream()
                    .anyMatch(genre ->
                            genre == BookGenre.FANTASY ||
                                    genre == BookGenre.SCIENCE_FICTION ||
                                    genre == BookGenre.ROMANCE)
                    && inquiryType == InquiryType.GENERAL
    ),

    NON_FICTION_ASSISTANCE(
            "Non-Fiction-Assistance",
            (bookGenres, inquiryType) -> bookGenres.contains(BookGenre.HISTORY)
                    && inquiryType == InquiryType.GENERAL
    ),

    KIDS_SECTION_ASSISTANCE(
            "Kids-Section-Assistance",
            (bookGenres, inquiryType) -> bookGenres.contains(BookGenre.CHILDREN)
                    && inquiryType == InquiryType.GENERAL
    ),

    RARE_BOOKS_ASSISTANCE(
            "Rare-Books-Assistance",
            (bookGenres, inquiryType) -> bookGenres.stream()
                    .anyMatch(genre ->
                            genre == BookGenre.RARE_BOOKS ||
                                    genre == BookGenre.ARCHIVAL)
                    && (inquiryType == InquiryType.RARE_ITEM_REQUEST ||
                    inquiryType == InquiryType.GENERAL)
    ),

    PAYMENT_ASSISTANCE(
            "Payment-Assistance",
            (bookGenres, inquiryType) -> bookGenres.stream()
                    .anyMatch(genre ->
                            genre == BookGenre.FANTASY ||
                                    genre == BookGenre.ROMANCE ||
                                    genre == BookGenre.HISTORY)
                    && inquiryType == InquiryType.PAYMENT_ISSUE
    ),

    GENERAL_ASSISTANCE(
            "General-Assistance",
            (bookGenres, inquiryType) -> bookGenres.stream()
                    .anyMatch(genre ->
                            genre == BookGenre.SCIENCE_FICTION ||
                                    genre == BookGenre.ARCHIVAL)
                    && inquiryType == InquiryType.GENERAL
    );

    @JsonValue
    String value;
    BiPredicate<List<BookGenre>, InquiryType> rule;

    public static LibraryAssistanceQueue matchQueue(List<BookGenre> bookGenres, InquiryType inquiryType) {
        return Arrays.stream(values())
                .filter(queue -> queue.rule.test(bookGenres, inquiryType))
                .findFirst()
                .orElse(GENERAL_ASSISTANCE);
    }
}