package com.romoura.forum.exceptions

open class ForumException(
    override val message: String
) : RuntimeException(message)

open class ForumNotFoundException(
    override val message: String
) : ForumException(message)