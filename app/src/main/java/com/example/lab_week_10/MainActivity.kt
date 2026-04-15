package com.example.lab_week_10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast // <-- IMPORT BARU
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.lab_week_10.database.Total
import com.example.lab_week_10.database.TotalDatabase
import com.example.lab_week_10.database.TotalObject // <-- IMPORT BARU
import com.example.lab_week_10.viewmodels.TotalViewModel
import java.util.Date // <-- IMPORT BARU

class MainActivity : AppCompatActivity() {

    private val db by lazy { prepareDatabase() }

    private val viewModel by lazy {
        ViewModelProvider(this)[TotalViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeValueFromDatabase()
        prepareViewModel()
    }

    override fun onStart() {
        super.onStart()
        val totalList = db.totalDao().getTotal(ID)
        if (totalList.isNotEmpty()) {
            val lastUpdateDate = totalList.first().total.date // [cite: 507]
            Toast.makeText(this, lastUpdateDate, Toast.LENGTH_LONG).show()
        }
    }

    private fun updateText(total: Int) {
        findViewById<TextView>(R.id.text_total).text =
            getString(R.string.text_total, total)
    }

    private fun prepareViewModel(){
        viewModel.total.observe(this, {
            updateText(it)
        })
        findViewById<Button>(R.id.button_increment).setOnClickListener {
            viewModel.incrementTotal()
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.total.value?.let { currentValue ->
            val currentDate = Date().toString() //
            val totalObject = TotalObject(value = currentValue, date = currentDate)
            db.totalDao().update(Total(id = ID, total = totalObject))
        }
    }

    private fun prepareDatabase(): TotalDatabase {
        return Room.databaseBuilder(
            applicationContext,
            TotalDatabase::class.java, "total-database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    private fun initializeValueFromDatabase() {
        val totalList = db.totalDao().getTotal(ID)
        if (totalList.isEmpty()) {
            val firstRunObject = TotalObject(value = 0, date = Date().toString())
            db.totalDao().insert(Total(id = ID, total = firstRunObject))
            viewModel.setTotal(0)
        } else {
            viewModel.setTotal(totalList.first().total.value)
        }
    }

    companion object {
        const val ID: Long = 1
    }
}