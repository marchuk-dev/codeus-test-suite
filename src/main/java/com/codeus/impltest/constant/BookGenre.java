package com.codeus.impltest.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum BookGenre {
    FANTASY("Fantasy"),
    SCIENCE_FICTION("Science Fiction"),
    ROMANCE("Romance"),
    HISTORY("History"),
    CHILDREN("Children"),
    RARE_BOOKS("Rare Books"),
    ARCHIVAL("Archival");

    String value;

    @JsonCreator
    public static BookGenre fromValue(String input) {
        return Arrays.stream(BookGenre.values())
                .filter(genre -> genre.value.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }

    public static List<BookGenre> getFictionGenres() {
        return List.of(
                FANTASY, SCIENCE_FICTION, ROMANCE
        );
    }
}