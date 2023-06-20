package pwr.lab.projekt_android_259313.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val eventName: String,
    val eventDescription: String,
    val eventDate: String,
)
