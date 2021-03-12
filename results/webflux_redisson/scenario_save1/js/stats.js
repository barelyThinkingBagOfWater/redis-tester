var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100000",
        "ok": "100000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7251",
        "ok": "7251",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "472",
        "ok": "472",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "814",
        "ok": "814",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "percentiles2": {
        "total": "865",
        "ok": "865",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2136",
        "ok": "2136",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3075",
        "ok": "3076",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 73723,
    "percentage": 74
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 7917,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 18360,
    "percentage": 18
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3333.333",
        "ok": "3333.333",
        "ko": "-"
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
        "total": "100000",
        "ok": "100000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7251",
        "ok": "7251",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "472",
        "ok": "472",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "814",
        "ok": "814",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "percentiles2": {
        "total": "865",
        "ok": "865",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2137",
        "ok": "2137",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3076",
        "ok": "3074",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 73723,
    "percentage": 74
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 7917,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 18360,
    "percentage": 18
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3333.333",
        "ok": "3333.333",
        "ko": "-"
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
