package com.developer.mjc.engineer.works

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.developer.mjc.R
import com.developer.mjc.util.CredsValidationHelper
import com.developer.mjc.util.ErrorViewHelper.Companion.enableError
import kotlinx.android.synthetic.main.activity_add_work.*

class AddWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        setupViews()
    }

    private fun setupViews() {

        btSaveWork.setOnClickListener{
            validateAndSaveWork()
        }
    }

    private fun validateAndSaveWork() {
        val name = etAddWorkName.text.toString()
        val owner = etAddWorkOwnerName.text.toString()
        val dateOfComletion = etAddWorkDateOfCompletion.text.toString()
        val description = etAddWorkDescription.text.toString()

        if (!CredsValidationHelper.isValidInputText(name)){

            etAddWorkName.enableError("Invalid input")
            return
        }
        if (!CredsValidationHelper.isValidInputText(owner)){

            etAddWorkOwnerName.enableError("Invalid input")
            return
        }
        if (!CredsValidationHelper.isValidInputText(dateOfComletion)){

            Toast.makeText(this, "select a date", Toast.LENGTH_SHORT).show()
            return
        }
        if (!CredsValidationHelper.isValidInputText(description)){

            etAddWorkDescription.enableError("Invalid input")
            return
        }
    }
}