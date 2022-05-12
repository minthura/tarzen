package tech.min.tarzen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import tech.min.tarzen.data.source.UserDataSource
import tech.min.tarzen.data.model.Result
import tech.min.tarzen.data.model.User
import tech.min.tarzen.data.source.DefaultUserRepository
import tech.min.tarzen.utils.MainCoroutineRule
import java.lang.Exception

@ExperimentalCoroutinesApi
class UserRepositoryTest {

    private val userDataSource: UserDataSource = mockk()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun getUsersTestSuccess(): Unit = runTest {
        coEvery { userDataSource.getUsers() } returns listOf(User("A", "B"))
        val userRepository = DefaultUserRepository(
            userDataSource, mainCoroutineRule.testDispatcher
        )
        val result = userRepository.getUsers().first { it is Result.Success }
        assert(result is Result.Success)
    }

    @Test
    fun getUsersTestError(): Unit = runTest {
        coEvery { userDataSource.getUsers() } throws Exception("Unknown")
        val userRepository = DefaultUserRepository(
            userDataSource, mainCoroutineRule.testDispatcher
        )
        val result = userRepository.getUsers().first { it is Result.Error }
        assert(result is Result.Error)
    }

}
