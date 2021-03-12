var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "964228",
        "ko": "35772"
    },
    "minResponseTime": {
        "total": "763",
        "ok": "763",
        "ko": "68606"
    },
    "maxResponseTime": {
        "total": "229407",
        "ok": "228728",
        "ko": "229407"
    },
    "meanResponseTime": {
        "total": "120049",
        "ok": "116558",
        "ko": "214169"
    },
    "standardDeviation": {
        "total": "61740",
        "ok": "60064",
        "ko": "11270"
    },
    "percentiles1": {
        "total": "120202",
        "ok": "115757",
        "ko": "215967"
    },
    "percentiles2": {
        "total": "173556",
        "ok": "167793",
        "ko": "221570"
    },
    "percentiles3": {
        "total": "215571",
        "ok": "210714",
        "ko": "226406"
    },
    "percentiles4": {
        "total": "223783",
        "ok": "221663",
        "ko": "229329"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 68,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 964156,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 35772,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2793.296",
        "ok": "2693.374",
        "ko": "99.922"
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
        "ok": "964228",
        "ko": "35772"
    },
    "minResponseTime": {
        "total": "763",
        "ok": "763",
        "ko": "68606"
    },
    "maxResponseTime": {
        "total": "229407",
        "ok": "228728",
        "ko": "229407"
    },
    "meanResponseTime": {
        "total": "120049",
        "ok": "116558",
        "ko": "214169"
    },
    "standardDeviation": {
        "total": "61740",
        "ok": "60064",
        "ko": "11270"
    },
    "percentiles1": {
        "total": "120190",
        "ok": "116068",
        "ko": "215972"
    },
    "percentiles2": {
        "total": "173510",
        "ok": "167773",
        "ko": "221570"
    },
    "percentiles3": {
        "total": "215519",
        "ok": "210698",
        "ko": "226406"
    },
    "percentiles4": {
        "total": "223783",
        "ok": "221663",
        "ko": "229329"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 68,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 964156,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 35772,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2793.296",
        "ok": "2693.374",
        "ko": "99.922"
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
