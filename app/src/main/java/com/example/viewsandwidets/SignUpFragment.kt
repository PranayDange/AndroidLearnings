package com.example.viewsandwidets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewsandwidets.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        binding.btnSignup.setOnClickListener {
            Toast.makeText(context, "button signup clicked", Toast.LENGTH_LONG).show()
            val name = binding.edittextName.text.toString()
            val email = binding.edittextemail.text.toString()
            val password = binding.edittextPassword.text.toString()
            if(password.trim().equals("")){
                binding.edittextPassword.setError("Password is required")
            }
            val about = binding.edittextWriteSometing.text.toString()
            /*  var gender=if(binding.radioMale.isChecked){
                  gender="Male"
              }else{
                  gender="Female"
              }*/
            val gender = if (binding.radioMale.isChecked) {
                "Male"
            } else {
                "Female"
            }
            //  val gender = if (binding.radioMale.isChecked) "Male" else "Female"

            /*val courses = when {
                binding.checkBoxJava.isChecked -> "Java"
                binding.checkBoxPython.isChecked -> "Python"
                else -> "Android"
            }*/
            val courses = StringBuilder()

            if (binding.checkBoxJava.isChecked) {
                courses.append("Java")
            }

            if (binding.checkBoxPython.isChecked) {
                if (courses.isNotEmpty()) {
                    courses.append(", ") // Add a comma and space if other courses are already selected
                }
                courses.append("Python")
            }

            if (binding.checkBoxAndroid.isChecked) {
                if (courses.isNotEmpty()) {
                    courses.append(", ") // Add a comma and space if other courses are already selected
                }
                courses.append("Android")
            }

            Log.e("Name", name.toString())
            Log.e("email", email)
            Log.e("password", password)
            Log.e("about", about)
            Log.e("gender", gender)
            Log.e("courses", courses.toString())
            Log.e("Hellllllllooooooo", "Hellllllllooooooo")

        }
        binding.btnDatePicker.setOnClickListener {

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}