package com.quarkusredissontester.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Itinerary {
    private final String departureCity;
    private final String arrivalCity;
    private final LocalDateTime date;
    private final String cabin; //can be eco, ecoPlus, premium. Enum later

    private final String payload;

    //Class and more to come


    public String getHash() {
        return departureCity + "|" + arrivalCity + "|" + date.toString() + "|" + cabin;
    }


    public static String getHash(String departureCity, String arrivalCity, LocalDateTime date, String cabin) {
        return departureCity + "|" + arrivalCity + "|" + date.toString() + "|" + cabin;
    }
}
