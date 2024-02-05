package se.magictechnology.pia12androidfeb5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StartFragment : Fragment() {

    var shopadap = ShoppingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shopadap.startfrag = this

        val shoprecview = view.findViewById<RecyclerView>(R.id.shoppingRV)

        shoprecview.layoutManager = LinearLayoutManager(requireContext())
        //shoprecview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        //shoprecview.layoutManager = GridLayoutManager(requireContext(), 2)

        shoprecview.adapter = shopadap

        view.findViewById<Button>(R.id.addButton).setOnClickListener {

            val addnametext = view.findViewById<EditText>(R.id.addNameEdittext)
            val addamounttext = view.findViewById<EditText>(R.id.addAmountEdittext)

            val whatbuy = addnametext.text.toString()
            val amountbuy = addamounttext.text.toString()

            addnametext.setText("")
            addamounttext.setText("")

            var amount = amountbuy.toIntOrNull()

            if(amount == null) {
                // ERROR FEL
                return@setOnClickListener
            }

            /*
            SWIFT
            if let siffra = amount {
                siffra // int
            }
            */

            amount.let {
            }

            var tempshop = Shopitem()
            tempshop.shopname = whatbuy
            tempshop.shopamount = amount

            shopadap.shoppinglist.add(tempshop)
            shopadap.notifyDataSetChanged()
        }


    }

    fun godetail(shopthing : Shopitem) {

        var detailfrag = ShopdetailFragment()
        detailfrag.currentshop = shopthing

        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, detailfrag)
            .addToBackStack(null)
            .commit()
    }

    fun loadshop() {

    }

}