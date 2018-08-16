package com.moyuusa.moyuusalist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

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
        viewAdapter = MyAdapter(initListData(), object :MyAdapter.OrgClickListener{
            override fun onClick(view: View, id: Int) {

                //test
                var toastMsg : Int
                when(id){
                    DataValues.ID_HOMEPAGE -> {
                        // open url
                        val uri : Uri = Uri.parse(DataValues.URL_MOYUUSITE)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)
                        toastMsg = DataValues.CON_TEXT_LIST[DataValues.ID_HOMEPAGE]
                    }
                    DataValues.ID_BEHANCE -> {
                        toastMsg = DataValues.CON_TEXT_LIST[DataValues.ID_BEHANCE]
                    }
                    DataValues.ID_PROFILE ->{
                        toastMsg = DataValues.CON_TEXT_LIST[DataValues.ID_PROFILE]
                    }
                    DataValues.ID_INSTA -> {
                        val uri : Uri = Uri.parse(DataValues.URL_INSTA)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)
                        toastMsg = DataValues.CON_TEXT_LIST[DataValues.ID_INSTA]
                    }
                    else ->{
                        toastMsg = R.string.app_name
                    }
                }
                Toast.makeText(this@MainActivity, toastMsg, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView = findViewById<RecyclerView>(R.id.view_recylclerlist).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter


        }
    }

    private fun initListData():List<RowData>{
        val list = mutableListOf<RowData>()
        // TODO: nullcheck, culc length
        for (i in 0..3){
            RowData().also {
                it.iconID = DataValues.CON_ICON_LIST[i]
                it.title = getString(DataValues.CON_TEXT_LIST[i])
                // 単にaddすれば後ろに増えていく
                list.add(it)
            }
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
