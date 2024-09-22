package com.example.projetovital.ui.projetovital.exames

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.content.ContentValues
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.ExamesDao
import com.example.projetovital.data.db.datasource.ExamesDataSource
import com.example.projetovital.data.db.entity.ExamesEntity
import com.example.projetovital.data.db.repository.ExamesRepository
import com.example.projetovital.databinding.FragmentFormExamesBinding
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_PDF
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.SCANNER_MODE_FULL
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class FormExamesFragment : Fragment() {

    private lateinit var binding: FragmentFormExamesBinding

    //Referente ao Scanner
    private val scannerLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val result = GmsDocumentScanningResult.fromActivityResultIntent(result.data)
                if (result != null) {
                    processResult(result)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Erro ao obter resultado da digitalização",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    //Referente ao ViewModel
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
        binding = FragmentFormExamesBinding.inflate(inflater, container, false)

        binding.btnScanner.setOnClickListener {
            startScanning(requireActivity())
        }

        // Retorna a view raiz do binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        inserirExames()
    }

    private fun inserirExames() {
        binding.etExamesData.setOnClickListener {
            val calendar = Calendar.getInstance()
            val ano = calendar.get(Calendar.YEAR)
            val mes = calendar.get(Calendar.MONTH)
            val dia = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                // Formatar a data e definir no EditText
                val formattedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
                binding.etExamesData.setText(formattedDate)
            }, ano, mes, dia).show()
        }

        binding.btnExamesSalvar.setOnClickListener {
            val especialidade = binding.etExamesEspecialidade.text.toString()
            val dataExameStr = binding.etExamesData.text.toString()
            val local = binding.etExamesLocal.text.toString()
            val procedimento = binding.etExamesProcedimento.text.toString()

            // Conversão de String para Date
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val dataExame: Date? = if (dataExameStr.isNotEmpty()) {
                try {
                    dateFormat.parse(dataExameStr)
                } catch (e: Exception) {
                    null
                }
            } else {
                null
            }

            val exames = ExamesEntity(
                especialidadeExame = especialidade,
                dataExame = dataExame ?: Date(),
                localExame = local,
                procedimentoExame = procedimento
            )
            viewModel.inserirExames(exames)
        }
    }

    private fun observeEvents() {
        viewModel.examesStateEventData.observe(viewLifecycleOwner) { examesstate ->
            when (examesstate) {
                is ExamesViewModel.ExamesState.Inserido -> {
                    limparCampos()
                }
            }
        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun limparCampos() {
        binding.etExamesEspecialidade.text?.clear()
        binding.etExamesData.text?.clear()
        binding.etExamesLocal.text?.clear()
        binding.etExamesProcedimento.text?.clear()
    }

    //Função de Scanner
    private fun startScanning(activity: Activity?) {
        activity?.let {
            val options = GmsDocumentScannerOptions.Builder()
                .setGalleryImportAllowed(true)
                .setPageLimit(20)
                .setResultFormats(RESULT_FORMAT_PDF)
                .setScannerMode(SCANNER_MODE_FULL)
                .build()

            val scanner = GmsDocumentScanning.getClient(options)

            scanner.getStartScanIntent(activity)
                .addOnSuccessListener { intentSender ->
                    scannerLauncher.launch(IntentSenderRequest.Builder(intentSender).build())
                }
                .addOnFailureListener { exception ->
                    // Tratar exceções aqui
                    Toast.makeText(
                        activity,
                        "Erro ao digitalizar: ${exception.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
        } ?: run {

            Toast.makeText(requireContext(), "Erro ao iniciar a digitalização", Toast.LENGTH_LONG)
                .show()
        }
    }

    //Processa o resultado da imagem digitalizada, mas precisa finalizar o local e forma de salvar etc
    private fun processResult(result: GmsDocumentScanningResult) {
        val contentResolver = requireContext().contentResolver

        result.pdf?.let { pdf ->
            pdf.uri.let { pdfUri ->
                try {
                    // Defina o nome do arquivo PDF =
                    // Vai receber o ID gerado automaticamente de acordo com o BD
                    val fileName = "DocumentoDigitalizado.pdf"

                    // Cria o acesso á pasta do PDF
                    val values = ContentValues().apply {
                        put(MediaStore.Files.FileColumns.DISPLAY_NAME, fileName)
                        put(MediaStore.Files.FileColumns.MIME_TYPE, "application/pdf")
                        put(
                            MediaStore.Files.FileColumns.RELATIVE_PATH,
                            "Documents/Vital+"
                        ) // Caminho no armazenamento acessível
                    }

                    // Insere o PDF no MediaStore e obtém o URI do novo PDF
                    val newPdfUri =
                        contentResolver.insert(MediaStore.Files.getContentUri("external"), values)

                    newPdfUri?.let { uri ->
                        contentResolver.openInputStream(pdfUri)?.use { inputStream ->
                            contentResolver.openOutputStream(uri)?.use { outputStream ->
                                inputStream.copyTo(outputStream)
                            }
                        }
                    } ?: run {
                        // Lidar com a falha ao obter o URI
                        Log.e("SavePDF", "Falha ao obter o URI para salvar o PDF.")
                    }
                } catch (e: Exception) {
                    // Lidar com possíveis exceções
                    Log.e("SavePDF", "Erro ao salvar o PDF", e)
                }
            }
        }
    }
}