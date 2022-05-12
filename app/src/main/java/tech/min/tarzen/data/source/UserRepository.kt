package tech.min.tarzen.data.source

import kotlinx.coroutines.flow.Flow
import tech.min.tarzen.data.model.Result
import tech.min.tarzen.data.model.User

interface UserRepository {
    suspend fun getUsers(): Flow<Result<List<User>>>
}
