var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "500000",
        "ok": "488470",
        "ko": "11530"
    },
    "minResponseTime": {
        "total": "36",
        "ok": "36",
        "ko": "22621"
    },
    "maxResponseTime": {
        "total": "65492",
        "ok": "65492",
        "ko": "65483"
    },
    "meanResponseTime": {
        "total": "26153",
        "ok": "25365",
        "ko": "59556"
    },
    "standardDeviation": {
        "total": "18606",
        "ok": "18038",
        "ko": "9308"
    },
    "percentiles1": {
        "total": "21248",
        "ok": "20622",
        "ko": "62730"
    },
    "percentiles2": {
        "total": "42287",
        "ok": "40194",
        "ko": "63867"
    },
    "percentiles3": {
        "total": "59202",
        "ok": "57466",
        "ko": "64992"
    },
    "percentiles4": {
        "total": "63419",
        "ok": "61447",
        "ko": "65249"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1669,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 2883,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 483918,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 11530,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3906.25",
        "ok": "3816.172",
        "ko": "90.078"
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
        "total": "500000",
        "ok": "488470",
        "ko": "11530"
    },
    "minResponseTime": {
        "total": "36",
        "ok": "36",
        "ko": "22621"
    },
    "maxResponseTime": {
        "total": "65492",
        "ok": "65492",
        "ko": "65483"
    },
    "meanResponseTime": {
        "total": "26153",
        "ok": "25365",
        "ko": "59556"
    },
    "standardDeviation": {
        "total": "18606",
        "ok": "18038",
        "ko": "9308"
    },
    "percentiles1": {
        "total": "21261",
        "ok": "20624",
        "ko": "62730"
    },
    "percentiles2": {
        "total": "42275",
        "ok": "40204",
        "ko": "63867"
    },
    "percentiles3": {
        "total": "59206",
        "ok": "57475",
        "ko": "64992"
    },
    "percentiles4": {
        "total": "63419",
        "ok": "61447",
        "ko": "65249"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1669,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 2883,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 483918,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 11530,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3906.25",
        "ok": "3816.172",
        "ko": "90.078"
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
