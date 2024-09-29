package com.example.projetovital.ui.projetovital.alergia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.AlergiaEntity

class AlergiaListAdapter(
    private val alergiaList: List<AlergiaEntity>)
    : RecyclerView.Adapter<AlergiaListAdapter.AlergiaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlergiaViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_alergia, parent, false)
        return AlergiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlergiaViewHolder, position: Int) {
        holder.bindView(alergiaList[position])
    }

    override fun getItemCount() = alergiaList.size

    class AlergiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvAlergiaNome: TextView = itemView.findViewById(R.id.tvAlergiaNome)

        fun bindView(alergia: AlergiaEntity) {
            tvAlergiaNome.text = alergia.nomeAlergia
        }
    }
}