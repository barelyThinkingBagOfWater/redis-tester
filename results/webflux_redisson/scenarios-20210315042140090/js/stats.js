var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "698226",
        "ko": "1774"
    },
    "minResponseTime": {
        "total": "188",
        "ok": "188",
        "ko": "15805"
    },
    "maxResponseTime": {
        "total": "42648",
        "ok": "42506",
        "ko": "42648"
    },
    "meanResponseTime": {
        "total": "17104",
        "ok": "17091",
        "ko": "22171"
    },
    "standardDeviation": {
        "total": "7096",
        "ok": "7090",
        "ko": "7582"
    },
    "percentiles1": {
        "total": "17325",
        "ok": "17298",
        "ko": "18474"
    },
    "percentiles2": {
        "total": "22352",
        "ok": "22308",
        "ko": "21916"
    },
    "percentiles3": {
        "total": "28844",
        "ok": "28828",
        "ko": "38586"
    },
    "percentiles4": {
        "total": "32106",
        "ok": "31958",
        "ko": "42638"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 572,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 605,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 697049,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 1774,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7368.421",
        "ok": "7349.747",
        "ko": "18.674"
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
        "total": "700000",
        "ok": "698226",
        "ko": "1774"
    },
    "minResponseTime": {
        "total": "188",
        "ok": "188",
        "ko": "15805"
    },
    "maxResponseTime": {
        "total": "42648",
        "ok": "42506",
        "ko": "42648"
    },
    "meanResponseTime": {
        "total": "17104",
        "ok": "17091",
        "ko": "22171"
    },
    "standardDeviation": {
        "total": "7096",
        "ok": "7090",
        "ko": "7582"
    },
    "percentiles1": {
        "total": "17322",
        "ok": "17297",
        "ko": "18474"
    },
    "percentiles2": {
        "total": "22303",
        "ok": "22356",
        "ko": "21916"
    },
    "percentiles3": {
        "total": "28843",
        "ok": "28826",
        "ko": "38586"
    },
    "percentiles4": {
        "total": "32106",
        "ok": "31958",
        "ko": "42638"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 572,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 605,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 697049,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 1774,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7368.421",
        "ok": "7349.747",
        "ko": "18.674"
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
