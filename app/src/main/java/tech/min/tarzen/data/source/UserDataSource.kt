package tech.min.tarzen.data.source

import tech.min.tarzen.data.model.User

interface UserDataSource {
    suspend fun getUsers() : List<User>
}
