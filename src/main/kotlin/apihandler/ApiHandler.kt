package apihandler

import com.google.gson.JsonArray
import com.google.gson.JsonParser
import common.API_TOKEN
import common.YOUTRACK_URL
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object ApiHandler {
    val client: HttpClient = HttpClient.newHttpClient()

    fun getListOfIssues(): JsonArray {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${YOUTRACK_URL}api/issues?fields=id,summary,description,reporter(login)"))
            .header("Authorization", "Bearer $API_TOKEN")
            .header("Accept", "application/json")
            .header("Cache-Control", "no-cache")
            .header("Content-Type", "application/json")
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return JsonParser.parseString(response.body()).asJsonArray
    }

    fun deleteAllIssues() {
        this.getListOfIssues().forEach {
            if (it.asJsonObject.get("summary").asString.startsWith("QA")) {
                val request = HttpRequest.newBuilder()
                    .uri(URI.create("${YOUTRACK_URL}api/issues/${it.asJsonObject.get("id").asString}"))
                    .header("Authorization", "Bearer $API_TOKEN")
                    .header("Accept", "application/json")
                    .header("Cache-Control", "no-cache")
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build()
                client.send(request, HttpResponse.BodyHandlers.ofString())
            }
        }
    }
}
