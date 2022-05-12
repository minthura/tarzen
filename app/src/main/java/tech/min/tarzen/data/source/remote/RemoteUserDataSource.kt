package tech.min.tarzen.data.source.remote

import tech.min.tarzen.data.model.User
import tech.min.tarzen.data.source.UserDataSource
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(
    private val userService: UserService
): UserDataSource {
    override suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }
}