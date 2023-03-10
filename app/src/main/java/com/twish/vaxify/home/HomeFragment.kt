package com.twish.vaxify.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.twish.vaxify.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

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
                "West Pokot County"
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
        val spinnerVaccine = binding.vaccine
        // Initialize the adapter with data for the spinner
        val vaccineSpinnerAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            listOf(
                "1",
                "6 ",
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
        spinnerVaccine.adapter = vaccineSpinnerAdapter

        spinnerVaccine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                // Handle the selection
                val selectedItem = vaccineSpinnerAdapter.getItem(position)
                Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

    }
}






