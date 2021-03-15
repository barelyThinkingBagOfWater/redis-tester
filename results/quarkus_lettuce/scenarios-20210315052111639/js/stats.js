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
        "total": "1430",
        "ok": "1430",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "33417",
        "ok": "33417",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "12319",
        "ok": "12319",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "5261",
        "ok": "5261",
        "ko": "-"
    },
    "percentiles1": {
        "total": "12766",
        "ok": "12768",
        "ko": "-"
    },
    "percentiles2": {
        "total": "16279",
        "ok": "16284",
        "ko": "-"
    },
    "percentiles3": {
        "total": "20853",
        "ok": "20848",
        "ko": "-"
    },
    "percentiles4": {
        "total": "23656",
        "ok": "23656",
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
        "total": "8750",
        "ok": "8750",
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
        "total": "1430",
        "ok": "1430",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "33417",
        "ok": "33417",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "12319",
        "ok": "12319",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "5261",
        "ok": "5261",
        "ko": "-"
    },
    "percentiles1": {
        "total": "12769",
        "ok": "12766",
        "ko": "-"
    },
    "percentiles2": {
        "total": "16281",
        "ok": "16282",
        "ko": "-"
    },
    "percentiles3": {
        "total": "20850",
        "ok": "20848",
        "ko": "-"
    },
    "percentiles4": {
        "total": "23655",
        "ok": "23655",
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
        "total": "8750",
        "ok": "8750",
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
