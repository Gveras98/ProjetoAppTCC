package com.example.projetovital

import android.app.Activity
import android.app.Activity.RESULT_OK
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
import com.example.projetovital.databinding.FragmentFormExamesBinding
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_PDF
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.SCANNER_MODE_FULL
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult


class FormExamesFragment : Fragment() {

    private lateinit var binding: FragmentFormExamesBinding
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

    //Função de Scanner
    private fun startScanning(activity: Activity?) {
        activity?.let {
            val options = GmsDocumentScannerOptions.Builder()
                .setGalleryImportAllowed(true)
                .setPageLimit(15)
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