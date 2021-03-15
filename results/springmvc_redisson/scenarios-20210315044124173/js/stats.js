var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "694820",
        "ko": "5180"
    },
    "minResponseTime": {
        "total": "94",
        "ok": "94",
        "ko": "14275"
    },
    "maxResponseTime": {
        "total": "75901",
        "ok": "75901",
        "ko": "75872"
    },
    "meanResponseTime": {
        "total": "32079",
        "ok": "31985",
        "ko": "44624"
    },
    "standardDeviation": {
        "total": "14948",
        "ok": "14894",
        "ko": "16839"
    },
    "percentiles1": {
        "total": "32908",
        "ok": "32869",
        "ko": "47941"
    },
    "percentiles2": {
        "total": "43240",
        "ok": "43116",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "55999",
        "ok": "55888",
        "ko": "60040"
    },
    "percentiles4": {
        "total": "62558",
        "ok": "62478",
        "ko": "75007"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1409,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1095,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 692316,
    "percentage": 99
},
    "group4": {
    "name": "failed",
    "count": 5180,
    "percentage": 1
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4697.987",
        "ok": "4663.221",
        "ko": "34.765"
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
        "ok": "694820",
        "ko": "5180"
    },
    "minResponseTime": {
        "total": "94",
        "ok": "94",
        "ko": "14275"
    },
    "maxResponseTime": {
        "total": "75901",
        "ok": "75901",
        "ko": "75872"
    },
    "meanResponseTime": {
        "total": "32079",
        "ok": "31985",
        "ko": "44624"
    },
    "standardDeviation": {
        "total": "14948",
        "ok": "14894",
        "ko": "16839"
    },
    "percentiles1": {
        "total": "32921",
        "ok": "32883",
        "ko": "47941"
    },
    "percentiles2": {
        "total": "43236",
        "ok": "43120",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "55999",
        "ok": "55888",
        "ko": "60040"
    },
    "percentiles4": {
        "total": "62558",
        "ok": "62472",
        "ko": "75007"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1409,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1095,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 692316,
    "percentage": 99
},
    "group4": {
    "name": "failed",
    "count": 5180,
    "percentage": 1
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4697.987",
        "ok": "4663.221",
        "ko": "34.765"
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
