package com.twish.vaxify.presentation.retrieve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.twish.vaxify.databinding.FragmentRetrieveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrieveFragment : Fragment() {
    private lateinit var binding: FragmentRetrieveBinding
    private val viewModel: RetrieveViewModel by viewModels<RetrieveViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRetrieveBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllVaccines()

        viewModel.vaccinesResponse.observe(viewLifecycleOwner){ data ->
            binding.tvTemp.text = data.toString()
        }
    }
}