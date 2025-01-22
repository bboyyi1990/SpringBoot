package com.yi.sprintbootdemo.exception

import com.yi.sprintbootdemo.data.ResponseData
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(
        e: Exception, request: HttpServletRequest, response: HttpServletResponse
    ): ResponseData<Any?> {
        "GlobalExceptionHandler: ${e.message}"
        if (e is CustomException) return ResponseData(e.code, "${e.message}", e.data)
        else return ResponseData(
            INTERNAL_SERVER_ERROR.value(), "${INTERNAL_SERVER_ERROR.reasonPhrase}: ${e.message}", null
        )
    }
}
