package com.example.tallerdavidblanco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class Calculadora : AppCompatActivity() {
    // atributos
    lateinit var txtResultado: TextView
    lateinit var txtExpresion: TextView
    lateinit var btnZero: TextView
    lateinit var btnOne: TextView
    lateinit var btnTwo: TextView
    lateinit var btnTree: TextView
    lateinit var btnFour: TextView
    lateinit var btnFive: TextView
    lateinit var btnSix: TextView
    lateinit var btnSeven: TextView
    lateinit var btnEight: TextView
    lateinit var btnNine: TextView
    lateinit var btnPlus: TextView
    lateinit var btnMinus: TextView
    lateinit var btnMult: TextView
    lateinit var btnDivis: TextView
    lateinit var btnOpen: TextView
    lateinit var btnClose: TextView
    lateinit var btnPeriod: TextView
    lateinit var btnClear: TextView
    lateinit var btnErase: TextView
    lateinit var btnEquals: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        // Encontrarla en el archivo xml
        txtResultado = findViewById(R.id.txtResultado)
        txtExpresion = findViewById(R.id.txtExpresion)

        //Relacionar botones
        btnZero = findViewById(R.id.zerodBtn)
        btnOne = findViewById(R.id.oneBtn)
        btnTwo = findViewById(R.id.twoBtn)
        btnTree = findViewById(R.id.threeBtn)
        btnFour = findViewById(R.id.fourBtn)
        btnFive = findViewById(R.id.fiveBtn)
        btnSix = findViewById(R.id.sixBtn)
        btnSeven = findViewById(R.id.sieteBtn)
        btnEight = findViewById(R.id.ochoBtn)
        btnNine = findViewById(R.id.nueveBtn)
        btnPlus = findViewById(R.id.plusBtn)
        btnMinus = findViewById(R.id.minusBtn)
        btnMult = findViewById(R.id.multBtn)
        btnDivis = findViewById(R.id.divisionBtn)
        btnOpen = findViewById(R.id.parBtn)
        btnClose = findViewById(R.id.entheBtn)
        btnPeriod = findViewById(R.id.periodBtn)
        btnClear = findViewById(R.id.clearBtn)
        btnErase = findViewById(R.id.eraseBtn)
        btnEquals = findViewById(R.id.equalBtn)

        // Numeros
        btnPeriod.setOnClickListener(){agregarResultado(".",true)}
        btnZero.setOnClickListener(){agregarResultado("0",true)}
        btnOne.setOnClickListener(){agregarResultado("1",true)}
        btnTwo.setOnClickListener(){agregarResultado("2",true)}
        btnTree.setOnClickListener(){agregarResultado("3",true)}
        btnFour.setOnClickListener(){agregarResultado("4",true)}
        btnFive.setOnClickListener(){agregarResultado("5",true)}
        btnSix.setOnClickListener(){agregarResultado("6",true)}
        btnSeven.setOnClickListener(){agregarResultado("7",true)}
        btnEight.setOnClickListener(){agregarResultado("8",true)}
        btnNine.setOnClickListener(){agregarResultado("9",true)}

        //Operadores
        btnPlus.setOnClickListener(){agregarResultado("+",true)}
        btnMinus.setOnClickListener(){agregarResultado("-",true)}
        btnMult.setOnClickListener(){agregarResultado("*",true)}
        btnDivis.setOnClickListener(){agregarResultado("/",true)}
        btnOpen.setOnClickListener(){agregarResultado("(",true)}
        btnClose.setOnClickListener(){agregarResultado(")",true)}

        //Clear
        btnClear.setOnClickListener(){
            txtExpresion.text = ""
            txtResultado.text = ""
        }

        //Borrar
        btnErase.setOnClickListener(){
            val entrada = txtExpresion.text.toString()
            if(entrada.isNotEmpty()){
                txtExpresion.text = entrada.substring(0,entrada.length-1)
            }
            txtResultado.text = ""
        }

        btnEquals.setOnClickListener(){
            try{
                //Ejecutar la expresion ingresada por el usuario
                val Expresion = ExpressionBuilder(txtExpresion.text.toString()).build()
                val Resultado = Expresion.evaluate()

                val longResultado = Resultado.toLong()
                if(Resultado == longResultado.toDouble()){
                    txtResultado.text = longResultado.toString()
                } else{
                    txtResultado.text = Resultado.toString()
                }

            }catch (e:Exception){
                Log.d("Exception", " Message: " + e.message)
            }
        }
    }

    fun agregarResultado(entrada : String, canClear : Boolean){

        if(txtResultado.text.isNotEmpty()){
            txtExpresion.text = ""
        }
        // Borrar la expresion si el usuario lo pide
        if(canClear){
            txtResultado.text= ""
            txtExpresion.append(entrada)
        } else{
            // En caso de querer usar el resultado, agregarlo a la expresion
            txtExpresion.append(txtResultado.text)
            txtExpresion.append(entrada)
            txtResultado.text = ""
        }
    }
}