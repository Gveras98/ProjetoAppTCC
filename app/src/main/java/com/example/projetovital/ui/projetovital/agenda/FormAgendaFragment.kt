package com.example.projetovital.ui.projetovital.agenda

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetovital.data.db.AppDatabase
import com.example.projetovital.data.db.dao.AgendaDao
import com.example.projetovital.data.db.datasource.AgendaDataSource
import com.example.projetovital.data.db.entity.AgendaEntity
import com.example.projetovital.data.db.repository.AgendaRepository
import com.example.projetovital.databinding.FragmentFormAgendaBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale


class FormAgendaFragment : Fragment() {
    private lateinit var binding: FragmentFormAgendaBinding

    private val viewModel: AgendaViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val agendaDao: AgendaDao = AppDatabase.getInstance(requireContext()).agendaDao()
                val repository: AgendaRepository = AgendaDataSource(agendaDao)
                return AgendaViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormAgendaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inserirAgenda()
        observeEvents()
    }

    private fun inserirAgenda() {
        // Listener para seleção de data
        binding.etAgendaData.setOnClickListener {
            val calendar = Calendar.getInstance()
            val ano = calendar.get(Calendar.YEAR)
            val mes = calendar.get(Calendar.MONTH)
            val dia = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                val dataSelecionada = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
                binding.etAgendaData.setText(dataSelecionada)
            }, ano, mes, dia).show()
        }

        // Listener para seleção de hora
        binding.etAgendaHora.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hora = calendar.get(Calendar.HOUR_OF_DAY)
            val minuto = calendar.get(Calendar.MINUTE)

            TimePickerDialog(requireContext(), { _, selectedHour, selectedMinute ->
                val horaSelecionada = String.format("%02d:%02d", selectedHour, selectedMinute)
                binding.etAgendaHora.setText(horaSelecionada)
            }, hora, minuto, true).show()
        }

        binding.btnAgendaSalvar.setOnClickListener {
            val especialidade = binding.etAgendaEspecialidade.text.toString()
            val dataString = binding.etAgendaData.text.toString()
            val horaString = binding.etAgendaHora.text.toString()
            val local = binding.etAgendaLocal.text.toString()
            val procedimento = binding.etAgendaProcedimento.text.toString()

            // Conversão de String para Date
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val dataAgenda: Date? = if (dataString.isNotEmpty()) {
                try {
                    dateFormat.parse(dataString)
                } catch (e: Exception) {
                    null
                }
            } else {
                null
            }

            // Conversão de String para LocalTime
            val horaAgenda: LocalTime? = if (horaString.isNotEmpty()) {
                try {
                    LocalTime.parse(horaString, DateTimeFormatter.ISO_LOCAL_TIME)
                } catch (e: Exception) {
                    null
                }
            } else {
                null
            }

            val agenda = AgendaEntity(
                especialidadeAgenda = especialidade,
                dataAgenda = dataAgenda ?: Date(),
                horaAgenda = horaAgenda ?: LocalTime.now(),
                localAgenda = local,
                procedimentoAgenda = procedimento
            )

            viewModel.inserirAgenda(agenda)
        }
    }

    private fun observeEvents() {
        viewModel.agendaStateEventData.observe(viewLifecycleOwner) { agendastate ->
            when (agendastate) {
                is AgendaViewModel.AgendaState.Inserido -> {
                    limparCampos()

                }
            }
        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun limparCampos() {
        binding.etAgendaEspecialidade.text?.clear()
        binding.etAgendaData.text?.clear()
        binding.etAgendaHora.text?.clear()
        binding.etAgendaLocal.text?.clear()
        binding.etAgendaProcedimento.text?.clear()
    }
}

