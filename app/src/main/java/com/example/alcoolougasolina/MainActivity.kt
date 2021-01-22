package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val mPrecoAlcool = alcool.text.toString()
        val mPrecoGas = gas.text.toString()

        val mValidaCampos = mValidarCampos(mPrecoAlcool,mPrecoGas)
        if (mValidaCampos) {
            mCalcular(mPrecoAlcool, mPrecoGas)
        }else {
            text_final.text = "Preencha os campos primeiro !"
        }
    }


    fun mValidarCampos(mPrecoAlcool: String, mPrecoGas: String): Boolean {
        var mCamposValidados: Boolean = true

        if (mPrecoAlcool == "") {
            mCamposValidados = false
        }else if (mPrecoGas == "") {
            mCamposValidados = false
        }
        return mCamposValidados
    }

    fun mCalcular(mPrecoAlcool: String, mPrecoGas: String) {
        val mValorAlcool = mPrecoAlcool.toDouble()
        val mValorGas = mPrecoGas.toDouble()
        val resultadoPreco = mValorAlcool / mValorGas

        if (resultadoPreco >= 0.7) {
            text_final.text = "Melhor Utilizar Gasolina!"
        }else {
            text_final.text = "Melhor Utilizar Álcool"
        }
    }
}

