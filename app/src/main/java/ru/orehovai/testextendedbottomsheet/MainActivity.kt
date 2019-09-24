package ru.orehovai.testextendedbottomsheet

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ru.orehovai.testextendedbottomsheet.ui.notifications.NotificationsFragment
import ru.orehovai.testextendedbottomsheet.ui.dashboard.DashboardFragment
import android.view.View
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val bottomSheet: View = findViewById(R.id.bottomSheet)
        val sheetBehavior = BottomSheetBehavior.from(bottomSheet)


        navView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_home -> {
                    sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    NavigationUI.onNavDestinationSelected(it, navController)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    sheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                    NavigationUI.onNavDestinationSelected(it, navController)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    NavigationUI.onNavDestinationSelected(it, navController)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
//        val mOnNavigationItemSelectedListener =
//            object : BottomNavigationView.OnNavigationItemSelectedListener {
//
//                override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                    when (item.getItemId()) {
//                        R.id.navigation_home -> {
//                            loadFragment(HomeFragment.newInstance())
//                            return true
//                        }
//                        R.id.navigation_dashboard -> {
//                            loadFragment(DashboardFragment.newInstance())
//                            return true
//                        }
//                        R.id.navigation_notifications -> {
//                            loadFragment(NotificationsFragment.newInstance())
//                            return true
//                        }
//                    }
//                    return false
//                }
//            }

    }
}
