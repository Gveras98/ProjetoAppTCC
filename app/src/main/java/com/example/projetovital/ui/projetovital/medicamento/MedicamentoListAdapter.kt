package com.example.projetovital.ui.projetovital.medicamento

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.MedicamentoEntity

class MedicamentoListAdapter(
    private val medicamentoList: List<MedicamentoEntity>,
    private val viewModel: MedicamentoViewModel
)
    : RecyclerView.Adapter<MedicamentoListAdapter.MedicamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        holder.bindView(medicamentoList[position])

        holder.itemView.findViewById<Button>(R.id.btnMedDelete).setOnClickListener {
            val medicamento = medicamentoList[position]

            // Confirmação para exclusão
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Confirmação")
                .setMessage("Tem certeza que deseja excluir este medicamento?")
                .setPositiveButton("Sim") { _, _ ->
                    viewModel.deleteMedicamento(medicamento) // Chama o ViewModel para deletar
                }
                .setNegativeButton("Não", null)
                .show()
        }

    }

    override fun getItemCount() = medicamentoList.size

    class MedicamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvMedNome = itemView.findViewById<TextView>(R.id.tvMedNome)
        private val tvMedDose = itemView.findViewById<TextView>(R.id.tvMedDose)
        private val tvMedDuracao = itemView.findViewById<TextView>(R.id.tvMedDuracao)
        private val tvMedIntervalo = itemView.findViewById<TextView>(R.id.tvMedIntervalo)

        fun bindView(medicamento: MedicamentoEntity) {
            tvMedNome.text = medicamento.nomeMedicamento
            tvMedDose.text = medicamento.doseMedicamento
            tvMedDuracao.text = medicamento.duracaoMedicamento
            tvMedIntervalo.text = medicamento.intervaloMedicamento
        }
    }
}


