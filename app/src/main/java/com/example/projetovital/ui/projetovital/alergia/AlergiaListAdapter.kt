package com.example.projetovital.ui.projetovital.alergia

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.AlergiaEntity

class AlergiaListAdapter(
    private val alergiaList: List<AlergiaEntity>,
    private val viewModel: AlergiaViewModel
)
    : RecyclerView.Adapter<AlergiaListAdapter.AlergiaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlergiaViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_alergia, parent, false)
        return AlergiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlergiaViewHolder, position: Int) {
        holder.bindView(alergiaList[position])

        // Botão de deletar
        holder.itemView.findViewById<Button>(R.id.btnAlergiaDelete).setOnClickListener {
            val alergia = alergiaList[position]

            // Confirmação para exclusão
            // Confirmação para exclusão
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem certeza que deseja excluir esta alergia?")
                .setPositiveButton("Sim") { _, _ ->
                    viewModel.deleteAlergia(alergia) // Chama o ViewModel para deletar
                }
                .setNegativeButton("Não", null)
                .show()
        }
    }

    override fun getItemCount() = alergiaList.size

    class AlergiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvAlergiaNome: TextView = itemView.findViewById(R.id.tvAlergiaNome)

        fun bindView(alergia: AlergiaEntity) {
            tvAlergiaNome.text = alergia.nomeAlergia
        }
    }
}