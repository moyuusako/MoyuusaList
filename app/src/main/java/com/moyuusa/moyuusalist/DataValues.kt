package com.moyuusa.moyuusalist

class DataValues{
    // rowごとに読み込むものをまとめたい
    // companion object: class内でJavaでいうprivate staticを実現
    // クラスによらない定数を置きたい場合はtop-levelに書く
    companion object {
        const val URL_MOYUUSITE: String = "https://moyuusa.com/"
        val URL_BEHANCE: String =""
        val ACTIVITY_PROF: String = "ProfActivity"
    }

}