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
        "total": "3805",
        "ok": "3805",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "310",
        "ok": "310",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "547",
        "ok": "547",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "percentiles2": {
        "total": "537",
        "ok": "537",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1486",
        "ok": "1486",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2225",
        "ok": "2226",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 81840,
    "percentage": 82
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8192,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 9968,
    "percentage": 10
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
"req_saving-an-itine-6b395": {
        type: "REQUEST",
        name: "saving an itinerary using save in a hashmap",
path: "saving an itinerary using save in a hashmap",
pathFormatted: "req_saving-an-itine-6b395",
stats: {
    "name": "saving an itinerary using save in a hashmap",
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
        "total": "3805",
        "ok": "3805",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "310",
        "ok": "310",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "547",
        "ok": "547",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "percentiles2": {
        "total": "537",
        "ok": "537",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1487",
        "ok": "1486",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2226",
        "ok": "2226",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 81840,
    "percentage": 82
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8192,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 9968,
    "percentage": 10
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
