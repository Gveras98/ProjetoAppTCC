package com.example.projetovital.ui.projetovital.cadastro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.R
import com.example.projetovital.data.db.entity.CadastroEntity
import java.text.SimpleDateFormat
import java.util.Locale

class CadastroListAdapter(
    private val cadastroList: List<CadastroEntity>)
    : RecyclerView.Adapter<CadastroListAdapter.CadastroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CadastroViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cadastro, parent, false)
        return CadastroViewHolder(view)
    }

    override fun onBindViewHolder(holder: CadastroViewHolder, position: Int) {
        holder.bindView(cadastroList[position])
    }

    override fun getItemCount() = cadastroList.size

    class CadastroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCadastroNome: TextView = itemView.findViewById(R.id.tvCadastroNome)
        private val tvCadastroSexo: TextView = itemView.findViewById(R.id.tvCadastroSexo)
        private val tvCadastroDataNascimento: TextView = itemView.findViewById(R.id.tvCadastroDataNascimento)
        private val tvCadastroCPF: TextView = itemView.findViewById(R.id.tvCadastroCPF)
        private val tvCadastroEndereco: TextView = itemView.findViewById(R.id.tvCadastroEndereco)
        private val tvCadastroCEP: TextView = itemView.findViewById(R.id.tvCadastroCEP)
        private val tvCadastroTelefone: TextView = itemView.findViewById(R.id.tvCadastroTelefone)
        private val tvCadastroEmail: TextView = itemView.findViewById(R.id.tvCadastroEmail)
        private val tvCadastroNumeroSUS: TextView = itemView.findViewById(R.id.tvCadastroNumeroSUS)
        private val tvCadastroPlanoSaude: TextView = itemView.findViewById(R.id.tvCadastroPlanoSaude)
        private val tvCadastroNumeroPlanoSaude: TextView = itemView.findViewById(R.id.tvCadastroNumeroPlanoSaude)
        private val tvCadastroTipoSanguineo: TextView = itemView.findViewById(R.id.tvCadastroTipoSanguineo)

        fun bindView(cadastro: CadastroEntity) {
            tvCadastroNome.text = cadastro.nomeUser
            tvCadastroSexo.text = cadastro.sexoUser.toString()
            tvCadastroDataNascimento.text = cadastro.dataNascimentoUser.let {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
            } ?: "Data não disponível"
            tvCadastroCPF.text = cadastro.cpfUser
            tvCadastroEndereco.text = cadastro.enderecoUser
            tvCadastroCEP.text = cadastro.cepUser
            tvCadastroTelefone.text = cadastro.telefoneUser
            tvCadastroEmail.text = cadastro.emailUser
            tvCadastroNumeroSUS.text = cadastro.numSusUser
            tvCadastroPlanoSaude.text = cadastro.planoSaudeUser
            tvCadastroNumeroPlanoSaude.text = cadastro.numPlanoSaudeUser
            tvCadastroTipoSanguineo.text = cadastro.tipoSanguineoUser
        }
    }
}
