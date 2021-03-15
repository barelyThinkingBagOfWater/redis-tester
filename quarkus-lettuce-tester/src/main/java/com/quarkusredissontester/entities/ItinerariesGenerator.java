package com.quarkusredissontester.entities;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ItinerariesGenerator {
    private final Random random = new Random();

    private final static List<String> CITIES = List.of("Barcelone", "Paris", "Bern", "Zurich", "Washington", "New-York",
            "Hanoi", "HMC", "Madrid", "Rome", "Dallas", "Chicago", "Denver", "Buenos Ares", "Mexico", "Shangai");
    private final static List<String> CABINS = List.of("eco", "ecoplus", "premium");


    public List<Itinerary> generateItinaries(long number) {
        List<Itinerary> entities = new ArrayList<>((int) number);

        for (int i = 0; i < number; i++) {
            entities.add(new Itinerary(generateRandomCity(), generateRandomCity(), generateRandomDateTime(),
                    generateRandomCabin(), "payload"));
        }

        return entities;
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


//    private final static String DEFAULT_PAYLOAD = """
//            {
//              "pageable": {
//                "sort": {
//                  "sorted": true,
//                  "unsorted": false,
//                  "empty": false
//                },
//                "pageSize": 50,
//                "pageNumber": 0,
//                "offset": 0,
//                "unpaged": false,
//                "paged": true
//              },
//              "totalElements": 10,
//              "totalPages": 1,
//              "last": true,
//              "first": true,
//              "sort": {
//                "sorted": true,
//                "unsorted": false,
//                "empty": false
//              },
//              "number": 0,
//              "size": 50,
//              "numberOfElements": 10,
//              "empty": false,
//              "content": [
//                {
//                  "summary": {
//                    "tags": [
//                      "RECOMMENDED",
//                      "EARLIEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 105,
//                    "flightCode": "LA4513",
//                    "origin": {
//                      "departure": "2021-05-17T07:25:00",
//                      "departureTime": "7:25",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T09:10:00",
//                      "arrivalTime": "9:10",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "10db089417704236e3202e4825b5352bd012a9d0a8b6347ac3f56d0f5fc4a10d",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 251.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 251,34",
//                          "display": "R$ 251,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 251.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 251,34",
//                          "display": "R$ 251,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "1d8667001f899dbc8923d8eb33610460d2a7cacd548ad94e19e00e7d677a8e99",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 322.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 322,34",
//                          "display": "R$ 322,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 322.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 322,34",
//                          "display": "R$ 322,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "6894b636ba6132b16ec54d84d09a85ad40da58e6c261be80c0d08134c93b1bef",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 393.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 393,34",
//                          "display": "R$ 393,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 393.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 393,34",
//                          "display": "R$ 393,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "c0fc93d016ed082eb5948f3558a7663e5678b9ed7e9a6e32e39decc6efe9c17d",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 351.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 351,34",
//                          "display": "R$ 351,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 351.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 351,34",
//                          "display": "R$ 351,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 251.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 251,34",
//                      "display": "R$ 251,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 105,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "321",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4513,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": "1"
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T07:25:00",
//                      "arrival": "2021-05-17T09:10:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [
//                      "FASTEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 100,
//                    "flightCode": "LA4679",
//                    "origin": {
//                      "departure": "2021-05-17T10:00:00",
//                      "departureTime": "10:00",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T11:40:00",
//                      "arrivalTime": "11:40",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "a09a6882feeea6f063fde2fdbd27c84dfee8107b5a68d161793524f172ae9eaf",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 251.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 251,34",
//                          "display": "R$ 251,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 251.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 251,34",
//                          "display": "R$ 251,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "f0440f1399ccc3f9d56642b0943bb83cc418fb063ab526b6573fa9873c5fdfdb",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 322.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 322,34",
//                          "display": "R$ 322,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 322.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 322,34",
//                          "display": "R$ 322,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "2ac003928d85545171460cacf8c8c8c3647613cf88f4a0bd07b0bdbaf713706d",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 393.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 393,34",
//                          "display": "R$ 393,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 393.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 393,34",
//                          "display": "R$ 393,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "d8a2b1b9b971f9bcfae0456702f9b20c6b386de62114f6d3a947893827bdf3d2",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "OJKX0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 351.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 351,34",
//                          "display": "R$ 351,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 351.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 351,34",
//                          "display": "R$ 351,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 251.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 251,34",
//                      "display": "R$ 251,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 100,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "321",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4679,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": null
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T10:00:00",
//                      "arrival": "2021-05-17T11:40:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [
//                      "FASTEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 100,
//                    "flightCode": "LA4671",
//                    "origin": {
//                      "departure": "2021-05-17T13:00:00",
//                      "departureTime": "13:00",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T14:40:00",
//                      "arrivalTime": "14:40",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "74603c35a40444c7072bee9c12e27dfa5566b0d95d4b71e464fa16a01d17ea92",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "MJ0X0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 1240.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.240,34",
//                          "display": "R$ 1.240,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 1240.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.240,34",
//                          "display": "R$ 1.240,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "f8626870afec28ef1dac0599be038600785ac4e30e02a5797d4b811d8d6ffd09",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "MJ0X0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 1349.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.349,34",
//                          "display": "R$ 1.349,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 1349.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.349,34",
//                          "display": "R$ 1.349,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "5e0c1b723a0271867dd0f1e30142774f45408094a345456460e93ea859d9ae58",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "MJ0X0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 1458.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.458,34",
//                          "display": "R$ 1.458,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 1458.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.458,34",
//                          "display": "R$ 1.458,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "d6f5c5a6fb1e41579054f33d92ac45c2e0ba0ba0586662ce56398215e1b7a527",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "MJ0X0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 1340.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.340,34",
//                          "display": "R$ 1.340,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 1340.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 1.340,34",
//                          "display": "R$ 1.340,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 1240.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 1.240,34",
//                      "display": "R$ 1.240,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 100,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "320",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4671,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": "1"
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T13:00:00",
//                      "arrival": "2021-05-17T14:40:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [
//                      "CHEAPEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 105,
//                    "flightCode": "LA4673",
//                    "origin": {
//                      "departure": "2021-05-17T17:00:00",
//                      "departureTime": "17:00",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T18:45:00",
//                      "arrivalTime": "18:45",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "7ced8add66d1d50176acc6e3bd81623ac750c967f561decee7dfd6d702943d94",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "3ef14a9d101f4f2f98be0ab9b6a58f25ce20e6f85d6b33b4d936b57e77981cbf",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "a1c61c2fee8d2c0116f8dd7c076a8fec905a85c5444d7b9c7ad7e7a1acac0410",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GJSX0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "28191c7b56a58bfd35a0975bb0eab0d4f01f5bfb2e92589a251d71149fc77d41",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 136.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 136,34",
//                      "display": "R$ 136,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 105,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "321",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4673,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": null
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T17:00:00",
//                      "arrival": "2021-05-17T18:45:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [
//                      "CHEAPEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 105,
//                    "flightCode": "LA4675",
//                    "origin": {
//                      "departure": "2021-05-17T21:05:00",
//                      "departureTime": "21:05",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T22:50:00",
//                      "arrivalTime": "22:50",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "f96048e7f2cc54f88f9517f9aa13b571727565a2dd838093e80bd26490aa241d",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "e39ace3c8529ff769a4f06f089e71c26b82cad3b5826165edea676b9543cdf42",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "a03e5ab9ea9b6af6a483c4d13345b56304cbf8bea52312759079933aeab45462",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GJSX0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "ed8828b1b405c4303b3d2a8733fba8aee8b284e998e08d6f31a072829f6ebf03",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 136.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 136,34",
//                      "display": "R$ 136,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 105,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "320",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4675,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": "1"
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T21:05:00",
//                      "arrival": "2021-05-17T22:50:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [
//                      "CHEAPEST"
//                    ],
//                    "stopOvers": 0,
//                    "duration": 105,
//                    "flightCode": "LA4677",
//                    "origin": {
//                      "departure": "2021-05-17T21:55:00",
//                      "departureTime": "21:55",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T23:40:00",
//                      "arrivalTime": "23:40",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "f2436c6a6b33f9b1bb146f5c127a9ca18b12e9f9d2b45fa4468ff85ab11cf26f",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 136.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 136,34",
//                          "display": "R$ 136,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": false
//                          },
//                          "checkedBaggage": {
//                            "show": false,
//                            "weightLimit": {},
//                            "quantity": "0"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SE",
//                        "offerId": "2c1f2162058f08a8f52dcaae5738ed899405c2557c24e08565b85cd496d3afa3",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_economy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N8",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 205.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 205,34",
//                          "display": "R$ 205,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "SF",
//                        "offerId": "946a033f303608bec538bb920fd4e312e968350e851beaf30448528a7bd8f942",
//                        "brandText": "TOP",
//                        "brandDescription": "xp_sales_web_brand_economy_top_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "GJSX0N9",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 300.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 300,34",
//                          "display": "R$ 300,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "2"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 22,
//                              "KILOGRAMS": 10
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      },
//                      {
//                        "id": "RA",
//                        "offerId": "f98603d8a8445b36aaab6f70813bcaaf71967eb68ca07793de80401c03a808bd",
//                        "brandText": "PLUS",
//                        "brandDescription": "xp_sales_web_brand_premiumeconomy_plus_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "PremiumEconomy"
//                        },
//                        "rules": {},
//                        "farebasis": "GDHX0N2",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 236.34,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 236,34",
//                          "display": "R$ 236,34"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": true
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": true,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          },
//                          "personalItem": {
//                            "show": true
//                          },
//                          "seatSelection": {
//                            "show": true
//                          },
//                          "checkedBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 50,
//                              "KILOGRAMS": 23
//                            },
//                            "quantity": "1"
//                          },
//                          "carryOnBaggage": {
//                            "show": true,
//                            "weightLimit": {
//                              "POUNDS": 35,
//                              "KILOGRAMS": 16
//                            },
//                            "quantity": "1"
//                          }
//                        }
//                      }
//                    ],
//                    "lowestPrice": {
//                      "currency": "BRL",
//                      "amount": 136.34,
//                      "displayCurrency": "R$",
//                      "displayAmount": " 136,34",
//                      "display": "R$ 136,34"
//                    }
//                  },
//                  "itinerary": [
//                    {
//                      "duration": 105,
//                      "flightsMiles": null,
//                      "cabinClass": null,
//                      "equipment": "321",
//                      "aircraftLeaseText": "LATAM AIRLINES BRASIL",
//                      "flight": {
//                        "flightNumber": 4677,
//                        "airlineCode": "LA",
//                        "operatingAirlineCode": "LA",
//                        "stopAirports": [],
//                        "departureTerminal": "2",
//                        "arrivalTerminal": null
//                      },
//                      "origin": "GRU",
//                      "destination": "POA",
//                      "departure": "2021-05-17T21:55:00",
//                      "arrival": "2021-05-17T23:40:00",
//                      "bookingClass": null,
//                      "fareBasis": null,
//                      "type": null,
//                      "amenityLink": null
//                    }
//                  ]
//                },
//                {
//                  "summary": {
//                    "tags": [],
//                    "stopOvers": 1,
//                    "duration": 485,
//                    "flightCode": "LA3198",
//                    "origin": {
//                      "departure": "2021-05-17T08:55:00",
//                      "departureTime": "8:55",
//                      "iataCode": "GRU",
//                      "city": "Sao Paulo"
//                    },
//                    "destination": {
//                      "arrival": "2021-05-17T17:00:00",
//                      "arrivalTime": "17:00",
//                      "iataCode": "POA",
//                      "city": "Porto Alegre"
//                    },
//                    "brands": [
//                      {
//                        "id": "SL",
//                        "offerId": "dbc653acd9397fe9b14e52ff3d751f4ceb4a007c0c11d6697d71f9e850d28dd0",
//                        "brandText": "LIGHT",
//                        "brandDescription": "xp_sales_web_brand_economy_light_description",
//                        "promotionalText": {
//                          "show": false,
//                          "label": ""
//                        },
//                        "cabin": {
//                          "id": "Y",
//                          "label": "Economy"
//                        },
//                        "rules": {},
//                        "farebasis": "SJ7X0G1",
//                        "price": {
//                          "currency": "BRL",
//                          "amount": 770.44,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 770,44",
//                          "display": "R$ 770,44"
//                        },
//                        "priceAfterSelection": {
//                          "currency": "BRL",
//                          "amount": 770.44,
//                          "displayCurrency": "R$",
//                          "displayAmount": " 770,44",
//                          "display": "R$ 770,44"
//                        },
//                        "attributes": {
//                          "comfortableSeat": {
//                            "show": false
//                          },
//                          "latamPlusSeat": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "food": {
//                            "show": false,
//                            "exclusive": false
//                          },
//                          "accrual": {
//                            "show": true
//                          }
//            """;
}
