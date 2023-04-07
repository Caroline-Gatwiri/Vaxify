package com.twish.vaxify.presentation.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.twish.vaxify.R
import com.twish.vaxify.app.data.ChildModel
import com.twish.vaxify.app.data.Message.FAILED
import com.twish.vaxify.app.data.Message.SUCCESS
import com.twish.vaxify.databinding.FragmentHomeBinding
import com.twish.vaxify.presentation.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = binding.location
        // Initialize the adapter with data for the spinner
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            listOf(
                "Marsabit County",
                "Mandera County",
                "Wajir County",
                "Turkana County",
                "Samburu County",
                "Isiolo County",
                "Garissa County",
                "Kitui County",
                "Tana River County",
                "Laikipia County",
                "Narok County",
                "Kajiado County",
                "West-Pokot County"
            )
        )

        // Set the dropdown style
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Attach the adapter to the spinner
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                // Handle the selection
                val selectedItem = spinnerAdapter.getItem(position)
                Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing*/
            }
        }


        val spinnerAge = binding.age
        // Initialize the adapter with data for the spinner
        val ageSpinnerAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            listOf(
                "Newborn",
                "6 weeks",
                "10 weeks",
                "14 weeks",
                "9 months",
                "18 months",
                "6 years",
                "10 years"
            )
        )

        // Set the dropdown style
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Attach the adapter to the spinner
        spinnerAge.adapter = ageSpinnerAdapter

        spinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                // Handle the selection
                val selectedItem = ageSpinnerAdapter.getItem(position)
                Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        binding.submitButton.setOnClickListener {
            homeViewModel.clearMessage()
            submitDetails()
        }

        binding.tvVaccines.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_retrieveFragment)
        }
    }

    private fun submitDetails() {
        val childName = binding.childNameEditText.text.toString()
        val guardianName = binding.guardianNameEditText.text.toString()
        val guardianPhone = binding.guardianPhoneEditText.text.toString()
        val age = binding.age.selectedItem.toString()
        val location = binding.location.selectedItem.toString()
        val genderId = binding.radioGroup.checkedRadioButtonId

        val gender = when (genderId) {
            R.id.male -> "Male"
            R.id.female -> "Female"
            else -> ""
        }

        if (childName.isValid() &&
            guardianPhone.isValid() &&
            guardianPhone.isValid() &&
            age.isValid() &&
            location.isValid() &&
            gender.isValid()
        ) {
            val childModel = ChildModel(
                childName = childName,
                guardianName = guardianName,
                guardianPhone = guardianPhone,
                location = location,
                age = age,
                gender = gender
            )

            homeViewModel.postData(childModel)
            homeViewModel.message.observe(viewLifecycleOwner) { message ->
                when (message) {
                    SUCCESS -> {
                        makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()

                        binding.childNameEditText.setText("")
                        binding.guardianNameEditText.setText("")
                        binding.guardianPhoneEditText.setText("")

                    }
                    FAILED -> {
                        makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                    }
                    else -> {}

                }
            }

        } else {
            makeText(requireContext(), "Fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun String.isValid(): Boolean {
        return this.isNotEmpty()
    }
}
