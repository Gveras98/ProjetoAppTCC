package com.example.projetovital.ui.projetovital.agenda

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
import com.example.projetovital.data.db.entity.AgendaEntity
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class AgendaListAdapter(
    private val agendaList: List<AgendaEntity>,
    private val viewModel: AgendaViewModel,
) : RecyclerView.Adapter<AgendaListAdapter.AgendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_agenda, parent, false)
        return AgendaViewHolder(view)
    }


    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        holder.bindView(agendaList[position])

        // Botão de deletar
        holder.itemView.findViewById<Button>(R.id.btnAgendaDelete).setOnClickListener {
            val agenda = agendaList[position]
            // Confirmação para exclusão
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem Certeza Que Deseja Excluir Este Agendamento?")
                .setIcon(R.drawable.logo_vital2)
                .setPositiveButton("Sim") { _, _ ->
                    viewModel.deleteAgenda(agenda) // Chama o ViewModel para deletar
                }
                .setNegativeButton("Não", null)
                .show()
        }

        // Botão de update
        holder.itemView.findViewById<Button>(R.id.btnAgendaEditar).setOnClickListener {
            val agenda = agendaList[position]
            // Confirmação para edição
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem Certeza Que Deseja Editar Este Agendamento?")
                .setIcon(R.drawable.logo_vital2)
                .setPositiveButton("Sim") { _, _ ->
                    val fragment = FormAgendaFragment().apply {
                        arguments = Bundle().apply {
                            putSerializable("agenda", agenda)
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

    override fun getItemCount() = agendaList.size

    class AgendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvAgendaEspecialidade: TextView =
            itemView.findViewById(R.id.tvAgendaEspecialidade)
        private val tvAgendaData: TextView = itemView.findViewById(R.id.tvAgendaData)
        private val tvAgendaHora: TextView = itemView.findViewById(R.id.tvAgendaHora)
        private val tvAgendaLocal: TextView = itemView.findViewById(R.id.tvAgendaLocal)
        private val tvAgendaProcedimento: TextView =
            itemView.findViewById(R.id.tvAgendaProcedimento)

        fun bindView(agenda: AgendaEntity) {
            tvAgendaEspecialidade.text = agenda.especialidadeAgenda

            // Formatação da Data, garantindo que não seja nula
            val dataFormatada = agenda.dataAgenda.let {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
            } ?: "Data não disponível"
            tvAgendaData.text = dataFormatada

            // Formatação da Hora, garantindo que não seja nula
            val horaFormatada = agenda.horaAgenda.let {
                if (it is LocalTime) {
                    it.format(DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault()))
                } else {
                    SimpleDateFormat("HH:mm", Locale.getDefault()).format(it)
                }
            } ?: "Hora não disponível"
            tvAgendaHora.text = horaFormatada

            tvAgendaLocal.text = agenda.localAgenda
            tvAgendaProcedimento.text = agenda.procedimentoAgenda
        }
    }
}
