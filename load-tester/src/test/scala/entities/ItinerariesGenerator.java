package entities;


import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ItinerariesGenerator {
    private final Random random = new Random();
    private final Gson gson = new Gson();

    private final static List<String> CITIES = Stream.of("Barcelone", "Paris", "Bern", "Zurich", "Washington", "New-York",
            "Hanoi", "HMC", "Madrid", "Rome", "Dallas", "Chicago", "Denver", "Buenos Ares", "Mexico", "Shangai")
            .collect(Collectors.toList());
    private final static List<String> CABINS = Stream.of("eco", "ecoplus", "premium")
            .collect(Collectors.toList());

    private final Stack<String> hashStack = new Stack<>();


    public String generateItinerariesAsJson(int number) {
        List<Itinerary> itineraries = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            itineraries.add(new Itinerary(generateRandomCity(), generateRandomCity(),
                    generateRandomDateTime().toString(),
//                    generateRandomCabin(), DEFAULT_PAYLOAD)));
                    generateRandomCabin(), "payload"));
        }

        hashStack.push(gson.toJson(itineraries.stream().map(itinerary -> itinerary.getHash())
                .collect(Collectors.toList())));

        return gson.toJson(itineraries);
    }

    public List<Itinerary> generateItineraries(int number) {
        List<Itinerary> entities = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            entities.add(new Itinerary(generateRandomCity(), generateRandomCity(),
                    generateRandomDateTime().toString(),
//                    generateRandomCabin(), DEFAULT_PAYLOAD)));
                    generateRandomCabin(), "payload"));
        }

        return entities;
    }

    public Itinerary generateItinerary() {
        return new Itinerary(generateRandomCity(), generateRandomCity(),
                generateRandomDateTime().toString(),
//                    generateRandomCabin(), DEFAULT_PAYLOAD)));
                generateRandomCabin(), "payload");
    }

    public String generateItineraryAsJson() {
        Itinerary itinerary = new Itinerary(generateRandomCity(), generateRandomCity(),
                generateRandomDateTime().toString(),
//                    generateRandomCabin(), DEFAULT_PAYLOAD)));
                generateRandomCabin(), "payload");
//        hashStack.push(gson.toJson(itinerary.getHash()));
        hashStack.push(itinerary.getHash());
        return gson.toJson(itinerary);
    }

    public String getHashOfLastGeneratedItineraries() {
        return hashStack.pop();
    }

    private LocalDateTime generateRandomDateTime() {
        int maxSeconds = 1615248005;
        return LocalDateTime.ofEpochSecond(random.nextInt(maxSeconds), 0, ZoneOffset.UTC);
    }


    private String generateRandomCity() {
        return CITIES.get(random.nextInt(CITIES.size()));
    }


    private String generateRandomCabin() {
        return CABINS.get(random.nextInt(CABINS.size()));
    }


    private final static String DEFAULT_PAYLOAD = "{\n" +
            "  \"pageable\": {\n" +
            "    \"sort\": {\n" +
            "      \"sorted\": true,\n" +
            "      \"unsorted\": false,\n" +
            "      \"empty\": false\n" +
            "    },\n" +
            "    \"pageSize\": 50,\n" +
            "    \"pageNumber\": 0,\n" +
            "    \"offset\": 0,\n" +
            "    \"unpaged\": false,\n" +
            "    \"paged\": true\n" +
            "  },\n" +
            "  \"totalElements\": 10,\n" +
            "  \"totalPages\": 1,\n" +
            "  \"last\": true,\n" +
            "  \"first\": true,\n" +
            "  \"sort\": {\n" +
            "    \"sorted\": true,\n" +
            "    \"unsorted\": false,\n" +
            "    \"empty\": false\n" +
            "  },\n" +
            "  \"number\": 0,\n" +
            "  \"size\": 50,\n" +
            "  \"numberOfElements\": 10,\n" +
            "  \"empty\": false,\n" +
            "  \"content\": [\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"RECOMMENDED\",\n" +
            "          \"EARLIEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 105,\n" +
            "        \"flightCode\": \"LA4513\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T07:25:00\",\n" +
            "          \"departureTime\": \"7:25\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T09:10:00\",\n" +
            "          \"arrivalTime\": \"9:10\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"10db089417704236e3202e4825b5352bd012a9d0a8b6347ac3f56d0f5fc4a10d\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 251.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 251,34\",\n" +
            "              \"display\": \"R$ 251,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 251.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 251,34\",\n" +
            "              \"display\": \"R$ 251,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"1d8667001f899dbc8923d8eb33610460d2a7cacd548ad94e19e00e7d677a8e99\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 322.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 322,34\",\n" +
            "              \"display\": \"R$ 322,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 322.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 322,34\",\n" +
            "              \"display\": \"R$ 322,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"6894b636ba6132b16ec54d84d09a85ad40da58e6c261be80c0d08134c93b1bef\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 393.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 393,34\",\n" +
            "              \"display\": \"R$ 393,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 393.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 393,34\",\n" +
            "              \"display\": \"R$ 393,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"c0fc93d016ed082eb5948f3558a7663e5678b9ed7e9a6e32e39decc6efe9c17d\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 351.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 351,34\",\n" +
            "              \"display\": \"R$ 351,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 351.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 351,34\",\n" +
            "              \"display\": \"R$ 351,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 251.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 251,34\",\n" +
            "          \"display\": \"R$ 251,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 105,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"321\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4513,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": \"1\"\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T07:25:00\",\n" +
            "          \"arrival\": \"2021-05-17T09:10:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"FASTEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 100,\n" +
            "        \"flightCode\": \"LA4679\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T10:00:00\",\n" +
            "          \"departureTime\": \"10:00\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T11:40:00\",\n" +
            "          \"arrivalTime\": \"11:40\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"a09a6882feeea6f063fde2fdbd27c84dfee8107b5a68d161793524f172ae9eaf\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 251.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 251,34\",\n" +
            "              \"display\": \"R$ 251,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 251.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 251,34\",\n" +
            "              \"display\": \"R$ 251,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"f0440f1399ccc3f9d56642b0943bb83cc418fb063ab526b6573fa9873c5fdfdb\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 322.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 322,34\",\n" +
            "              \"display\": \"R$ 322,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 322.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 322,34\",\n" +
            "              \"display\": \"R$ 322,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"2ac003928d85545171460cacf8c8c8c3647613cf88f4a0bd07b0bdbaf713706d\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 393.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 393,34\",\n" +
            "              \"display\": \"R$ 393,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 393.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 393,34\",\n" +
            "              \"display\": \"R$ 393,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"d8a2b1b9b971f9bcfae0456702f9b20c6b386de62114f6d3a947893827bdf3d2\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"OJKX0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 351.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 351,34\",\n" +
            "              \"display\": \"R$ 351,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 351.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 351,34\",\n" +
            "              \"display\": \"R$ 351,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 251.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 251,34\",\n" +
            "          \"display\": \"R$ 251,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 100,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"321\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4679,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": null\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T10:00:00\",\n" +
            "          \"arrival\": \"2021-05-17T11:40:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"FASTEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 100,\n" +
            "        \"flightCode\": \"LA4671\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T13:00:00\",\n" +
            "          \"departureTime\": \"13:00\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T14:40:00\",\n" +
            "          \"arrivalTime\": \"14:40\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"74603c35a40444c7072bee9c12e27dfa5566b0d95d4b71e464fa16a01d17ea92\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"MJ0X0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1240.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.240,34\",\n" +
            "              \"display\": \"R$ 1.240,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1240.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.240,34\",\n" +
            "              \"display\": \"R$ 1.240,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"f8626870afec28ef1dac0599be038600785ac4e30e02a5797d4b811d8d6ffd09\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"MJ0X0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1349.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.349,34\",\n" +
            "              \"display\": \"R$ 1.349,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1349.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.349,34\",\n" +
            "              \"display\": \"R$ 1.349,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"5e0c1b723a0271867dd0f1e30142774f45408094a345456460e93ea859d9ae58\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"MJ0X0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1458.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.458,34\",\n" +
            "              \"display\": \"R$ 1.458,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1458.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.458,34\",\n" +
            "              \"display\": \"R$ 1.458,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"d6f5c5a6fb1e41579054f33d92ac45c2e0ba0ba0586662ce56398215e1b7a527\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"MJ0X0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1340.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.340,34\",\n" +
            "              \"display\": \"R$ 1.340,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 1340.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 1.340,34\",\n" +
            "              \"display\": \"R$ 1.340,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 1240.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 1.240,34\",\n" +
            "          \"display\": \"R$ 1.240,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 100,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"320\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4671,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": \"1\"\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T13:00:00\",\n" +
            "          \"arrival\": \"2021-05-17T14:40:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"CHEAPEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 105,\n" +
            "        \"flightCode\": \"LA4673\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T17:00:00\",\n" +
            "          \"departureTime\": \"17:00\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T18:45:00\",\n" +
            "          \"arrivalTime\": \"18:45\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"7ced8add66d1d50176acc6e3bd81623ac750c967f561decee7dfd6d702943d94\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"3ef14a9d101f4f2f98be0ab9b6a58f25ce20e6f85d6b33b4d936b57e77981cbf\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"a1c61c2fee8d2c0116f8dd7c076a8fec905a85c5444d7b9c7ad7e7a1acac0410\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GJSX0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"28191c7b56a58bfd35a0975bb0eab0d4f01f5bfb2e92589a251d71149fc77d41\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 136.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 136,34\",\n" +
            "          \"display\": \"R$ 136,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 105,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"321\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4673,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": null\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T17:00:00\",\n" +
            "          \"arrival\": \"2021-05-17T18:45:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"CHEAPEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 105,\n" +
            "        \"flightCode\": \"LA4675\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T21:05:00\",\n" +
            "          \"departureTime\": \"21:05\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T22:50:00\",\n" +
            "          \"arrivalTime\": \"22:50\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"f96048e7f2cc54f88f9517f9aa13b571727565a2dd838093e80bd26490aa241d\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"e39ace3c8529ff769a4f06f089e71c26b82cad3b5826165edea676b9543cdf42\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"a03e5ab9ea9b6af6a483c4d13345b56304cbf8bea52312759079933aeab45462\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GJSX0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"ed8828b1b405c4303b3d2a8733fba8aee8b284e998e08d6f31a072829f6ebf03\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 136.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 136,34\",\n" +
            "          \"display\": \"R$ 136,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 105,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"320\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4675,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": \"1\"\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T21:05:00\",\n" +
            "          \"arrival\": \"2021-05-17T22:50:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [\n" +
            "          \"CHEAPEST\"\n" +
            "        ],\n" +
            "        \"stopOvers\": 0,\n" +
            "        \"duration\": 105,\n" +
            "        \"flightCode\": \"LA4677\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T21:55:00\",\n" +
            "          \"departureTime\": \"21:55\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T23:40:00\",\n" +
            "          \"arrivalTime\": \"23:40\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"f2436c6a6b33f9b1bb146f5c127a9ca18b12e9f9d2b45fa4468ff85ab11cf26f\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 136.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 136,34\",\n" +
            "              \"display\": \"R$ 136,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": false,\n" +
            "                \"weightLimit\": {},\n" +
            "                \"quantity\": \"0\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SE\",\n" +
            "            \"offerId\": \"2c1f2162058f08a8f52dcaae5738ed899405c2557c24e08565b85cd496d3afa3\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N8\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 205.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 205,34\",\n" +
            "              \"display\": \"R$ 205,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"SF\",\n" +
            "            \"offerId\": \"946a033f303608bec538bb920fd4e312e968350e851beaf30448528a7bd8f942\",\n" +
            "            \"brandText\": \"TOP\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_top_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GJSX0N9\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 300.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 300,34\",\n" +
            "              \"display\": \"R$ 300,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"2\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 22,\n" +
            "                  \"KILOGRAMS\": 10\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"RA\",\n" +
            "            \"offerId\": \"f98603d8a8445b36aaab6f70813bcaaf71967eb68ca07793de80401c03a808bd\",\n" +
            "            \"brandText\": \"PLUS\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_premiumeconomy_plus_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"PremiumEconomy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"GDHX0N2\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 236.34,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 236,34\",\n" +
            "              \"display\": \"R$ 236,34\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": true,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"personalItem\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"seatSelection\": {\n" +
            "                \"show\": true\n" +
            "              },\n" +
            "              \"checkedBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 50,\n" +
            "                  \"KILOGRAMS\": 23\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              },\n" +
            "              \"carryOnBaggage\": {\n" +
            "                \"show\": true,\n" +
            "                \"weightLimit\": {\n" +
            "                  \"POUNDS\": 35,\n" +
            "                  \"KILOGRAMS\": 16\n" +
            "                },\n" +
            "                \"quantity\": \"1\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"lowestPrice\": {\n" +
            "          \"currency\": \"BRL\",\n" +
            "          \"amount\": 136.34,\n" +
            "          \"displayCurrency\": \"R$\",\n" +
            "          \"displayAmount\": \" 136,34\",\n" +
            "          \"display\": \"R$ 136,34\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"itinerary\": [\n" +
            "        {\n" +
            "          \"duration\": 105,\n" +
            "          \"flightsMiles\": null,\n" +
            "          \"cabinClass\": null,\n" +
            "          \"equipment\": \"321\",\n" +
            "          \"aircraftLeaseText\": \"LATAM AIRLINES BRASIL\",\n" +
            "          \"flight\": {\n" +
            "            \"flightNumber\": 4677,\n" +
            "            \"airlineCode\": \"LA\",\n" +
            "            \"operatingAirlineCode\": \"LA\",\n" +
            "            \"stopAirports\": [],\n" +
            "            \"departureTerminal\": \"2\",\n" +
            "            \"arrivalTerminal\": null\n" +
            "          },\n" +
            "          \"origin\": \"GRU\",\n" +
            "          \"destination\": \"POA\",\n" +
            "          \"departure\": \"2021-05-17T21:55:00\",\n" +
            "          \"arrival\": \"2021-05-17T23:40:00\",\n" +
            "          \"bookingClass\": null,\n" +
            "          \"fareBasis\": null,\n" +
            "          \"type\": null,\n" +
            "          \"amenityLink\": null\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"summary\": {\n" +
            "        \"tags\": [],\n" +
            "        \"stopOvers\": 1,\n" +
            "        \"duration\": 485,\n" +
            "        \"flightCode\": \"LA3198\",\n" +
            "        \"origin\": {\n" +
            "          \"departure\": \"2021-05-17T08:55:00\",\n" +
            "          \"departureTime\": \"8:55\",\n" +
            "          \"iataCode\": \"GRU\",\n" +
            "          \"city\": \"Sao Paulo\"\n" +
            "        },\n" +
            "        \"destination\": {\n" +
            "          \"arrival\": \"2021-05-17T17:00:00\",\n" +
            "          \"arrivalTime\": \"17:00\",\n" +
            "          \"iataCode\": \"POA\",\n" +
            "          \"city\": \"Porto Alegre\"\n" +
            "        },\n" +
            "        \"brands\": [\n" +
            "          {\n" +
            "            \"id\": \"SL\",\n" +
            "            \"offerId\": \"dbc653acd9397fe9b14e52ff3d751f4ceb4a007c0c11d6697d71f9e850d28dd0\",\n" +
            "            \"brandText\": \"LIGHT\",\n" +
            "            \"brandDescription\": \"xp_sales_web_brand_economy_light_description\",\n" +
            "            \"promotionalText\": {\n" +
            "              \"show\": false,\n" +
            "              \"label\": \"\"\n" +
            "            },\n" +
            "            \"cabin\": {\n" +
            "              \"id\": \"Y\",\n" +
            "              \"label\": \"Economy\"\n" +
            "            },\n" +
            "            \"rules\": {},\n" +
            "            \"farebasis\": \"SJ7X0G1\",\n" +
            "            \"price\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 770.44,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 770,44\",\n" +
            "              \"display\": \"R$ 770,44\"\n" +
            "            },\n" +
            "            \"priceAfterSelection\": {\n" +
            "              \"currency\": \"BRL\",\n" +
            "              \"amount\": 770.44,\n" +
            "              \"displayCurrency\": \"R$\",\n" +
            "              \"displayAmount\": \" 770,44\",\n" +
            "              \"display\": \"R$ 770,44\"\n" +
            "            },\n" +
            "            \"attributes\": {\n" +
            "              \"comfortableSeat\": {\n" +
            "                \"show\": false\n" +
            "              },\n" +
            "              \"latamPlusSeat\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"food\": {\n" +
            "                \"show\": false,\n" +
            "                \"exclusive\": false\n" +
            "              },\n" +
            "              \"accrual\": {\n" +
            "                \"show\": true\n" +
            "              }\n";
}
