package com.example.flowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : ComponentActivity() {

    private val _readCount = MutableStateFlow(0)
    private val readCount = _readCount.asStateFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsScreen()
        }
    }

    @Composable
    fun NewsScreen() {

        var currentNews by remember { mutableStateOf("Menunggu berita...") }
        val count by readCount.collectAsState()

        LaunchedEffect(Unit) {

            val categories = listOf("Tech", "Sports", "Health")

            val newsFlow = flow {
                var id = 1
                while (true) {
                    delay(2000)

                    val category = categories.random()

                    emit(Triple(id, category, "Judul berita menarik"))
                    id++
                }
            }

                .filter { news ->
                    news.second == "Tech"
                }

                .map { news ->
                    "[${news.second}] Berita ke-${news.first}: ${news.third}"
                }
                .onEach { news ->
                    println("Berita diterima: $news")
                }
                .catch {
                    emit("Terjadi kesalahan mengambil berita")
                }

            newsFlow.collect { news ->

                currentNews = news

                val detail = async {
                    delay(1000)
                    "Detail lengkap berita"
                }

                detail.await()

                _readCount.value++
            }
        }

        Column {
            Text(text = currentNews)
            Text(text = "Jumlah berita dibaca: $count")
        }
    }
}
