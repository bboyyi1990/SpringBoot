package com.yi.sprintbootdemo

import org.slf4j.LoggerFactory

object Logger {
    private fun canLog(): Boolean = true
    private val logger by lazy { LoggerFactory.getLogger(Logger.javaClass) }
    fun e(message: String) {
        if (canLog()) {
            logger.error(message)
        }
    }

    fun d(message: String) {
        if (canLog()) {
            logger.debug(message)
        }
    }
}

fun String.logE() = Logger.e(this)
fun String.logD() = Logger.d(this)
