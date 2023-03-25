//package com.exemple.movie
//
//import android.content.SharedPreferences
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatDelegate
//import androidx.appcompat.widget.SwitchCompat
//
//class SettingFragment : Fragment() {
//
//    private lateinit var switchCompat: SwitchCompat
//
//    private lateinit var sharedPreferences: SharedPreferences
//    lateinit var binding: SettingFragment
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//
//        val booleanValue = sharedPreferences.getBoolean("night_mode", true)
//        if (booleanValue) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            switchCompat.isChecked = true
//        }
//        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                switchCompat.isChecked = true
//                val editor: SharedPreferences.Editor = sharedPreferences.edit()
//                editor.putBoolean("night_mode", true)
//                editor.apply()
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                switchCompat.isChecked = false
//                val editor: SharedPreferences.Editor = sharedPreferences.edit()
//                editor.putBoolean("night_mode", false)
//                editor.apply()
//            }
//        }
//        val view = inflater.inflate(R.layout.setting_fragment, container, false)
//        return view
//    }
//
//
//}