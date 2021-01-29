package com.example.songs

import com.example.songs.Model.ResultSongs
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.songs.Adapter.SongListAdapter
import com.example.songs.ViewModel.SonglistModelView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: SongListAdapter
    lateinit var list:List<ResultSongs>

    private lateinit var searchView: SearchView
    lateinit   var viewModel: SonglistModelView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        adapter= SongListAdapter(mutableListOf())
        recyclerView.adapter=adapter
        searchView= findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        if (p0 != null) {
                            viewModel.makeSearchApiCall(p0,applicationContext)
                        }

                        return false
                    }

                    override fun onQueryTextChange(p0: String?): Boolean {
                        if (p0 != null) {

                            viewModel.makeSearchApiCall(p0,applicationContext)
                        }

                        return false
                    }

                }
        )
        viewModel= ViewModelProvider(this).get(SonglistModelView::class.java)
        viewModel.DataObserver().observe(this, { t ->
            if(t!=null) {
                list = t

                adapter.setList(t)
                Log.v("size", t.size.toString())
            }

        })
        

    }




}
