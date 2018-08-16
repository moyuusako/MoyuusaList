package com.moyuusa.moyuusalist


class DataValues{
    // rowごとに読み込むものをまとめたい
    // companion object: class内でJavaでいうprivate staticを実現
    // クラスによらない定数を置きたい場合はtop-levelに書く
    companion object {
        const val URL_MOYUUSITE: String = "https://moyuusa.com/"
        const val URL_BEHANCE: String =""
        const val ACTIVITY_PROF: String = "ProfActivity"
        const val URL_INSTA: String="https://instagram.com/moyuusa_chan/"

        const val ID_HOMEPAGE:Int = 0
        const val ID_BEHANCE:Int = 1
        const val ID_PROFILE: Int = 2
        const val ID_INSTA: Int = 3

        val CON_TEXT_LIST = listOf(
                R.string.homepage,
                R.string.behance,
                R.string.profile_usa,
                R.string.instagram)
        val CON_ICON_LIST = listOf(
                R.mipmap.icon1,
                R.mipmap.icon1,
                R.mipmap.icon1,
                R.mipmap.icon1)
    }

}