var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "699764",
        "ko": "236"
    },
    "minResponseTime": {
        "total": "812",
        "ok": "812",
        "ko": "32354"
    },
    "maxResponseTime": {
        "total": "34411",
        "ok": "34411",
        "ko": "32396"
    },
    "meanResponseTime": {
        "total": "14820",
        "ok": "14814",
        "ko": "32382"
    },
    "standardDeviation": {
        "total": "6177",
        "ok": "6169",
        "ko": "11"
    },
    "percentiles1": {
        "total": "15522",
        "ok": "15525",
        "ko": "32384"
    },
    "percentiles2": {
        "total": "19862",
        "ok": "19861",
        "ko": "32391"
    },
    "percentiles3": {
        "total": "23856",
        "ok": "23850",
        "ko": "32396"
    },
    "percentiles4": {
        "total": "26927",
        "ok": "26893",
        "ko": "32396"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699755,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 236,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7777.778",
        "ok": "7775.156",
        "ko": "2.622"
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
        "ok": "699764",
        "ko": "236"
    },
    "minResponseTime": {
        "total": "812",
        "ok": "812",
        "ko": "32354"
    },
    "maxResponseTime": {
        "total": "34411",
        "ok": "34411",
        "ko": "32396"
    },
    "meanResponseTime": {
        "total": "14820",
        "ok": "14814",
        "ko": "32382"
    },
    "standardDeviation": {
        "total": "6177",
        "ok": "6169",
        "ko": "11"
    },
    "percentiles1": {
        "total": "15522",
        "ok": "15527",
        "ko": "32384"
    },
    "percentiles2": {
        "total": "19862",
        "ok": "19861",
        "ko": "32391"
    },
    "percentiles3": {
        "total": "23856",
        "ok": "23849",
        "ko": "32396"
    },
    "percentiles4": {
        "total": "26927",
        "ok": "26893",
        "ko": "32396"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 699755,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 236,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "7777.778",
        "ok": "7775.156",
        "ko": "2.622"
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
