package com.jacobconner.conference.domain

data class Section(
    val title: String,
    val note: String,
    val Urls: List<URL>,
    val subSection: List<Section>?
)