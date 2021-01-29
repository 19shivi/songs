package com.example.songs.Model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Songs")
data class ResultSongs (

        @SerializedName("wrapperType") val wrapperType : String?,
        @SerializedName("kind") val kind  : String?,
        @PrimaryKey  @SerializedName("trackId") val trackId : Int,
        @SerializedName("artistName") val artistName : String?,
        @SerializedName("trackName") val trackName : String?,
        @SerializedName("trackCensoredName") val trackCensoredName : String?,
        @SerializedName("trackViewUrl") val trackViewUrl : String?,
        @SerializedName("previewUrl") val previewUrl : String?,
        @SerializedName("artworkUrl30") val artworkUrl30 : String?,
        @SerializedName("artworkUrl60") val artworkUrl60 : String?,
        @SerializedName("artworkUrl100") val artworkUrl100 : String?,
        @SerializedName("collectionPrice") val collectionPrice : Double,
        @SerializedName("trackPrice") val trackPrice : Double,
        @SerializedName("trackRentalPrice") val trackRentalPrice : Double,
        @SerializedName("collectionHdPrice") val collectionHdPrice : Double,
        @SerializedName("trackHdPrice") val trackHdPrice : Double,
        @SerializedName("trackHdRentalPrice") val trackHdRentalPrice : Double,
        @SerializedName("releaseDate") val releaseDate : String?,
        @SerializedName("collectionExplicitness") val collectionExplicitness : String?,
        @SerializedName("trackExplicitness") val trackExplicitness : String?,
        @SerializedName("trackTimeMillis") val trackTimeMillis : Int,
        @SerializedName("country") val country : String?,
        @SerializedName("currency") val currency : String?,
        @SerializedName("primaryGenreName") val primaryGenreName : String?,
        @SerializedName("contentAdvisoryRating") val contentAdvisoryRating : String?,
        @SerializedName("shortDescription") val shortDescription : String?,
        @SerializedName("longDescription") val longDescription : String?
)