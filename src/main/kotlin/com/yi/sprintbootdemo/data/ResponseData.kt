package com.yi.sprintbootdemo.data

import com.yi.sprintbootdemo.exception.CustomException
import org.springframework.http.HttpStatus

data class ResponseData<T>(val code: Int, val message: String, val data: T) {
    companion object {
        fun <T> success(data: T? = null) = ResponseData(HttpStatus.OK.value(), HttpStatus.OK.reasonPhrase, data)
        fun <T> fail(
            code: Int = CustomException.COMMON_EXCEPTION,
            message: String = HttpStatus.PRECONDITION_FAILED.reasonPhrase,
            data: T? = null
        ) = ResponseData(code, message, data)
    }
}
