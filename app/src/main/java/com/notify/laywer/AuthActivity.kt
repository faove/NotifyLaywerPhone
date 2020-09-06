package com.notify.laywer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread.sleep(2000)
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Conexion con Firebase");
        analytics.logEvent("InitScreen",bundle)

        // Autentificar
        iniciarsesion()
    }
    private fun iniciarsesion() {
        title = "Autentificación"
        btnRegistrar.setOnClickListener {
            if (emailText.text.isNotEmpty() && passText.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        emailText.text.toString(),
                        passText.text.toString()
                    )
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {

                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert("El usuario a sido registrado")
                        }
                    }
            }
        }
        btnAcceder.setOnClickListener {
            if (emailText.text.isNotEmpty() && passText.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(emailText.text.toString(), passText.text.toString())
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert("Verifique el usuario y contraseña")
                        }
                    }
            }
        }
    }
    private fun showAlert(message:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email:String, provider: ProviderType){
        //Toast.makeText(this, email, Toast.LENGTH_SHORT).show()

        val i = Intent(this, HomeActivity::class.java).apply {
            action = Intent.ACTION_SEND
            putExtra("email", email.toString())
            putExtra("provider", provider.name)
        }
        // val email: String? = null
        //i.putExtra("email", email)
        //i.putExtra("provider:",provider.name)

        /*val homeIntent = Intent(this,HomeActivity::class.java).apply {
           putExtra("Email:",email)
        }*/
        startActivity(i)
    }
}
