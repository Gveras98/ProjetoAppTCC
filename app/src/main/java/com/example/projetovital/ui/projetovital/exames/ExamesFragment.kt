package com.example.projetovital.ui.projetovital.exames

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.projetovital.MainActivity
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.ExamesDao
import com.example.projetovital.data.db.datasource.ExamesDataSource
import com.example.projetovital.data.db.repository.ExamesRepository
import com.example.projetovital.databinding.FragmentExamesBinding


class ExamesFragment : Fragment() {

    private lateinit var binding: FragmentExamesBinding
    private lateinit var recyclerExames: RecyclerView

    //Declaração da varival viewModel
    private val viewModel: ExamesViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val examesDao: ExamesDao =
                    AppDatabase.getInstance(requireContext()).examesDao()
                val repository: ExamesRepository = ExamesDataSource(examesDao)
                return ExamesViewModel(repository) as T
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate o layout usando ViewBinding
        binding = FragmentExamesBinding.inflate(inflater, container, false)

        // Inicializa a RecyclerView e o adapter
        recyclerExames = binding.recyclerExames

        //Ponto de entrada do APP (ViewModel)
        observerViewModelEventsExames()


        // Define o botão para chamar a função replaceFragment
        binding.btnCadExames.setOnClickListener {
            (activity as? MainActivity)?.replaceFragment(FormExamesFragment())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    private fun observerViewModelEventsExames() {
        viewModel.exibirExames.observe(viewLifecycleOwner) { exames ->
            val examesListAdapter = ExamesListAdapter(exames, viewModel) { anexo ->
                abrirPDF(anexo) // Chama a função para abrir o PDF
            }

            with(recyclerExames) {
                setHasFixedSize(true)
                adapter = examesListAdapter
            }
        }
    }

    // Função para abrir o PDF
    private fun abrirPDF(anexo: String) {
        val pdfUri = Uri.parse(anexo) // Converta a string do anexo para um URI

        val openPdfIntent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(pdfUri, "application/pdf")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        try {
            startActivity(openPdfIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                requireContext(),
                "Nenhum aplicativo encontrado para abrir PDFs",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Log.e("PDF_VIEW", "Erro ao abrir PDF: ${e.message}")
        }
    }
}