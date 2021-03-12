var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "965869",
        "ko": "34131"
    },
    "minResponseTime": {
        "total": "940",
        "ok": "940",
        "ko": "102681"
    },
    "maxResponseTime": {
        "total": "198550",
        "ok": "198550",
        "ko": "191766"
    },
    "meanResponseTime": {
        "total": "106746",
        "ok": "104455",
        "ko": "171572"
    },
    "standardDeviation": {
        "total": "52666",
        "ok": "52062",
        "ko": "14546"
    },
    "percentiles1": {
        "total": "117831",
        "ok": "111920",
        "ko": "172302"
    },
    "percentiles2": {
        "total": "152059",
        "ok": "149822",
        "ko": "179723"
    },
    "percentiles3": {
        "total": "176684",
        "ok": "175210",
        "ko": "187889"
    },
    "percentiles4": {
        "total": "186979",
        "ok": "184764",
        "ko": "188452"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 43,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 965826,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 34131,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2958.58",
        "ok": "2857.601",
        "ko": "100.979"
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
        "ok": "965869",
        "ko": "34131"
    },
    "minResponseTime": {
        "total": "940",
        "ok": "940",
        "ko": "102681"
    },
    "maxResponseTime": {
        "total": "198550",
        "ok": "198550",
        "ko": "191766"
    },
    "meanResponseTime": {
        "total": "106746",
        "ok": "104455",
        "ko": "171572"
    },
    "standardDeviation": {
        "total": "52666",
        "ok": "52062",
        "ko": "14546"
    },
    "percentiles1": {
        "total": "117773",
        "ok": "111876",
        "ko": "172302"
    },
    "percentiles2": {
        "total": "152060",
        "ok": "149798",
        "ko": "179727"
    },
    "percentiles3": {
        "total": "176685",
        "ok": "175206",
        "ko": "187889"
    },
    "percentiles4": {
        "total": "186977",
        "ok": "184751",
        "ko": "188452"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 43,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 965826,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 34131,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2958.58",
        "ok": "2857.601",
        "ko": "100.979"
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
