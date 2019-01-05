rootProject.name = "cours-jee-3-server-views"

include("server-views-java", "server-views-kotlin")
includeIfExists(projectName = "tp-display-quote-v1-java")
includeIfExists(projectName = "tp-display-quote-v1-kotlin")

fun includeIfExists(projectName: String) {
    if (file(projectName).exists()) {
        include(projectName)
    }
}
