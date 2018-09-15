package br.ufpe.cin.if710.rss

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.itemlista.view.*
import android.content.Intent.ACTION_VIEW

class ListRssAdapter(private val rssList: List<ItemRSS>, private val context: Context) : Adapter<ListRssAdapter.ViewHolder>() {

    override fun getItemCount(): Int = rssList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.itemlista,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rss = rssList[position]
        holder.title.text = rss.title
        holder.data.text = rss.pubDate

        holder.title.setOnClickListener{
            val intent = Intent(ACTION_VIEW)
            intent.data = Uri.parse(rss.link)
            context.startActivity(intent)

        }

    }

    class ViewHolder(rssList : View) : RecyclerView.ViewHolder(rssList){
        var title = rssList.item_titulo
        var data = rssList.item_data
    }
}