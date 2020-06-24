package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var doneButton: Button
    lateinit var nicknameText: TextView
    lateinit var nicknameEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        nicknameText = findViewById(R.id.nickname_text)
        nicknameEdit = findViewById(R.id.nickname_edit)

        doneButton.setOnClickListener { addNickname(it) }
        nicknameText.setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view: View) {
        val nickname_edit = findViewById<EditText>(R.id.nickname_edit)
        val nickname_text = findViewById<TextView>(R.id.nickname_text)
        nickname_text.text = nickname_edit.text
        nickname_edit.visibility = View.GONE
        view.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        nicknameEdit.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        view.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEdit, 0   )

    }

}