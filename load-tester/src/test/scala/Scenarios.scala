import TestRequests._
import com.google.gson.Gson
import entities.ItinerariesGenerator
import io.gatling.core.Predef._
import io.gatling.core.feeder.Feeder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt


class Scenarios extends Simulation {

  val gson: Gson = new Gson
  val generator: ItinerariesGenerator = new ItinerariesGenerator
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:30080")
    .contentTypeHeader("application/json")


  def generateRandomItineraries(): String = {
    generator generateItinerariesAsJson NUMBER_OF_ITINERARIES_TO_SAVE;
  }

  val itineraryFeeder: Feeder[String] = Iterator.continually(
    Map("itinerary" -> generator.generateItineraryAsJson(), "hash" -> generator.getHashOfLastGeneratedItineraries))

  val itinerariesFeeder: Feeder[String] = Iterator.continually(
    Map("itineraries" -> generator.generateItinerariesAsJson(NUMBER_OF_ITINERARIES_TO_SAVE),
      "hashes" -> generator.getHashOfLastGeneratedItineraries))


  val NUMBER_OF_ITINERARIES_TO_SAVE: Int = 20


  val saveOneItineraryScenario: ScenarioBuilder =
    scenario("Saving one itinerary")
      .feed(itineraryFeeder)
      .exec(
        http("saving an itinerary using save")
          .post("/itinerary")
          .body(StringBody("${itinerary}")).asJson)
//      .exec(deleteAllItineraries())


  val findOneItineraryScenario: ScenarioBuilder =
    scenario("Finding one itinerary after saving it")
      .feed(itineraryFeeder)
      .exec(
        http("saving an itinerary using save")
          .post("/itinerary")
          .body(StringBody("${itinerary}")).asJson)
      .exec(
        http("finding an itinerary using find")
          .post("/find")
          .body(StringBody("${hash}"))
          .check(status.not(404))
          .asJson)
//      .exec(deleteAllItineraries())


  val saveItinerariesWithSaveAllScenario: ScenarioBuilder =
    scenario("Saving " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries with saveAll")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll")
          .post("/itineraries")
          .body(StringBody("${itineraries}")).asJson)
//      .exec(deleteAllItineraries())

  val saveItinerariesWithSaveAllUsingPipelineScenario: ScenarioBuilder =
    scenario("Saving " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries with saveAll using pipeline")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll with pipeline")
          .post("/itineraries/pipeline")
          .body(StringBody("${itineraries}")).asJson)
//      .exec(deleteAllItineraries())

  val findItinerariesScenario: ScenarioBuilder =
    scenario("Finding " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries after saving them")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll")
          .post("/itineraries")
          .body(StringBody("${itineraries}")).asJson)
      .exec(
        http("finding itineraries using findAll")
          .post("/findAll")
          .body(StringBody("${hashes}"))
          .check(status.not(404))
          .asJson)
//      .exec(deleteAllItineraries())

  val saveOneItineraryInHashmapScenario: ScenarioBuilder =
    scenario("Saving one itinerary in hashmap")
      .feed(itineraryFeeder)
      .exec(
        http("saving an itinerary using save in a hashmap")
          .post("/itinerary/hashmap")
          .body(StringBody("${itinerary}")).asJson)
//      .exec(deleteAllItineraries())

  val findOneItineraryInHashmapScenario: ScenarioBuilder =
    scenario("Finding one itinerary in hashmap after saving it")
      .feed(itineraryFeeder)
      .exec(
        http("saving an itinerary using save in hashmap")
          .post("/itinerary/hashmap")
          .body(StringBody("${itinerary}")).asJson)
      .exec(
        http("finding an itinerary in hashmap using find")
          .post("/find/hashmap")
          .body(StringBody("${hash}"))
          .check(status.not(404))
          .asJson)
//      .exec(deleteAllItineraries())

  val saveItinerariesWithSaveAllInHashmapScenario: ScenarioBuilder =
    scenario("Saving " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries with saveAll using pipeline")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll in hashmap")
          .post("/itineraries/hashmap")
          .body(StringBody("${itineraries}")).asJson)
//      .exec(deleteAllItineraries())

  val saveItinerariesWithSaveAllInHashmapUsingPipelineScenario: ScenarioBuilder =
    scenario("Saving " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries with saveAll using pipeline")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll in hashmap with pipeline")
          .post("/itineraries/hashmap/pipeline")
          .body(StringBody("${itineraries}")).asJson)
//      .exec(deleteAllItineraries())

  val findItinerariesInHashmapScenario: ScenarioBuilder =
    scenario("Finding " + NUMBER_OF_ITINERARIES_TO_SAVE + " itineraries in hashmap after saving them")
      .feed(itinerariesFeeder)
      .exec(
        http("saving itineraries using saveAll in hashmap")
          .post("/itineraries/hashmap")
          .body(StringBody("${itineraries}")).asJson)
      .exec(
        http("finding itineraries using findAll in hashmap")
          .post("/findAll/hashmap")
          .body(StringBody("${hashes}"))
          .check(status.not(404))
          .asJson)
//      .exec(deleteAllItineraries())


  // WRITING
  setUp(saveOneItineraryScenario
//  setUp(saveItinerariesWithSaveAllScenario
//  setUp(saveItinerariesWithSaveAllUsingPipelineScenario
//  setUp(saveOneItineraryInHashmapScenario
//  setUp(saveItinerariesWithSaveAllInHashmapScenario
//  setUp(saveItinerariesWithSaveAllInHashmapUsingPipelineScenario

    // READING
//    setUp(findOneItineraryScenario
//  setUp(findItinerariesScenario
//  setUp(findOneItineraryInHashmapScenario
//  setUp(findItinerariesInHashmapScenario


//    .inject(atOnceUsers(2))
    .inject(rampUsers(1000000) during (30 second))
//    .inject(rampUsers(100000) during (30 second))
//    .inject(rampUsers(1000) during (30 second))
//    .inject(rampUsers(2))
//    .inject(rampUsersPerSec(100) during (20 minutes))
    .protocols(httpProtocol))
}