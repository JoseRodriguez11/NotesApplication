package models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "notes_tbl")
@Parcelize
@Serializable
data class Notes(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title:String = "",
    val note:String = "",
    val favorite:Boolean = false,
    val date:String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
) : Parcelable
