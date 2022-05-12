package tech.min.tarzen.data.source

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tech.min.tarzen.data.model.Result
import tech.min.tarzen.data.model.User
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val userDataSource: UserDataSource,
    private val dispatcher: CoroutineDispatcher,
): UserRepository {

    override suspend fun getUsers(): Flow<Result<List<User>>> {
        return flow {
            emit(Result.Loading)
            emit(Result.Success(userDataSource.getUsers()))
        }.catch {
            emit(Result.Error(it))
        }.flowOn(dispatcher)
    }

}
