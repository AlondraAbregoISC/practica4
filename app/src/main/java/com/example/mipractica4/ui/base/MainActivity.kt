package com.example.mipractica4.ui.base

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mipractica4.R
import com.example.mipractica4.ui.view.bottomsheet.ZMRBottomSheetFragment
import com.example.mipractica4.ui.view.configuracion.FragmentConfiguration
import com.example.mipractica4.ui.view.helloWorld.HelloWorld
import com.example.mipractica4.ui.view.home.FragmentHome
import com.example.mipractica4.ui.view.lifeCycle.LifeCycle
import com.example.mipractica4.ui.view.location.UbicacionFragment
import com.example.mipractica4.ui.view.radioButton.RadioButtonFragment
import com.example.mipractica4.ui.view.recyclerView.RecyclerViewFragment
import com.example.mipractica4.ui.view.room.RoomFragment
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, FragmentConfiguration.FragmentConfigurationCallback {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    private var containerFragment: Fragment? = null

    private lateinit var ciHeader: CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PRUEBA", "Hola")

        initUI()
    }

    private fun initUI() {
        toolbar = findViewById(R.id.toolbar)
        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)


        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(toogle)
        toogle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        val headerView = navigationView.getHeaderView(0)
        ciHeader = headerView.findViewById(R.id.ciHeader)

        pushFragment(
                FragmentHome.getInstance(
                        null
                )!!, FragmentHome.TAG, false)

    }
    /**
     * escucha el return nativo del movil
     */
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
    /**
     * Inflar fragmentos a la activity
     */
    fun pushFragment(fragment: Fragment, tag:String?, backStack: Boolean ) {
        if(!isFinishing) {
            containerFragment = fragment
            val  ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frameLayout, containerFragment!!)

            if (backStack) {
                ft.addToBackStack(tag)
            }
            ft.commitAllowingStateLoss()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        when (id) {
            R.id.nav_home -> pushFragment(
                    FragmentHome.getInstance(
                            null
                    )!!, FragmentHome.TAG, false
                )
            R.id.nav_radio_button ->
                pushFragment(
                        RadioButtonFragment.getInstance(
                                null
                        )!!, RadioButtonFragment.TAG, false
                )
            R.id.nav_Life_Cycle ->
                pushFragment(
                        LifeCycle.getInstance(
                                null
                        )!!, LifeCycle.TAG, false
                )
            R.id.nav_Hola_Mundo ->
                pushFragment(
                        HelloWorld.getInstance(
                                null
                        )!!, HelloWorld.TAG, false
                )
            R.id.nav_recycler_View ->
                pushFragment(
                        RecyclerViewFragment.getInstance(
                                null
                        )!!, RecyclerViewFragment.TAG, false
                )
            R.id.nav_ubicacion ->
                pushFragment(
                    UbicacionFragment.getInstance(
                        null
                    )!!, UbicacionFragment.TAG, false
                )
            R.id.nav_interfaz ->
                pushFragment(
                    RoomFragment.getInstance(
                        null
                    )!!, RoomFragment.TAG, false
                )
            R.id.nav_configuration ->
                pushFragment(
                    FragmentConfiguration.getInstance(
                        null
                    )!!, FragmentConfiguration.TAG, false
                )
            R.id.nav_z_bottom ->
                pushFragment(
                    ZMRBottomSheetFragment.getInstance(
                        null
                    )!!, ZMRBottomSheetFragment.TAG, false
                )
            R.id.nav_maps ->
                startActivity(Intent(this, MapsActivity::class.java))

        R.id.nav_mi_ruta ->
        startActivity(Intent(this, MapsActivity2::class.java))
    }

        drawer.closeDrawer(GravityCompat.START) //Se cierra el drawer
        return true
    }

    override fun sendToActivity(byteArray: ByteArray) {
        if(byteArray != null && ciHeader != null){

            val picture = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            ciHeader.setImageBitmap(picture)

        }
    }
}