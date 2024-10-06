package com.example.projetovital.ui.projetovital.exames

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.ExamesEntity
import java.text.SimpleDateFormat
import java.util.Locale

class ExamesListAdapter(
    private val examesList: List<ExamesEntity>,
    private val viewModel: ExamesViewModel,
    private val onAnexoClick: (String) -> Unit
) : RecyclerView.Adapter<ExamesListAdapter.ExamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exames, parent, false)
        return ExamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExamesViewHolder, position: Int) {
        holder.bindView(examesList[position], onAnexoClick)

        //Botão Delete
        holder.itemView.findViewById<Button>(R.id.btnExameDelete).setOnClickListener {
            val exames = examesList[position]

            // Confirmação para exclusão
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem certeza que deseja excluir este exame?")
                .setPositiveButton("Sim") { _, _ ->
                    viewModel.deleteExames(exames) // Chama o ViewModel para deletar
                }
                .setNegativeButton("Não", null)
                .show()
        }

        // Botão de update
        holder.itemView.findViewById<Button>(R.id.btnExameEditar).setOnClickListener {
            val exames = examesList[position]
            // Confirmação para edição
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem Certeza Que Deseja Editar Este Exame?")
                .setPositiveButton("Sim") { _, _ ->
                    val fragment = FormExamesFragment().apply {
                        arguments = Bundle().apply {
                            putSerializable("exames", exames)
                        }
                    }
                    (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack(null)
                        .commit()
                }
                .setNegativeButton("Não", null)
                .show()
        }
    }

    override fun getItemCount() = examesList.size

    class ExamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvExameEspecialidade: TextView =
            itemView.findViewById(R.id.tvExameEspecialidade)
        private val tvExameData: TextView = itemView.findViewById(R.id.tvExameData)
        private val tvExameLocal: TextView = itemView.findViewById(R.id.tvExameLocal)
        private val tvExameProcedimento: TextView = itemView.findViewById(R.id.tvExameProcedimento)
        private val btnExameAnexo: Button = itemView.findViewById(R.id.btnExameAnexo)

        fun bindView(exames: ExamesEntity, onAnexoClick: (String) -> Unit) {
            tvExameEspecialidade.text = exames.especialidadeExame
            tvExameData.text = exames.dataExame.let {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
            } ?: "Data não disponível"
            tvExameLocal.text = exames.localExame
            tvExameProcedimento.text = exames.procedimentoExame

            btnExameAnexo.setOnClickListener {
                exames.anexoExame?.let { anexo -> onAnexoClick(anexo) }
            }
        }
    }
}

