var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "699626",
        "ko": "374"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "27927"
    },
    "maxResponseTime": {
        "total": "42016",
        "ok": "39583",
        "ko": "42016"
    },
    "meanResponseTime": {
        "total": "16256",
        "ok": "16246",
        "ko": "34659"
    },
    "standardDeviation": {
        "total": "8529",
        "ok": "8520",
        "ko": "3192"
    },
    "percentiles1": {
        "total": "17599",
        "ok": "17594",
        "ko": "33117"
    },
    "percentiles2": {
        "total": "22719",
        "ok": "22710",
        "ko": "35991"
    },
    "percentiles3": {
        "total": "29364",
        "ok": "29338",
        "ko": "40112"
    },
    "percentiles4": {
        "total": "32629",
        "ok": "32602",
        "ko": "42014"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4868,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4644,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 690114,
    "percentage": 99
},
    "group4": {
    "name": "failed",
    "count": 374,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6796.117",
        "ok": "6792.485",
        "ko": "3.631"
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
        "ok": "699626",
        "ko": "374"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "27927"
    },
    "maxResponseTime": {
        "total": "42016",
        "ok": "39583",
        "ko": "42016"
    },
    "meanResponseTime": {
        "total": "16256",
        "ok": "16246",
        "ko": "34659"
    },
    "standardDeviation": {
        "total": "8529",
        "ok": "8520",
        "ko": "3192"
    },
    "percentiles1": {
        "total": "17597",
        "ok": "17593",
        "ko": "33117"
    },
    "percentiles2": {
        "total": "22718",
        "ok": "22712",
        "ko": "35991"
    },
    "percentiles3": {
        "total": "29366",
        "ok": "29337",
        "ko": "40112"
    },
    "percentiles4": {
        "total": "32629",
        "ok": "32602",
        "ko": "42014"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4868,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4644,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 690114,
    "percentage": 99
},
    "group4": {
    "name": "failed",
    "count": 374,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6796.117",
        "ok": "6792.485",
        "ko": "3.631"
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
