package tech.min.tarzen.data.model

import com.squareup.moshi.Json

data class User(val name: String?, val email: String?, @Json(name = "thumbnail_url") val imageUrl: String?)