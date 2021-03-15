var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "700000",
        "ok": "687589",
        "ko": "12411"
    },
    "minResponseTime": {
        "total": "304",
        "ok": "304",
        "ko": "17937"
    },
    "maxResponseTime": {
        "total": "76098",
        "ok": "75639",
        "ko": "76098"
    },
    "meanResponseTime": {
        "total": "30813",
        "ok": "30299",
        "ko": "59294"
    },
    "standardDeviation": {
        "total": "16566",
        "ok": "16182",
        "ko": "12039"
    },
    "percentiles1": {
        "total": "29228",
        "ok": "28841",
        "ko": "61117"
    },
    "percentiles2": {
        "total": "44015",
        "ok": "43350",
        "ko": "65958"
    },
    "percentiles3": {
        "total": "58971",
        "ok": "57067",
        "ko": "75204"
    },
    "percentiles4": {
        "total": "69270",
        "ok": "67918",
        "ko": "76094"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 427,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 923,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 686239,
    "percentage": 98
},
    "group4": {
    "name": "failed",
    "count": 12411,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "5185.185",
        "ok": "5093.252",
        "ko": "91.933"
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
        "ok": "687589",
        "ko": "12411"
    },
    "minResponseTime": {
        "total": "304",
        "ok": "304",
        "ko": "17937"
    },
    "maxResponseTime": {
        "total": "76098",
        "ok": "75639",
        "ko": "76098"
    },
    "meanResponseTime": {
        "total": "30813",
        "ok": "30299",
        "ko": "59294"
    },
    "standardDeviation": {
        "total": "16566",
        "ok": "16182",
        "ko": "12039"
    },
    "percentiles1": {
        "total": "29236",
        "ok": "28833",
        "ko": "61117"
    },
    "percentiles2": {
        "total": "44023",
        "ok": "43339",
        "ko": "65958"
    },
    "percentiles3": {
        "total": "58959",
        "ok": "57075",
        "ko": "75207"
    },
    "percentiles4": {
        "total": "69269",
        "ok": "67917",
        "ko": "76094"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 427,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 923,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 686239,
    "percentage": 98
},
    "group4": {
    "name": "failed",
    "count": 12411,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "5185.185",
        "ok": "5093.252",
        "ko": "91.933"
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
