package com.example.projetovital.ui.projetovital

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class Mask {
    //Implementar as Mascaras

    fun cpfMask(editText: EditText) {
        val cpfMask = object : TextWatcher {
            var isUpdating: Boolean = false
            var oldText: String = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if (isUpdating) {
                    isUpdating = false
                    return
                }

                val cleanText = text.replace("[^\\d]".toRegex(), "")
                val formattedText = when {
                    cleanText.length <= 3 -> cleanText
                    cleanText.length <= 6 -> "${
                        cleanText.substring(
                            0,
                            3
                        )
                    }.${cleanText.substring(3)}"

                    cleanText.length <= 9 -> "${cleanText.substring(0, 3)}.${
                        cleanText.substring(
                            3,
                            6
                        )
                    }.${cleanText.substring(6)}"

                    cleanText.length <= 11 -> "${cleanText.substring(0, 3)}.${
                        cleanText.substring(
                            3,
                            6
                        )
                    }.${cleanText.substring(6, 9)}-${cleanText.substring(9)}"

                    else -> "${cleanText.substring(0, 3)}.${
                        cleanText.substring(
                            3,
                            6
                        )
                    }.${cleanText.substring(6, 9)}-${cleanText.substring(9, 11)}"
                }

                isUpdating = true
                editText.setText(formattedText)
                editText.setSelection(formattedText.length)
            }
        }

        editText.addTextChangedListener(cpfMask)
    }

    fun telefoneMask(editText: EditText) {
        val phoneMask = object : TextWatcher {
            var isUpdating: Boolean = false
            var oldText: String = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if (isUpdating) {
                    isUpdating = false
                    return
                }

                val cleanText = text.replace("[^\\d]".toRegex(), "")
                val formattedText = when {
                    cleanText.length <= 2 -> "(${cleanText})"
                    cleanText.length <= 7 -> "(${
                        cleanText.substring(
                            0,
                            2
                        )
                    }) ${cleanText.substring(2)}"

                    cleanText.length <= 11 -> "(${cleanText.substring(0, 2)}) ${
                        cleanText.substring(
                            2,
                            7
                        )
                    }-${cleanText.substring(7)}"

                    else -> "(${cleanText.substring(0, 2)}) ${
                        cleanText.substring(
                            2,
                            7
                        )
                    }-${cleanText.substring(7, 11)}"
                }

                isUpdating = true
                editText.setText(formattedText)
                editText.setSelection(formattedText.length)
            }
        }
        editText.addTextChangedListener(phoneMask)
    }

    fun cepMask(editText: EditText) {
        val cepMask = object : TextWatcher {
            var isUpdating: Boolean = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if (isUpdating) {
                    isUpdating = false
                    return
                }

                val cleanText = text.replace("[^\\d]".toRegex(), "")
                val formattedText = when {
                    cleanText.length <= 5 -> cleanText
                    cleanText.length <= 8 -> "${
                        cleanText.substring(
                            0,
                            5
                        )
                    }-${cleanText.substring(5)}"

                    else -> "${cleanText.substring(0, 5)}-${cleanText.substring(5, 8)}"
                }

                isUpdating = true
                editText.setText(formattedText)
                editText.setSelection(formattedText.length)
            }
        }

        editText.addTextChangedListener(cepMask)
    }
}
