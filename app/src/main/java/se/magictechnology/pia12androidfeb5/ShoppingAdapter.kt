package se.magictechnology.pia12androidfeb5

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    var startfrag : StartFragment? = null

    var shoppinglist = mutableListOf<Shopitem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var shoptext = view.findViewById<TextView>(R.id.shoprowText)
        var shopamount = view.findViewById<TextView>(R.id.shoprowAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // SKAPA RAD
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shoppingrow, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // ANTAL RADER
        return shoppinglist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // RITA RAD
        holder.shoptext.text = shoppinglist[position].shopname
        holder.shopamount.text = shoppinglist[position].shopamount.toString()

        holder.itemView.setOnClickListener {
            Log.i("PIA12debug", "Klick på raden")

            startfrag?.let {
                it.godetail(shoppinglist[position])
            }
        }

    }


}


class Shopitem {
    var shopname = ""
    var shopamount = 0
}
