package com.sgeorgiev24.productbrowser.provider.database.util

suspend fun <T> safeDatabaseCall(
    databaseCall: suspend () -> T
): Result<T> {
    return try {
        Result.success(databaseCall())
    } catch (e: Exception) {
        Result.failure(e)
    }
}