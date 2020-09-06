package com.notify.laywer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class ProcessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)
        //processnotify(email ?: "", provider ?: "")
        processnotify()
    }
    private fun processnotify(){
        title = "Procesos-Fases"
        //var database = Firebase.database();
        // val database = FirebaseDatabase.getInstance()
        //val myRef = database.getReference("payphone-b299f")

        //myRef.setValue("Hello, World!")

        //emailView.text = email
        //providerView.text = provider

        /*btnCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }*/
        /*myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)
               // Log.d(FragmentActivity.TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
               // Log.w(FragmentActivity.TAG, "Failed to read value.", error.toException())
            }
        })*/
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
