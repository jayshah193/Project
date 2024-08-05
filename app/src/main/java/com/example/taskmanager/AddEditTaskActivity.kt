package com.example.taskmanager

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.viewmodel.TaskViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddEditTaskActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_task)

        val titleEditText = findViewById<TextInputEditText>(R.id.editTextTitle)
        val descriptionEditText = findViewById<TextInputEditText>(R.id.editTextDescription)
        val saveButton = findViewById<MaterialButton>(R.id.buttonSave)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val task = Task(0, title, description, false)
            taskViewModel.insert(task)
            finish()
        }
    }
}
