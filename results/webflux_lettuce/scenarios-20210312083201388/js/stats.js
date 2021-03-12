var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "300000",
        "ok": "300000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "20",
        "ok": "20",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "27115",
        "ok": "27115",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "9348",
        "ok": "9348",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6546",
        "ok": "6546",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8254",
        "ok": "8249",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13299",
        "ok": "13294",
        "ko": "-"
    },
    "percentiles3": {
        "total": "22159",
        "ok": "22159",
        "ko": "-"
    },
    "percentiles4": {
        "total": "24093",
        "ok": "24092",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4304,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 5589,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 290107,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4615.385",
        "ok": "4615.385",
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
        "total": "300000",
        "ok": "300000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "20",
        "ok": "20",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "27115",
        "ok": "27115",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "9348",
        "ok": "9348",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6546",
        "ok": "6546",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8254",
        "ok": "8253",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13297",
        "ok": "13290",
        "ko": "-"
    },
    "percentiles3": {
        "total": "22157",
        "ok": "22158",
        "ko": "-"
    },
    "percentiles4": {
        "total": "24091",
        "ok": "24092",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4304,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 5589,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 290107,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4615.385",
        "ok": "4615.385",
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
