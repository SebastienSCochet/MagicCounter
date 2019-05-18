package be.eden.magiccounter.util

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(val context: Context) {

    companion object {
        const val PREF_FILE_NAME = "PREFERENCES"
        private const val PREF_KEY_NAME_P1 = "PLAYER1_NAME"
        private const val PREF_KEY_NAME_P2 = "PLAYER2_NAME"
        private const val PREF_KEY_SCORE_MAX = "SCORE_MAX"
    }

    private val mPref: SharedPreferences

    init {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clear() {
        mPref.edit().clear().apply()
    }

    var player1Name: String
        get() = mPref.getString(PREF_KEY_NAME_P1, null)?:"Joueur 1"
        set(login) = mPref.edit().putString(PREF_KEY_NAME_P1, login).apply()

    var player2Name: String
        get() = mPref.getString(PREF_KEY_NAME_P2, null)?:"Joueur 2"
        set(login) = mPref.edit().putString(PREF_KEY_NAME_P2, login).apply()

    var maxScore: Int
        get() = mPref.getInt(PREF_KEY_SCORE_MAX, -1)
        set(max) = mPref.edit().putInt(PREF_KEY_SCORE_MAX, max).apply()

}