package com.example.projetovital.ui.projetovital.medicamento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.MedicamentoEntity

class MedicamentoListAdapter(
    private val medicamentoList: List<MedicamentoEntity>)
    : RecyclerView.Adapter<MedicamentoListAdapter.MedicamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        holder.bindView(medicamentoList[position])
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


