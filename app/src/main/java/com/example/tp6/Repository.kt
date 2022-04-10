package com.example.tp6


import android.net.http.HttpResponseCache.install
import androidx.room.Room
import com.example.tp6.Repository.Singleton.breaking
import com.example.tp6.Repository.Singleton.db
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import java.util.*

class Repository {
    object Singleton {
        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "characters-db"
        ).build()

        val breaking = ArrayList<Characters>()

        private fun startNetworkCall() {
            val client = HttpClient(CIO) {
                install(JsonFeature){
                    serializer = GsonSerializer()
                }
            }
            val elmnt: List<Characters> = client.get("https://www.breakingbadapi.com/api/characters").body()

        }
    }

    GlobalScope.launch {
        db.charactersDao().insertAll(elmnt.forEach{Characters(it)})
        val data = db.charactersDao().getAll()

        data?.forEach {
            if (it!=null){
                breaking.add(it)
            }
        }
    }


}