package com.exemple.movie

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.exemple.movie.databinding.SettingFragmentBinding

class SettingsFragment : Fragment() {


    private lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: SettingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=SettingFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        sharedPreferences = requireActivity().getSharedPreferences("night", 0)
        val booleanValue = sharedPreferences.getBoolean("night_mode", true)
        if (booleanValue) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
          binding.switchCompat.isChecked = true
        }
        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switchCompat.isChecked = true
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("night_mode", true)
                editor.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switchCompat.isChecked = false
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("night_mode", false)
                editor.apply()
            }
        }
    }


}




//package com.exemple.movie
//
//import android.annotation.SuppressLint
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatDelegate
//import androidx.appcompat.widget.SwitchCompat
//import androidx.fragment.app.Fragment
//import com.exemple.movie.databinding.SettingFragmentBinding
//
//
//class SettingsFragment : Fragment() {
//    private lateinit var switchCompat: SwitchCompat
//    private lateinit var sharedPreferences: SharedPreferences
//    lateinit var binding: SettingFragmentBinding
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        sharedPreferences = getSharedPreferences("night", 0)
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
//
//    }
//}


