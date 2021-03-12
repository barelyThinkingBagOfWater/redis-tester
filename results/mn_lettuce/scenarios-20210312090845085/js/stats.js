var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "959520",
        "ko": "40480"
    },
    "minResponseTime": {
        "total": "978",
        "ok": "978",
        "ko": "75505"
    },
    "maxResponseTime": {
        "total": "236174",
        "ok": "236174",
        "ko": "229878"
    },
    "meanResponseTime": {
        "total": "120073",
        "ok": "116355",
        "ko": "208198"
    },
    "standardDeviation": {
        "total": "65925",
        "ok": "64457",
        "ko": "28082"
    },
    "percentiles1": {
        "total": "121938",
        "ok": "118618",
        "ko": "216747"
    },
    "percentiles2": {
        "total": "181010",
        "ok": "175297",
        "ko": "221712"
    },
    "percentiles3": {
        "total": "217107",
        "ok": "213147",
        "ko": "228202"
    },
    "percentiles4": {
        "total": "225158",
        "ok": "222834",
        "ko": "229840"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 53,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 959467,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 40480,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2747.253",
        "ok": "2636.044",
        "ko": "111.209"
    }
},
contents: {
"req_saving-an-itine-d1b32": {
        type: "REQUEST",
        name: "saving an itinerary using save",
path: "saving an itinerary using save",
pathFormatted: "req_saving-an-itine-d1b32",
stats: {
    "name": "saving an itinerary using save",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "959520",
        "ko": "40480"
    },
    "minResponseTime": {
        "total": "978",
        "ok": "978",
        "ko": "75505"
    },
    "maxResponseTime": {
        "total": "236174",
        "ok": "236174",
        "ko": "229878"
    },
    "meanResponseTime": {
        "total": "120073",
        "ok": "116355",
        "ko": "208198"
    },
    "standardDeviation": {
        "total": "65925",
        "ok": "64457",
        "ko": "28082"
    },
    "percentiles1": {
        "total": "121950",
        "ok": "118276",
        "ko": "216750"
    },
    "percentiles2": {
        "total": "181020",
        "ok": "175335",
        "ko": "221712"
    },
    "percentiles3": {
        "total": "217102",
        "ok": "213147",
        "ko": "228202"
    },
    "percentiles4": {
        "total": "225180",
        "ok": "222830",
        "ko": "229840"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 53,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 959467,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 40480,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2747.253",
        "ok": "2636.044",
        "ko": "111.209"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
