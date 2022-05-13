package tech.min.tarzen.data.source.local

import tech.min.tarzen.data.model.User
import tech.min.tarzen.data.source.UserDataSource
import javax.inject.Inject

class LocalUserDataSource @Inject constructor(): UserDataSource {
    override suspend fun getUsers(): List<User> {
        return listOf(User("Tony", "tony@stark.com", "null"))
    }
}
