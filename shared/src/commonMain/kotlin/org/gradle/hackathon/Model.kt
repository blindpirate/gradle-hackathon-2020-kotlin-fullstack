package org.gradle.hackathon

import kotlinx.serialization.Serializable

@Serializable
data class Shape(
    val color: String,
    val width: Int,
    val height: Int
)


@Serializable
data class RequestParam(val number: Int)