package com.example.project_aol_se.utils

object BotResponse {

    fun basicResponse(_message: String) : String{

        val random =  (0..2).random()
        var kalimatSapaan= arrayOf("halo", "hai", "hay","selamat","senang","bertemu")
        var tanyaCuaca= arrayOf("cuaca", "suasana", "musim","suhu")
        var tanyaPertanian = arrayOf("teknologi", "pertanian")
        var tanyaPengairan = arrayOf("kelembapan tanah", "pengairan", "tanah", "peraliran air")
        var tanyaVariety = arrayOf("varietas padi", "jenis padi", "varietas beras", "jenis beras")
        var kalimatThx = arrayOf("terima kasih", "trims", "thank you", " thanks", "tengs", "makasih")

        val message = _message.lowercase()

        var flagSapa = false
        var flagCuaca = false
        var flagPertanian = false
        var flagPengairan = false
        var flagVariety = false
        var flagThx = false

        for(i in kalimatSapaan){
            if(message.contains(i)){
                flagSapa = true
            }
        }

        for(i in tanyaCuaca){
            if(message.contains(i)){
                flagCuaca = true
            }
        }

        for(i in tanyaPertanian){
            if(message.contains(i)){
                flagPertanian = true
            }
        }

        for(i in tanyaPengairan){
            if(message.contains(i)){
                flagPertanian = true
            }
        }

        for(i in tanyaVariety){
            if(message.contains(i)){
                flagVariety = true
            }
        }

        for(i in kalimatThx){
            if(message.contains(i)){
                flagThx = true
            }
        }

        return when{
            flagSapa == true -> {
                when(random){
                    0 -> "Halo juga"
                    1 -> "Senang bertemu dengan mu"
                    2 -> "Hai di sana"
                    else -> "error"
                }
            }

            flagCuaca == true -> {
                when(0){
                    0 -> "Berdasarkan data BMKG, suhu tertinggi di Bekasi pada bulan Mei mencapai sekitar 34-35 derajat Celsius. Cuaca panas yang melanda Bekasi disebabkan peralihan musim dan awal musim kemarau yang membuat kondisi cuaca menjadi lebih cerah dan terik, khususnya pada siang hari."
                    else -> "error"
                }
            }

            flagPertanian == true -> {
                when(0){
                    0 -> "Teknologi pertanian seperti IoT dan AI dapat membantu memantau kondisi pertanian beras secara real-time."
                    else -> "error"
                }
            }

            flagPengairan == true -> {
                when(0){
                    0 -> " Pengaturan pengairan di daerahmu yang tepat sangat penting untuk menghindari kekeringan atau genangan."
                    else -> "error"
                }
            }

            flagVariety == true -> {
                when(0){
                    0 -> "Memilih jenis padi yang cocok dengan kondisi tanah dan iklim sangat penting. Jenis padi yang masuk dalam list rekomendasi adalah padi wangi, padi pera, dan padi pulen."
                    else -> "error"
                }
            }

            flagThx == true -> {
                when(random){
                    0 -> "Tidak masalah! Beritahu kami jika kamu masih memiliki pertanyaan."
                    1 -> "Senang bisa membantumu!"
                    2 -> "Sama-sama, hubungi kami kembali ya jika bingung!"
                    else -> "error"
                }
            }

            else -> {
                when(random){
                    0 -> "Saya tidak memahami apa pesan Anda"
                    1 -> "Aku tidak mengerti, silakan ketik permintaan kamu kembali"
                    2 -> "Sepertinya pertanyaanmu belum bisa aku pahami, coba yang lain"
                    else -> "error"
                }
            }
        }
    }
}