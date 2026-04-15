[LAB_WEEK_13.txt](https://github.com/user-attachments/files/23900669/LAB_WEEK_13.txt)
Yehuda Suprato 00000091657
1. MVVM (Model-View-ViewModel) penting karena memisahkan UI (User Interface) dari logika bisnis (Business Logic). Hal ini membuat pengembang lebih mudah untuk menambahkan fitur baru atau melakukan testing pada kode yang sudah ada tanpa merusak komponen lain. Pola ini juga sangat berguna untuk aplikasi besar yang memiliki banyak data dan tampilan.
Representasi File dalam Project:
- Model: Merepresentasikan layer data. File-filenya meliputi Movie.kt (Entity), MovieDao.kt, MovieDatabase.kt, dan MovieRepository.kt.
- View: UI yang menampilkan data. File-filenya meliputi MainActivity.kt, activity_main.xml, dan RecyclerViewBinding.kt.
- ViewModel: Mengambil data dari Model dan menyediakannya untuk View. Filenya adalah MovieViewModel.kt.

2. Data Binding lebih efisien karena memungkinkan ViewModel untuk berkomunikasi langsung dengan Views (layout XML) tanpa perlu menggunakan findViewById atau metode pemanggilan view manual lainnya di dalam Activity.

3. Singleton Pattern penting untuk memastikan bahwa hanya ada satu instance database yang dibuat di seluruh thread aplikasi. Penting karena mencegah terjadinya Race Conditions (kondisi di mana dua thread mencoba mengakses/mengubah data bersamaan dan menyebabkan inkonsistensi).

4. Repository Pattern penting karena berfungsi sebagai jembatan untuk mensinkronisasi data aplikasi antara web service (API/Retrofit) dan database lokal (Room). Keuntungannya adalah Memastikan data di database lokal selalu up-to-date dengan data di web service.

5. Ya, ada cara lain. WorkManager digunakan untuk memperbarui data secara terjadwal bahkan ketika aplikasi sedang ditutup. Cara alternatif lain (yang mengharuskan aplikasi terbuka) adalah Lifecycle Methods (onCreate/onResume), User Action (Pull-to-Refresh), dan Push Notification (FCM)
