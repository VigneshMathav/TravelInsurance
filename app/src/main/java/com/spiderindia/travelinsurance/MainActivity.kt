package com.spiderindia.travelinsurance

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.spiderindia.travelinsurance.common.TIBaseActivity
import com.spiderindia.travelinsurance.databinding.ActivityMainBinding

class MainActivity : TIBaseActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}