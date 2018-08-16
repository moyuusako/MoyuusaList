package com.moyuusa.moyuusalist

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(initListData())

        recyclerView = findViewById<RecyclerView>(R.id.view_recylclerlist).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

            fab.setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }
    }

    private fun initListData():List<RowData>{
        val list = mutableListOf<RowData>()
        // TODO: write in method or change to simple code
        RowData().also {
            it.iconID = R.mipmap.icon1
            it.title = getString(R.string.homepage)
            // 単にaddすれば後ろに増えていく
            list.add(it)
        }
        RowData().also {
            it.iconID = R.mipmap.icon1
            it.title = getString(R.string.behance)
            list.add(it)
        }
        RowData().also {
            it.iconID = R.mipmap.icon1
            it.title = getString(R.string.profile_usa)
            list.add(it)
        }

        return list
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
