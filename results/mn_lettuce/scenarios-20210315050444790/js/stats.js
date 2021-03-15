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
        "total": "802",
        "ok": "802",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "35245",
        "ok": "35245",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "13474",
        "ok": "13474",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6143",
        "ok": "6143",
        "ko": "-"
    },
    "percentiles1": {
        "total": "13148",
        "ok": "13173",
        "ko": "-"
    },
    "percentiles2": {
        "total": "17273",
        "ok": "17274",
        "ko": "-"
    },
    "percentiles3": {
        "total": "25083",
        "ok": "25085",
        "ko": "-"
    },
    "percentiles4": {
        "total": "28038",
        "ok": "28040",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 67,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699933,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8641.975",
        "ok": "8641.975",
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
        "total": "802",
        "ok": "802",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "35245",
        "ok": "35245",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "13474",
        "ok": "13474",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6143",
        "ok": "6143",
        "ko": "-"
    },
    "percentiles1": {
        "total": "13145",
        "ok": "13147",
        "ko": "-"
    },
    "percentiles2": {
        "total": "17273",
        "ok": "17275",
        "ko": "-"
    },
    "percentiles3": {
        "total": "25086",
        "ok": "25083",
        "ko": "-"
    },
    "percentiles4": {
        "total": "28039",
        "ok": "28036",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 67,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699933,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8641.975",
        "ok": "8641.975",
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
