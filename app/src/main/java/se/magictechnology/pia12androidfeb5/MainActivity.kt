package se.magictechnology.pia12androidfeb5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //domath(3, 8, "plus")
        //domath(100, 1, "minus")

        //letsloop()

        maketextbox("today is a wonderful day")
    }

    fun domath(n1 : Int, n2 : Int, calctype : String) {
        Log.i("pia12debug", "DO MATH")

        var result = 0
        if(calctype == "plus") {
            result = n1 + n2
        }
        if(calctype == "minus") {
            result = n1 - n2
        }

        Log.i("pia12debug", result.toString())

        // Swift
        //print("RESULTAT: \(result)")

        var resultstring = "RESULTAT: $result"
        Log.i("pia12debug", resultstring)


    }

    fun letsloop() {
        var fruits = listOf("apelsin", "banan", "citron", null, "durian", null, "ekorre")

        for(fruit in fruits) {
            if(fruit == null) {
                Log.i("pia12debug", "INGEN FRUKT")
                continue
            }

            Log.i("pia12debug", fruit)

            if(fruit == "banan") {
                Log.i("pia12debug", "DEN ÄR GUL")
            }
        }

    }


    // today is a wonderful day
    /*

    *************
    * today     *
    * is        *
    * a         *
    * wonderful *
    * day       *
    *************

     */

    fun maketextbox(sentence : String) {
        // splitta upp i ord
        val words = sentence.split(" ")

        // Hitta längsta ordet, hur långt det är
        var longestword = 0
        for(word in words) {
            if(word.length > longestword) {
                longestword = word.length
            }
        }

        var starline = ""
        repeat(longestword + 4) {
            starline += "*"
        }

        Log.i("pia12debug", starline)
        for((index,word) in words.withIndex()) {

            var lotsofspace = ""

            repeat(longestword - word.length) {
                lotsofspace += " "
            }

            if(index % 2 == 0) {
                Log.i("pia12debug", "* $lotsofspace$word *")
            } else {
                Log.i("pia12debug", "* $word$lotsofspace *")
            }

        }
        Log.i("pia12debug", starline)

    }

}