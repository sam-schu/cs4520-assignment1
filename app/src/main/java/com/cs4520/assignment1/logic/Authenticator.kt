package com.cs4520.assignment1.logic

class Authenticator {
    private data class AuthenticationPair(private val username: String,
                                          private val password: String)

    private companion object {
        val ALLOWED_CREDENTIALS = listOf(AuthenticationPair("admin", "admin"))
    }

    fun authenticate(username: String, password: String): Boolean =
        ALLOWED_CREDENTIALS.contains(AuthenticationPair(username, password))
}