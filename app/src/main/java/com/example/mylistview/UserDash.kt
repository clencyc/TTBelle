package com.example.mylistview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mylistview.databinding.ActivityUserDashBinding

class UserDash : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUserDashBinding
    private lateinit var saveButton: Button
    private lateinit var TreatYourself: EditText
    private lateinit var Essentials: EditText
    private lateinit var Finance: EditText
    private lateinit var setDate: EditText
    private lateinit var BTNEDT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TreatYourself = findViewById(R.id.filled_edit_text1)
        Essentials = findViewById(R.id.filled_edit_text2)
        Finance = findViewById(R.id.filled_edit_text2)
        setDate = findViewById(R.id.date_totalsavings)
        BTNEDT = findViewById(R.id.todashedit)

        binding = ActivityUserDashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BTNEDT.setOnClickListener {
            val intent = Intent(this, UserDash::class.java)
            val message = TreatYourself.text.toString()
            intent.putExtra("message_key", message)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_user_dash)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}