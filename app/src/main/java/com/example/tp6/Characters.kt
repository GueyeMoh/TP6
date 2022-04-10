package com.example.tp6



import androidx.room.Entity
import java.util.*
@Entity
data class Characters(
    @PrimaryKey var id:Int = 0,
    @ColumnInfo(name ="nom") var name: String? = null,
    @ColumnInfo(name ="birthday") var birthday: String? =null,
    @ColumnInfo(name ="occupation") var occupation: ArrayList<String>? = null,
    @ColumnInfo(name ="image") var img: String? = null,
    @ColumnInfo(name ="status") var status:String? = null,
    @ColumnInfo(name ="nickname") var nickname: String? = null,
    @ColumnInfo(name ="protrayed") var pratrayed: String? = null,
    @ColumnInfo(name ="appearance") var appearance: ArrayList<String>? = null,
    @ColumnInfo(name ="category") var category: ArrayList<String>? = null
)



