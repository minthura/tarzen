package tech.min.tarzen.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import tech.min.tarzen.data.source.UserRepository
import tech.min.tarzen.data.model.Result
import tech.min.tarzen.data.model.User
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    val showToast = MutableSharedFlow<String?>()
    val users = MutableStateFlow<List<User>>(emptyList())

    fun onGetUsers() = viewModelScope.launch(dispatcher) {
        userRepository.getUsers()
            .onEach {
                Timber.d("$it")
                when(it){
                    is Result.Loading -> showToast.emit("LOADING")
                    is Result.Error -> showToast.emit(it.message)
                    is Result.Success -> {
                        showToast.emit(it.data.firstOrNull()?.name)
                        users.value = it.data
                    }
                }
            }.collect()
    }

}
