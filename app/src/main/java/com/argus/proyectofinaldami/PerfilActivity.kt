package com.argus.proyectofinaldami

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.argus.proyectofinaldami.entidad.UserSessionData
import com.argus.proyectofinaldami.services.ApiServiceUser

class PerfilActivity:AppCompatActivity() {
    private lateinit var tvNombreUsuario:TextView
    private lateinit var tvApellidoUsuario:TextView
    private lateinit var tvEmailUsuario:TextView
    private lateinit var btnHome: LinearLayout
    private lateinit var btnLibro: LinearLayout
    private lateinit var btnAutor: LinearLayout
    private lateinit var btnPrestamo: LinearLayout
    private lateinit var btnPerfil: LinearLayout
    private lateinit var btnCerrarSesion:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.perfil)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvNombreUsuario=findViewById(R.id.tvNombreUsuario)
        tvApellidoUsuario=findViewById(R.id.tvApellidoUsuario)
        tvEmailUsuario=findViewById(R.id.tvEmailUsuario)
        cargarusuario()

        btnHome=findViewById(R.id.btnHomeMenu)
        btnLibro=findViewById(R.id.btnLibroMenu)
        btnAutor=findViewById(R.id.btnAutorMenu)
        btnPrestamo=findViewById(R.id.btnPrestamoMenu)
        btnPerfil=findViewById(R.id.btnPerfilMenu)

        btnCerrarSesion=findViewById(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener { cerrarsesion() }
        btnHome.setOnClickListener { irhome() }
        btnLibro.setOnClickListener { irlibro() }
        btnAutor.setOnClickListener { irautor() }
        btnPrestamo.setOnClickListener { irprestamo() }
        btnPerfil.setOnClickListener { irperfil() }
    }

    fun cargarusuario(){
        tvNombreUsuario.setText(UserSessionData.nombres)
        tvApellidoUsuario.setText(UserSessionData.apellidos)
        tvEmailUsuario.setText(UserSessionData.email)
    }

    fun cerrarsesion(){
        UserSessionData.email=null
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun irhome(){
        var intent= Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    fun irlibro(){
        var intent= Intent(this,LibroActivity::class.java)
        startActivity(intent)
    }
    fun irautor(){
        var intent= Intent(this,PerfilActivity::class.java)
        startActivity(intent)
    }

    fun irprestamo(){
        //var intent=Intent(this,PrestamoActivity::class.java)
        startActivity(intent)
    }
    fun irperfil(){
        var intent=Intent(this,PerfilActivity::class.java)
        startActivity(intent)
    }

}