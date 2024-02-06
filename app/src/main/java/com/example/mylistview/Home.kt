package com.example.mylistview

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.ListFragment
import com.example.mylistview.databinding.ActivityMain2Binding

class Home : AppCompatActivity() {



    lateinit var card_section: ImageView
    lateinit var home_section: ImageView
    lateinit var account_section: ImageView
    lateinit var coin_section: ImageView
    lateinit var BTNTodash: Button
    lateinit var user_section: ImageView
    lateinit var BTN_001: Button
    var textView: TextView? = null
    var dialog: AlertDialog? = null
    var editText: EditText? = null
    lateinit var textViewDialog: AlertDialog
    lateinit var alphisTextViewDialog: AlertDialog
    var alphisTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //card_section = findViewById(R.id.cardsection)
        //home_section = findViewById(R.id.homesection)
        account_section = findViewById(R.id.accountsection)
        coin_section = findViewById(R.id.coinsection)
        user_section = findViewById(R.id.usersection)
        BTNTodash = findViewById(R.id.todashedit)
        textView = findViewById<View>(R.id.textView001)!! as TextView
        alphisTextView = findViewById<View>(R.id.AlfisTextView) as TextView
        dialog = AlertDialog.Builder(this).create()
        editText = EditText(this)

        textViewDialog = createDialog(textView!!)
        alphisTextViewDialog = createDialog(alphisTextView!!)

        BTNTodash.setOnClickListener {
            var todash = Intent(this, UserDash::class.java)
            startActivity(todash)
        }

        account_section.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, ListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun createDialog(textView: TextView): AlertDialog {

        val dialog = AlertDialog.Builder(this).create()
        val editText = EditText(this)
        dialog.setTitle("Edit the text")
        dialog.setView(editText)

        dialog.setButton(
            DialogInterface.BUTTON_POSITIVE, "SAVE TEXT"
        ) { _, _ -> textView.text = editText.text.toString() }

        textView.setOnClickListener {
            editText.setText(textView.text)
            dialog.show()
        }

        return dialog

    }
}