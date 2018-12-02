package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daftmobile.android4beginners4.robots.viewmodel.ExternalSourceRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.LiveDataRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel
import kotlinx.android.synthetic.main.activity_robots.*
class RobotsActivity : AppCompatActivity() {
    private lateinit var viewModel: RobotsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots)

        viewModel=ViewModelProviders.of(this).get(ExternalSourceRobotsViewModel::class.java)//ten madry viewmodel, ze jak oracamy i nowe activity to satar zawartosc ekranu
        //wczesniej byo LiveDataRobotsViewModel

        //viewModel = LiveDataRobotsViewModel()//glupi viewmodel
        viewModel.getRobotList().observe(this, Observer{
            robotTextView.text=it
        })

        addRobotFab.setOnClickListener {
            addNewItem()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.robots_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //when(item.Itemid)
        return super.onOptionsItemSelected(item)
    }

    private fun addNewItem() {
        viewModel.addRobot()
    }
}
