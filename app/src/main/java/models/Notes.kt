package models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Notes(
    val title:String = "",
    val note:String = "",
    val favorite:Boolean = false
) : Parcelable
