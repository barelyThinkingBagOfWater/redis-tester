import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {

  val props = new GatlingPropertiesBuilder()
    .resourcesDirectory(IDEPathHelper.mavenResourcesDirectory.toString)
    .resultsDirectory(IDEPathHelper.resultsDirectory.toString)
    .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)
    .runDescription("Fake description to avoid the prompt each time")

  Gatling.fromMap(props.build)
}
