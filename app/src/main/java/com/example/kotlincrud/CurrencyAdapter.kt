package com.example.kotlincrud

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_item.view.*

class CurrencyAdapter(private val context: Context) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    val client by lazy { CurrencyApiClient.create() }
    var currencies: ArrayList<Currency> = ArrayList()

    init {
        refreshCurrencyRate()
    }

    class CurrencyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return CurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val value =
            "${currencies[position].nominal} ${currencies[position].charCode} = ${currencies[position].value} \u20BD"
        holder.view.name.text = value

    }

    override fun getItemCount() = currencies.size

    fun refreshCurrencyRate() {
        client.getCurrencyRate("21/06/2019").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                Log.d("CURR_RES", result.toString())
                currencies.clear()
                currencies.addAll(result.currs)
                notifyDataSetChanged()
            }, { error ->
                Toast.makeText(context, "Refresh error: ${error.message}", Toast.LENGTH_LONG).show()
                Log.e("ERRORS", error.message)
            })
    }
}