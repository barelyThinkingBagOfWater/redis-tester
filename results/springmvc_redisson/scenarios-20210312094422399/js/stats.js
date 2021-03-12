var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "962682",
        "ko": "37318"
    },
    "minResponseTime": {
        "total": "164",
        "ok": "164",
        "ko": "2322"
    },
    "maxResponseTime": {
        "total": "281186",
        "ok": "248920",
        "ko": "281186"
    },
    "meanResponseTime": {
        "total": "125790",
        "ok": "123084",
        "ko": "195589"
    },
    "standardDeviation": {
        "total": "63610",
        "ok": "62219",
        "ko": "59164"
    },
    "percentiles1": {
        "total": "129820",
        "ok": "126857",
        "ko": "216873"
    },
    "percentiles2": {
        "total": "181702",
        "ok": "177928",
        "ko": "224412"
    },
    "percentiles3": {
        "total": "216881",
        "ok": "213473",
        "ko": "251199"
    },
    "percentiles4": {
        "total": "229441",
        "ok": "225924",
        "ko": "268329"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 49,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 22,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 962611,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 37318,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2739.726",
        "ok": "2637.485",
        "ko": "102.241"
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
        "ok": "962682",
        "ko": "37318"
    },
    "minResponseTime": {
        "total": "164",
        "ok": "164",
        "ko": "2322"
    },
    "maxResponseTime": {
        "total": "281186",
        "ok": "248920",
        "ko": "281186"
    },
    "meanResponseTime": {
        "total": "125790",
        "ok": "123084",
        "ko": "195589"
    },
    "standardDeviation": {
        "total": "63610",
        "ok": "62219",
        "ko": "59164"
    },
    "percentiles1": {
        "total": "129908",
        "ok": "126879",
        "ko": "216873"
    },
    "percentiles2": {
        "total": "181709",
        "ok": "177927",
        "ko": "224412"
    },
    "percentiles3": {
        "total": "216879",
        "ok": "213474",
        "ko": "251199"
    },
    "percentiles4": {
        "total": "229345",
        "ok": "225927",
        "ko": "268329"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 49,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 22,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 962611,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 37318,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2739.726",
        "ok": "2637.485",
        "ko": "102.241"
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
