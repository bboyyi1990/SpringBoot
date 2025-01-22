package com.yi.sprintbootdemo.exception

class CustomException(val code: Int = COMMON_EXCEPTION, message: String?, val data: Any? = null) : Exception(message) {
    companion object {
        const val COMMON_EXCEPTION = 2025
    }
}
