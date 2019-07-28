package com.juanu.moneyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var resultado: Double = 1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monedas = arrayOf("Peso Colombiano", "Dolar Americano", "Euro")
        var mndSpinner1 = findViewById<Spinner>(R.id.mndspinner1)
        var mndSpinner2 = findViewById<Spinner>(R.id.mndspinner2)

        val etNumDiv= findViewById<EditText>(R.id.etNumDiv)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val btconv = findViewById<Button>(R.id.btconv)

        var  nummnd: String
        var mnd1 = ""
        var mnd2 = ""

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, monedas)
        mndSpinner1.adapter = adapter
        mndSpinner2.adapter = adapter


        mndSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                mnd1 = mndSpinner1.selectedItem.toString()

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                mnd1 = ""
            }
        }
        mndSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                mnd2 = mndSpinner2.selectedItem.toString()
                //Toast.makeText(this@MainActivity,mnd2,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                mnd2 = ""
            }
        }

        btconv.setOnClickListener {
            nummnd = etNumDiv.text.toString()
            if(nummnd == "" ){
                resultado= 0.0
            }else{

                when (mnd1) {
                    "Dolar Americano" ->
                        when (mnd2) {
                            "Peso Colombiano" ->
                                resultado = nummnd.toDouble() * 3178
                            "Euro" ->
                                resultado = nummnd.toDouble() / 1.12
                            "Dolar Americano" ->
                                resultado = nummnd.toDouble()

                        }
                    "Peso Colombiano" ->
                        when (mnd2) {
                            "Peso Colombiano" ->
                                resultado = nummnd.toDouble()
                            "Euro" ->
                                resultado = nummnd.toDouble() / 3570
                            "Dolar Americano" ->
                                resultado = nummnd.toDouble() / 3178
                        }
                    "Euro" ->
                        when (mnd2) {
                            "Peso Colombiano" ->
                                resultado = nummnd.toDouble() * 3570
                            "Euro" ->
                                resultado = nummnd.toDouble()
                            "Dolar Americano" ->
                                resultado = nummnd.toDouble() * 1.12
                        }

                }
            }

            tv1.text = resultado.toString()

        }

    }
}
