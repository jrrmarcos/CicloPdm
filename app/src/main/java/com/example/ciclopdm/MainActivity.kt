package com.example.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import com.example.ciclopdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    //private final String CICLO_PDM_TAG = "CICLO_PDM" em Java
    companion object  {
        val CICLO_PDM_TAG = "CICLO_PDM"
        val SOBRENOME = "SOBRENOME"
    }

    private lateinit var sobrenomeEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityMainBindind = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        sobrenomeEt = EditText(this)
        sobrenomeEt.width = LinearLayout.LayoutParams.MATCH_PARENT
        sobrenomeEt.height = LinearLayout.LayoutParams.WRAP_CONTENT
        sobrenomeEt.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
        activityMainBinding.root.addView(sobrenomeEt)

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando o ciclo de vida COMPLETO")
    }

    override fun onStart() {
        super.onStart()
        Log.v(CICLO_PDM_TAG, "onStart: Iniciando o ciclo de vida VISÍVEL")
    }

    override fun onResume(){
        super.onResume()
        Log.v(CICLO_PDM_TAG, "onResume: Iniciando o ciclo de vida EM PRIMEIRO PLANO")
    }

    override fun onPause() {
        super.onPause()
        Log.v(CICLO_PDM_TAG, "onPause: Finalizando o ciclo de vida EM PRIMEIRO PLANO\"")
    }

    override fun onStop() {
        super.onStop()
        Log.v(CICLO_PDM_TAG, "onStop: Finalizando o ciclo VISÍVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(CICLO_PDM_TAG, "onDestroy: Finalizando o ciclo de vida COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(CICLO_PDM_TAG, "onStart: Parando execução do onStart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SOBRENOME, sobrenomeEt.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        sobrenomeEt.setText(savedInstanceState.getString(SOBRENOME,""))
    }
}