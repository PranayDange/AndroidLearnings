package com.example.viewsandwidets.signup

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewsandwidets.databinding.FragmentSignupBinding
import java.util.Calendar

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    //val countryName = arrayOf("India", "Russia", "Australia", "Japan", "Usa", "Qatar")

    val countryArray = listOf(
        Country(1, "India", "About Country1"),
        Country(2, "Russia", "About Country2"),
        Country(3, "Australia", "About Country3"),
        Country(4, "Japan", "About Country4"),
        Country(5, "Japan", "About Country5"),
        Country(6, "Japan", "About Country6"),
    )


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
            if (password.trim().equals("")) {
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
            val datePicker = binding.btnDatePicker
            val today = Calendar.getInstance()

            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, month, dayOfMonth ->
                    // Handle the selected date
                    val selectedDate = "${dayOfMonth}/${month + 1}/${year}"
                    // Do something with the selected date
                    Toast.makeText(
                        requireContext(),
                        "Selected date: $selectedDate",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                year, month, day
            )

            datePickerDialog.show()
            // val selectedItem = binding.countrySelector.selectedItem

        }
        /* val StringArrayAdapter=ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,countryName)
         StringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         binding.countrySelector.adapter = StringArrayAdapter*/

        /*  binding.countrySelector.setOnClickListener {
              val selectedPosition = binding.countrySelector.selectedItemPosition
              if (selectedPosition != AdapterView.INVALID_POSITION) {
                  val selectedCountry = countryName[selectedPosition]
                  Toast.makeText(requireContext(), "Selected country: $selectedCountry", Toast.LENGTH_SHORT).show()
              }
          }*/

        val countryAdapter = context?.let { CountryAdapter(it, countryArray) }
        binding.countrySelector.adapter = countryAdapter
        binding.countrySelector.setSelection(5)



        binding.countrySelector.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedCountry =countryArray.get(position)
                    Toast.makeText(
                        requireContext(),
                        "Selected country: $selectedCountry",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}