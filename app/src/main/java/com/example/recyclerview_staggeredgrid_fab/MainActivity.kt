package com.example.recyclerview_staggeredgrid_fab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.string.note1))
        items.add(Tarjeta(R.string.note2))
        items.add(Tarjeta(R.string.note3))
        items.add(Tarjeta(R.string.note4))
        items.add(Tarjeta(R.string.note5))
        items.add(Tarjeta(R.string.note6))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        /*recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)*/
        recView.setLayoutManager(StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL))

        adaptador.onClick = {
            Toast.makeText(this@MainActivity, ""+ recView.getChildAdapterPosition(it), Toast.LENGTH_LONG).show()
        }

        recView.itemAnimator = DefaultItemAnimator()


    }
}
