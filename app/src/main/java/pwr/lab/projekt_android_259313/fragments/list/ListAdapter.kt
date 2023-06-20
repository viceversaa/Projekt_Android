package pwr.lab.projekt_android_259313.fragments.list

import android.R
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pwr.lab.projekt_android_259313.data.Event


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var eventList = emptyList<Event>()


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(pwr.lab.projekt_android_259313.R.layout.result_part, parent, false))
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eventList[position]

        holder.itemView.findViewById<TextView>(pwr.lab.projekt_android_259313.R.id.numberOfDays).text = currentItem.eventDate
        holder.itemView.findViewById<TextView>(pwr.lab.projekt_android_259313.R.id.eventNameResult).text = currentItem.eventName
        holder.itemView.findViewById<TextView>(pwr.lab.projekt_android_259313.R.id.eventDescriptionResult).text = currentItem.eventDescription

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(event: List<Event>){
        this.eventList = event
        notifyDataSetChanged()

    }

}