var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "971887",
        "ko": "28113"
    },
    "minResponseTime": {
        "total": "363",
        "ok": "363",
        "ko": "179808"
    },
    "maxResponseTime": {
        "total": "265673",
        "ok": "222051",
        "ko": "265673"
    },
    "meanResponseTime": {
        "total": "113352",
        "ok": "110566",
        "ko": "209690"
    },
    "standardDeviation": {
        "total": "59686",
        "ok": "58168",
        "ko": "14045"
    },
    "percentiles1": {
        "total": "115560",
        "ok": "112739",
        "ko": "210397"
    },
    "percentiles2": {
        "total": "163688",
        "ok": "159414",
        "ko": "216996"
    },
    "percentiles3": {
        "total": "204131",
        "ok": "199039",
        "ko": "236763"
    },
    "percentiles4": {
        "total": "217119",
        "ok": "212147",
        "ko": "244503"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 55,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 19,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 971813,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 28113,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2949.853",
        "ok": "2866.923",
        "ko": "82.929"
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
        "ok": "971887",
        "ko": "28113"
    },
    "minResponseTime": {
        "total": "363",
        "ok": "363",
        "ko": "179808"
    },
    "maxResponseTime": {
        "total": "265673",
        "ok": "222051",
        "ko": "265673"
    },
    "meanResponseTime": {
        "total": "113352",
        "ok": "110566",
        "ko": "209690"
    },
    "standardDeviation": {
        "total": "59686",
        "ok": "58168",
        "ko": "14045"
    },
    "percentiles1": {
        "total": "115579",
        "ok": "112651",
        "ko": "210397"
    },
    "percentiles2": {
        "total": "163691",
        "ok": "159427",
        "ko": "216996"
    },
    "percentiles3": {
        "total": "204131",
        "ok": "199058",
        "ko": "236763"
    },
    "percentiles4": {
        "total": "217119",
        "ok": "212148",
        "ko": "244503"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 55,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 19,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 971813,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 28113,
    "percentage": 3
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2949.853",
        "ok": "2866.923",
        "ko": "82.929"
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
