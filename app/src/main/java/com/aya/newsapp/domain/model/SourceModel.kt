package com.aya.newsapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SourceModel (
    val id : String?,
    var name : String
) 