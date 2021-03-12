var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1000000",
        "ok": "963747",
        "ko": "36253"
    },
    "minResponseTime": {
        "total": "831",
        "ok": "831",
        "ko": "151736"
    },
    "maxResponseTime": {
        "total": "211822",
        "ok": "204861",
        "ko": "211822"
    },
    "meanResponseTime": {
        "total": "108723",
        "ok": "106009",
        "ko": "180888"
    },
    "standardDeviation": {
        "total": "57458",
        "ok": "56745",
        "ko": "7845"
    },
    "percentiles1": {
        "total": "115947",
        "ok": "111210",
        "ko": "181366"
    },
    "percentiles2": {
        "total": "160646",
        "ok": "157732",
        "ko": "186938"
    },
    "percentiles3": {
        "total": "184956",
        "ok": "183368",
        "ko": "194644"
    },
    "percentiles4": {
        "total": "194898",
        "ok": "194477",
        "ko": "197759"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 49,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 963698,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 36253,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2932.551",
        "ok": "2826.238",
        "ko": "106.314"
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
        "ok": "963747",
        "ko": "36253"
    },
    "minResponseTime": {
        "total": "831",
        "ok": "831",
        "ko": "151736"
    },
    "maxResponseTime": {
        "total": "211822",
        "ok": "204861",
        "ko": "211822"
    },
    "meanResponseTime": {
        "total": "108723",
        "ok": "106009",
        "ko": "180888"
    },
    "standardDeviation": {
        "total": "57458",
        "ok": "56745",
        "ko": "7845"
    },
    "percentiles1": {
        "total": "115996",
        "ok": "111162",
        "ko": "181366"
    },
    "percentiles2": {
        "total": "160651",
        "ok": "157735",
        "ko": "186938"
    },
    "percentiles3": {
        "total": "184966",
        "ok": "183368",
        "ko": "194644"
    },
    "percentiles4": {
        "total": "194901",
        "ok": "194483",
        "ko": "197759"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 49,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 963698,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 36253,
    "percentage": 4
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2932.551",
        "ok": "2826.238",
        "ko": "106.314"
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
