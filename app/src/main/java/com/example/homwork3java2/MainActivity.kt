package com.example.homwork3java2

import android.app.backup.SharedPreferencesBackupHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.fragment.NavHostFragment
import com.example.homwork3java2.utlis.PreferencesHelper
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {

    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (preferencesHelper.isShownOnBoard) {
                navGraph.setStartDestination(R.id.homeFragment)
            } else {
                navGraph.setStartDestination(R.id.viewPagerFragment)
            }

            navController.graph = navGraph
        }
    }
}