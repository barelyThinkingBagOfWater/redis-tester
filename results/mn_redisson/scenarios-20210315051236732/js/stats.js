var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "700000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "721",
        "ok": "721",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "48401",
        "ok": "48401",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "18457",
        "ok": "18457",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "9235",
        "ok": "9235",
        "ko": "-"
    },
    "percentiles1": {
        "total": "16232",
        "ok": "16238",
        "ko": "-"
    },
    "percentiles2": {
        "total": "25974",
        "ok": "25969",
        "ko": "-"
    },
    "percentiles3": {
        "total": "34608",
        "ok": "34610",
        "ko": "-"
    },
    "percentiles4": {
        "total": "40780",
        "ok": "40777",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 9,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 112,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699879,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7291.667",
        "ok": "7291.667",
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
        "total": "700000",
        "ok": "700000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "721",
        "ok": "721",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "48401",
        "ok": "48401",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "18457",
        "ok": "18457",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "9235",
        "ok": "9235",
        "ko": "-"
    },
    "percentiles1": {
        "total": "16236",
        "ok": "16236",
        "ko": "-"
    },
    "percentiles2": {
        "total": "25960",
        "ok": "25977",
        "ko": "-"
    },
    "percentiles3": {
        "total": "34610",
        "ok": "34610",
        "ko": "-"
    },
    "percentiles4": {
        "total": "40771",
        "ok": "40775",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 9,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 112,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699879,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7291.667",
        "ok": "7291.667",
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
