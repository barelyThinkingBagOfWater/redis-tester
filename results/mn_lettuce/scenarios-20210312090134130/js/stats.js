var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "956798",
        "ko": "43202"
    },
    "minResponseTime": {
        "total": "1081",
        "ok": "1081",
        "ko": "85555"
    },
    "maxResponseTime": {
        "total": "223164",
        "ok": "223164",
        "ko": "214711"
    },
    "meanResponseTime": {
        "total": "118710",
        "ok": "116459",
        "ko": "168560"
    },
    "standardDeviation": {
        "total": "61477",
        "ok": "61780",
        "ko": "18899"
    },
    "percentiles1": {
        "total": "135714",
        "ok": "131451",
        "ko": "171435"
    },
    "percentiles2": {
        "total": "171588",
        "ok": "170794",
        "ko": "180185"
    },
    "percentiles3": {
        "total": "198181",
        "ok": "198663",
        "ko": "192718"
    },
    "percentiles4": {
        "total": "211020",
        "ok": "211140",
        "ko": "195979"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 37,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 956761,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 43202,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2739.726",
        "ok": "2621.364",
        "ko": "118.362"
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
        "total": "1000000",
        "ok": "956798",
        "ko": "43202"
    },
    "minResponseTime": {
        "total": "1081",
        "ok": "1081",
        "ko": "85555"
    },
    "maxResponseTime": {
        "total": "223164",
        "ok": "223164",
        "ko": "214711"
    },
    "meanResponseTime": {
        "total": "118710",
        "ok": "116459",
        "ko": "168560"
    },
    "standardDeviation": {
        "total": "61477",
        "ok": "61780",
        "ko": "18899"
    },
    "percentiles1": {
        "total": "135691",
        "ok": "131419",
        "ko": "171438"
    },
    "percentiles2": {
        "total": "171811",
        "ok": "170793",
        "ko": "180185"
    },
    "percentiles3": {
        "total": "198182",
        "ok": "198663",
        "ko": "192718"
    },
    "percentiles4": {
        "total": "211019",
        "ok": "211136",
        "ko": "195979"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 37,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 956761,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 43202,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2739.726",
        "ok": "2621.364",
        "ko": "118.362"
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