package mn.redisson.tester.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Itinerary {
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime date;
    private String cabin; //can be eco, ecoPlus, premium. Enum later

    private String payload;

    //Class and more to come


    public String getHash() {
        return departureCity + "|" + arrivalCity + "|" + date.toString() + "|" + cabin;
    }


    public static String getHash(String departureCity, String arrivalCity, LocalDateTime date, String cabin) {
        return departureCity + "|" + arrivalCity + "|" + date.toString() + "|" + cabin;
    }
}
