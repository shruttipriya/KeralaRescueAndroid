package android.keralarescue.com.keralarescueandroid.ui.emergency_contacts

import android.content.Context
import android.content.Intent
import android.keralarescue.com.keralarescueandroid.R
import android.keralarescue.com.keralarescueandroid.ui.base.BaseActivity
import android.keralarescue.com.keralarescueandroid.util.firebase.FirebaseJavaManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.emergency_contacts_activity.*

class EmergencyContactsActivity: BaseActivity() {

    private lateinit var recyclerView: RecyclerView
    private var emergencyContactList = listOf<String>()
    private val viewAdapter: EmergencyContactAdapter = EmergencyContactAdapter(emergencyContactList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emergency_contacts_activity)
        recyclerView = emergency_contact_recycleview


        setUpActionBar()
        initRecycleView()
    }

    override fun onStart() {
        super.onStart()
        fetchContactSections()
    }

    ////////////////////////////////////////

    private fun setUpActionBar() {
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.emergency_contact)
    }

    private fun fetchContactSections() {
        FirebaseJavaManager.loadContactSections("contacts/sections") {

            viewAdapter.setSectionList(it as List<String>)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            adapter = viewAdapter
        }
    }

    ///////////////////////////////////////////

    companion object {
        fun getNewIntent(context: Context): Intent {
            return Intent(context, EmergencyContactsActivity::class.java)
        }
    }
}