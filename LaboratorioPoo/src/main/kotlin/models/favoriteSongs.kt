package models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class favoriteSongs(val year: String, val country: String, val region: String, val artisName: String,  val song: String,  val artisGender: String,  val groupOrSolo: String,  val place: String,  val points: String,  val isFinal: String,  val isSongInEnglish: String,  val songQuality: String,  val normalizedPoints: String,  val energy: String,  val duratino: String,  val acousticness: String,  val danceability: String,  val tempo: String,  val speechness: String,  val key: String,  val liveness: String,  val timeSignature: String,  val mode: String,  val loudness: String,  val valence: String,  val happiness: String) {
    class favoriteSongsArrayDeserializer: ResponseDeserializable<Array<favoriteSongs>> {
        override fun deserialize(content: String): Array<favoriteSongs>? {
            return Gson().fromJson(content, Array<favoriteSongs>::class.java)
        }
    }
}