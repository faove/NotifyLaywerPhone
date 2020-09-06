package com.notify.laywer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home.*
import java.time.temporal.ValueRange


enum class ProviderType{
    BASIC
}


class HomeActivity : AppCompatActivity() {

    lateinit var read_single_text: TextView

    // [START declare_database_ref]
    //private lateinit var database: DatabaseReference
    
    //private lateinit var binding: ActivityNewPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // [START initialize_database_ref]
        //database = Firebase.database.reference
        // val database = FirebaseDatabase.getInstance()
        //database = FirebaseDatabase.getInstance().getReference("notifylaywer")
        // [END initialize_database_ref]

        //read_single_text = findViewById(R.id.read_single_textView)


        read_single_button.setOnClickListener {
            readSingleData()
        }

        read_observer_button.setOnClickListener {
            readObserverData()
        }


        //        val emailtxt = intent.getStringExtra("email")

        // Capture the layout's TextView and set the string as its text
        /*val textView = findViewById<TextView>(R.id.emailView).apply {
            text = emailtxt
        }*/

        //var email: String = intent.getStringExtra("email")
        //var provider: String = intent.getStringExtra("provider")
        //Recargar phone
        var bundle :Bundle ?= intent.extras
        //val email:String = intent.getStringExtra("email")
        val email = bundle?.getString("email")
        //val email2:String ?= bundle?.getString("email")
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
        val provider:String ?= bundle?.getString("provider")
        //val email:String ?= bundle?.getString("email")
        //val provider:String ?= bundle?.getString("provider")
        //var email: String = intent.getStringExtra("email")
        //var provider: String = intent.getStringExtra("provider")
        //showAlert(email ?: "No tiene email")
        //homenotify(email ?: "", provider ?: "")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.Process -> {
                startActivity(Intent(this,ProcessActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    fun readSingleData(){

        val name = read_single_text.text.toString().trim()
        //val ref = FirebaseDatabase.getInstance().getReference("notifylaywer")
        val process_id = "2"//ref.push().key
        val client_id = "3"//ref.push().key
        val date_start = "20/02/2020"
        val date_end = "20/02/2021"

        //val proc = Process(process_id,client_id,name,date_start,date_end)
/*
        ref.child(process_id).setValue(proc).addOnCompleteListener{
            Toast.makeText(applicationContext,"Process Saved",Toast.LENGTH_LONG).show() 
        }*/

     //   val user = User(name, email)
        val database = FirebaseDatabase.getInstance().reference

        database.child("Process").child(process_id).setValue(client_id)

        /*FirebaseDatabase.getInstance().reference
            .child("Process4")
            .child("5")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String, Any>
                    read_single_textView = map["name"].toString()
                }
            })*/
    }


    fun readObserverData(){

        FirebaseDatabase.getInstance().reference
            .child("Process")
            .child("cliente_id2")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    var map = p0.value as Map<String, Any>
                    read_observer_textView.text = map["name"].toString()
                }
            })
    }

    private fun homenotify(email: String, provider: String){
        title = "Notificaciones Actuales"

        lateinit var ref : DatabaseReference
        lateinit var processlist:MutableList<Process>
        lateinit var textView: TextView
        lateinit var listView: ListView


        //var database = Firebase.database();

        processlist = mutableListOf()
        //listView = findViewById(R.id.list_process)

        /*val database = FirebaseDatabase.getInstance()
        ref = database.getReference("notifylaywer")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    processlist.clear()
                    for (e in p0.children){
                        val process = e.getValue(Process::class.java)
                        processlist.add(process!!)
                    }
                   // val adapter = Pro
                }
            }

        })*/
        //myRef.setValue("Hello, World!")

        /*emailView.text = email
        providerView.text = provider

        btnCerrarSesion.setOnClickListener {
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

    }

    private fun showAlert(message:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Info")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
