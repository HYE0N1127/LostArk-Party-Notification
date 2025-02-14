package com.hyeonbin.lostark_party_notification

import java.lang.Exception

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception, val message: String): Result<Nothing>()
    data object Loading: Result<Nothing>()
}