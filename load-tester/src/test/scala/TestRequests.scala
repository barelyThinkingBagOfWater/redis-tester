import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object TestRequests {

  def saveOneItinerary(itineraryAsJson: String): ChainBuilder = {
    exec(
      http("saving an itinerary using save")
        .post("/itinerary")
        .body(StringBody(session => itineraryAsJson)).asJson)
  }

  def findOneItinerary(hashesAsJson: String): ChainBuilder = {
    exec(
      http("finding an itinerary using find")
        .post("/find")
        .body(StringBody(session => hashesAsJson)).asJson
    .check(status.not(404))) //Do you want this check?
  }

  def saveAllItineraries(itinerariesAsJson: String): ChainBuilder = {
    exec(
      http("saving itineraries using saveAll")
        .post("/itineraries")
        .body(StringBody(session => itinerariesAsJson)).asJson)
  }

  def saveAllItinerariesUsingPipeline(itinerariesAsJson: String): ChainBuilder = {
    exec(
      http("saving itineraries using saveAll with pipeline")
        .post("/itineraries/pipeline")
        .body(StringBody(session => itinerariesAsJson)).asJson)
  }

  def findAllItineraries(hashesAsJson: String): ChainBuilder = {
    exec(
      http("finding itineraries using findAll")
        .post("/findAll")
        .body(StringBody(session => hashesAsJson)).asJson)
  }

  def saveOneItineraryInHashmap(itineraryAsJson: String): ChainBuilder = {
    exec(
      http("saving an itinerary using save in a hashmap")
        .post("/itinerary/hashmap")
        .body(StringBody(session => itineraryAsJson)).asJson)
  }

  def findOneItineraryInHashmap(hashesAsJson: String): ChainBuilder = {
    exec(
      http("finding an itinerary in hashmap using find")
        .post("/find/hashmap")
        .body(StringBody(session => hashesAsJson)).asJson)
  }

  def saveAllItinerariesInHashmap(itinerariesAsJson: String): ChainBuilder = {
    exec(
      http("saving itineraries using saveAll in hashmap")
        .post("/itineraries/hashmap")
        .body(StringBody(session => itinerariesAsJson)).asJson)
  }

  def saveAllItinerariesInHashmapUsingPipeline(itinerariesAsJson: String): ChainBuilder = {
    exec(
      http("saving itineraries using saveAll in hashmap with pipeline")
        .post("/itineraries/hashmap/pipeline")
        .body(StringBody(session => itinerariesAsJson)).asJson)
  }

  def findAllItinerariesInHashmap(hashesAsJson: String): ChainBuilder = {
    exec(
      http("finding itineraries in hashmap using findAll")
        .post("/findAll/hashmap")
        .body(StringBody(session => hashesAsJson)).asJson)
  }

  def deleteAllItineraries(): ChainBuilder = {
    exec(
      http("Deleting all itineraries")
        .delete("/itineraries"))
  }
}
