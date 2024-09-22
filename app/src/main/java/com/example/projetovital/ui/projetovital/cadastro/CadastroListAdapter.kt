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
    private val cadastroList: List<CadastroEntity>
) : RecyclerView.Adapter<CadastroListAdapter.CadastroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CadastroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cadastro, parent, false) // Corrija o layout aqui
        return CadastroViewHolder(view)
    }

    override fun onBindViewHolder(holder: CadastroViewHolder, position: Int) {
        holder.bindView(cadastroList[position])
    }

    override fun getItemCount() = cadastroList.size

    class CadastroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewCadastroNome: TextView =
            itemView.findViewById(R.id.textViewCadastroNome)
        private val textViewCadastroDataNascimento: TextView =
            itemView.findViewById(R.id.textViewCadastroDataNascimento)
        private val textViewCadastroCPF: TextView = itemView.findViewById(R.id.textViewCadastroCPF)
        private val textViewCadastroEndereco: TextView =
            itemView.findViewById(R.id.textViewCadastroEndereco)
        private val textViewCadastroCEP: TextView = itemView.findViewById(R.id.textViewCadastroCEP)
        private val textViewCadastroTelefone: TextView =
            itemView.findViewById(R.id.textViewCadastroTelefone)
        private val textViewCadastroEmail: TextView =
            itemView.findViewById(R.id.textViewCadastroEmail)
        private val textViewCadastroNumeroSUS: TextView =
            itemView.findViewById(R.id.textViewCadastroNumeroSUS)
        private val textViewCadastroPlanoSaude: TextView =
            itemView.findViewById(R.id.textViewCadastroPlanoSaude)
        private val textViewCadastroNumeroPlanoSaude: TextView =
            itemView.findViewById(R.id.textViewCadastroNumeroPlanoSaude)
        private val textViewCadastroTipoSanguineo: TextView =
            itemView.findViewById(R.id.textViewCadastroTipoSanguineo)

        fun bindView(cadastro: CadastroEntity) {
            textViewCadastroNome.text = cadastro.nomeUser
            textViewCadastroDataNascimento.text = cadastro.dataNascimentoUser.let {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
            } ?: "Data não disponível"
            textViewCadastroCPF.text = cadastro.cpfUser
            textViewCadastroEndereco.text = cadastro.enderecoUser
            textViewCadastroCEP.text = cadastro.cepUser
            textViewCadastroTelefone.text = cadastro.telefoneUser
            textViewCadastroEmail.text = cadastro.emailUser
            textViewCadastroNumeroSUS.text = cadastro.numSusUser
            textViewCadastroPlanoSaude.text =
                cadastro.planoSaudeUser
            textViewCadastroNumeroPlanoSaude.text =
                cadastro.numPlanoSaudeUser
            textViewCadastroTipoSanguineo.text =
                cadastro.tipoSanguineoUser
        }
    }
}
