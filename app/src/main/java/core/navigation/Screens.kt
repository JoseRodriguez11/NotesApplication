package core.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
data class Note(val title:String , val note:String)