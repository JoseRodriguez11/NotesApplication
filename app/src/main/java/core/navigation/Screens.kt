package core.navigation

import kotlinx.serialization.Serializable
import models.Notes

@Serializable
object MainScreen

@Serializable
data class Note(val notes: Notes)