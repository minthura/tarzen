package tech.min.tarzen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import tech.min.tarzen.data.source.UserRepository
import tech.min.tarzen.data.model.Result
import tech.min.tarzen.data.model.User
import tech.min.tarzen.ui.main.MainViewModel
import tech.min.tarzen.utils.MainCoroutineRule

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private val userRepository: UserRepository = mockk()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testOnGetUsers(): Unit = runBlocking {
        coEvery { userRepository.getUsers() } returns flow {
            emit(Result.Success(listOf(User("A", "B"))))
        }
        val vm = MainViewModel(userRepository, mainCoroutineRule.testDispatcher)
        vm.onGetUsers()
        assert(vm.users.value.isNotEmpty())
    }

}
