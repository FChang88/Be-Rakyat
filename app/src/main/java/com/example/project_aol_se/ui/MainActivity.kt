package com.example.project_aol_se.ui


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.project_aol_se.R
import com.example.project_aol_se.databinding.ActivityMainBinding
import com.example.project_aol_se.databinding.FragmentAllCategoryPageBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        replaceFragment(homePage()) //init

        binding.imageView8.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(BeSmartPage())
        }

        binding.tombolBelanjaPage.setOnClickListener{
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
//            binding.imageView8.visibility = View.VISIBLE
            replaceFragment(homePage())
        }
        binding.button7.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
//            binding.imageView8.visibility = View.VISIBLE
            replaceFragment(homePage())
        }

        binding.tombolTransaksiPage.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(TransaksiPage())
        }

        binding.button11.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(TransaksiPage())
        }

        binding.tombolBesmartPage.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(BeSmartPage())
        }

        binding.button8.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(BeSmartPage())
        }

        binding.tombolBelajarPage.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(BeLajarPage())
        }
        binding.tombolProfilPage.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(profilePage())
        }
        binding.button10.setOnClickListener {
            val fm: FragmentManager = getSupportFragmentManager()
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
            replaceFragment(profilePage())
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerFragment,fragment)
        fragmentTransaction.commit()
    }

    private var back_pressed : Long = 0
    private var backToast : Toast? = null


    override fun onBackPressed() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 0) {
            Log.i("MainActivity", "popping backstack")
            fm.popBackStack()
        }else{
            if (back_pressed + 3000 > System.currentTimeMillis()) {
                super.onBackPressed()
                backToast?.cancel()
                finishAffinity()
                MainActivity().finish()
                ActivityCompat.finishAffinity(this);
                System.out.close()
            }else {
                backToast = Toast.makeText(getApplicationContext(), "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT)
                val back_Toast = backToast
                back_Toast?.show()
            }
            back_pressed = System.currentTimeMillis()
        }


    }

}