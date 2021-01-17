@file:Suppress("DEPRECATION")

package com.example.kit3.view

import android.os.Bundle
import android.preference.PreferenceFragment
import androidx.preference.PreferenceFragmentCompat
import com.example.kit3.R


class SharedPrefFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.shared_pref, rootKey)
    }
}