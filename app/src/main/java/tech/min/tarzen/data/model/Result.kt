package tech.min.tarzen.data.model

import retrofit2.HttpException

enum class ErrorType(val code: Int) {
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    UNKNOWN(-1);
    companion object{
        fun getErrorStatus(code: Int) = values().find { it.code == code } ?: UNKNOWN
    }
}

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>() {
        override fun toString(): String {
            return super.toString()
        }
    }

    data class Error(val error: Throwable) : Result<Nothing>(){
        val errorType: ErrorType
        get() = when(error){
            is HttpException -> ErrorType.getErrorStatus(error.code())
            else -> ErrorType.UNKNOWN
        }
        val message: String
        get() = when(error){
            is HttpException -> error.message()
            else -> error.localizedMessage ?: "Unknown error."
        }
        override fun toString(): String {
            return super.toString()
        }
    }

    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[status=${errorType} exception=${error}]"
            else -> "Loading"
        }
    }

}
