package id.ihwan.jetpackpro.data.source.remote.network.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

class ResponseData (
    val total_pages: Int? = 0,
    val results: List<ResultsData>? = emptyList()
)

@Entity(tableName = "favorite_table")
@Parcelize
data class ResultsData(
    @PrimaryKey
    val id: Int? = 0 ,
    val title: String? = "",
    val name: String? = "",
    val vote_average: String? = "",
    val popularity: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val overview: String? = "",
    val release_date: String? = ""
): Parcelable