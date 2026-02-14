# News Feed Simulator

## Deskripsi Proyek
News Feed Simulator adalah aplikasi Android sederhana yang dibuat menggunakan Kotlin untuk mensimulasikan feed berita secara realtime.  
Aplikasi ini memanfaatkan Kotlin Flow dan Coroutines untuk mengelola aliran data asynchronous serta StateFlow untuk state management.

---

## Implementasi yang Digunakan

### 1. Flow
- Menggunakan `flow {}` sebagai Flow builder
- Menggunakan `emit()` untuk mengirim data berita setiap 2 detik
- Menggunakan `collect()` untuk menerima data

### 2. Flow Operators
- `filter()` → Menyaring berita berdasarkan kategori "Tech"
- `map()` → Mengubah format data sebelum ditampilkan
- `onEach()` → Menjalankan aksi tambahan setiap berita diterima
- `catch()` → Menangani error pada Flow

### 3. StateFlow
- Menggunakan `MutableStateFlow` untuk menghitung jumlah berita yang telah dibaca
- Data ditampilkan ke UI menggunakan `collectAsState()`

### 4. Coroutines
- Menggunakan `LaunchedEffect`
- Menggunakan `async` dan `await`
- Menggunakan `delay()` untuk simulasi asynchronous task

---

## Cara Menjalankan Aplikasi

1. Clone repository dari GitHub:

2. Buka project menggunakan Android Studio.

3. Tunggu proses Gradle Sync selesai.

4. Jalankan aplikasi:
- Pilih emulator atau hubungkan perangkat Android.
- Klik tombol Run (▶).

5. Aplikasi akan menampilkan berita kategori Tech yang muncul setiap 2 detik, serta jumlah berita yang telah dibaca.

## Struktur Proyek
- `MainActivity.kt` → Berisi implementasi Flow, Operators, StateFlow, dan Coroutines
- `README.md` → Dokumentasi proyek

## Teknologi
- Kotlin
- Kotlin Flow
- Coroutines
- Jetpack Compose
- StateFlow
