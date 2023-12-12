package com.example.nativeandroid.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import com.example.nativeandroid.data.CoworkingSpace
import com.example.nativeandroid.databinding.FragmentDetailsBinding
import java.io.Serializable

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel
    private lateinit var _binding: FragmentDetailsBinding

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = DetailsViewModel()

        binding.setVariable(BR.viewModel, viewModel)

        var data = activity?.intent?.getSerializableExtra("details") as CoworkingSpace
        viewModel.detailsData = MutableLiveData(data)

        binding.executePendingBindings()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}