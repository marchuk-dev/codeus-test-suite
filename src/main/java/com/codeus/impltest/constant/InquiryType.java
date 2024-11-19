package com.codeus.impltest.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum InquiryType {
    PAYMENT_ISSUE("Payment issue"),
    GENERAL("General"),
    RARE_ITEM_REQUEST("Rare item request");

    String value;

    @JsonCreator
    public static InquiryType fromValue(String input) {
        return Arrays.stream(InquiryType.values())
                .filter(type -> type.value.equalsIgnoreCase(input))
                .findFirst()
                .orElse(InquiryType.GENERAL);
    }
}