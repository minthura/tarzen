package tech.min.tarzen.data.source.remote

import retrofit2.http.GET
import tech.min.tarzen.data.model.User

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}