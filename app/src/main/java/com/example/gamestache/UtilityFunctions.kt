package com.example.gamestache

import com.example.gamestache.models.search_results.SearchResultsResponseItem
import java.net.URI

fun concatCoverUrl(imageHash: String): String = "https://images.igdb.com/igdb/image/upload/t_cover_big/${imageHash}.jpg"

fun massageCoverUrl(coverURL: String?): String {
    if (coverURL == null){
        return ""
    } else {
        val url = URI(coverURL)
        val segments = url.path.split("/")
        val lastSegment = segments[segments.size - 1]
        val imageHash = lastSegment.substring(0, (lastSegment.length - 4))
        return concatCoverUrl(imageHash)
    }
}

fun joinInfoListsToString(list: MutableList<String>?): String {
    list?.let { return list.joinToString(separator = ", ") }
        ?: run {return ""}
}

fun massageDataForListAdapter(gamesList: List<SearchResultsResponseItem?>): List<SearchResultsResponseItem?> {
    for (game in gamesList) {
        game?.cover?.url = game?.cover?.url?.let { massageCoverUrl(it) }.toString()

        val gameInfoListsMap = createStringMaps(game)

        game?.platformsToDisplay = joinInfoListsToString(gameInfoListsMap["platforms"])
        game?.genresToDisplay = joinInfoListsToString(gameInfoListsMap["genres"])
        game?.gameModesToDisplay = joinInfoListsToString(gameInfoListsMap["gameModes"])

    }
    return gamesList
}

fun createStringMaps(game: SearchResultsResponseItem?): Map<String, MutableList<String>> {
    val platformList = mutableListOf<String>()
    val genreList = mutableListOf<String>()
    val gameModesList = mutableListOf<String>()

    game?.platforms?.let { platforms ->
        for (platform in platforms) {
            platform?.name?.let { platformList.add(it) }
        }
    }

    game?.genres?.let { genres ->
        for (genre in genres) {
            genre?.name?.let { genreList.add(it) }
        }
    }

    game?.game_modes?.let { gameModes ->
        for (gameMode in gameModes) {
            gameMode?.name?.let { gameModesList.add(it) }
        }
    }

    return mapOf("platforms" to platformList, "genres" to genreList, "gameModes" to gameModesList)
}