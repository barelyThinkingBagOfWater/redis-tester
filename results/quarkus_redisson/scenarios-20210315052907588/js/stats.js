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
        "total": "1226",
        "ok": "1226",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "41276",
        "ok": "41276",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "17075",
        "ok": "17075",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "8086",
        "ok": "8086",
        "ko": "-"
    },
    "percentiles1": {
        "total": "15694",
        "ok": "15691",
        "ko": "-"
    },
    "percentiles2": {
        "total": "23097",
        "ok": "23083",
        "ko": "-"
    },
    "percentiles3": {
        "total": "32674",
        "ok": "32660",
        "ko": "-"
    },
    "percentiles4": {
        "total": "35864",
        "ok": "35864",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 700000,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7368.421",
        "ok": "7368.421",
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
        "total": "1226",
        "ok": "1226",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "41276",
        "ok": "41276",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "17075",
        "ok": "17075",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "8086",
        "ok": "8086",
        "ko": "-"
    },
    "percentiles1": {
        "total": "15691",
        "ok": "15693",
        "ko": "-"
    },
    "percentiles2": {
        "total": "23085",
        "ok": "23081",
        "ko": "-"
    },
    "percentiles3": {
        "total": "32703",
        "ok": "32702",
        "ko": "-"
    },
    "percentiles4": {
        "total": "35866",
        "ok": "35865",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 700000,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7368.421",
        "ok": "7368.421",
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
