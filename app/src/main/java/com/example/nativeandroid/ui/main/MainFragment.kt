package com.example.nativeandroid.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nativeandroid.data.CoworkingSpace
import com.example.nativeandroid.data.DataRepository
import com.example.nativeandroid.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val errorText = "Error Fetching Data"

    private lateinit var viewModel: MainViewModel
    private lateinit var _binding: FragmentMainBinding

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = MainViewModel(repository = DataRepository(), context = context)

        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }

        initObserver()
    }

    private fun initObserver() {
        viewModel.responseData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressbar.visibility = View.INVISIBLE

                val data: ArrayList<CoworkingSpace> = ArrayList(it)
                viewModel.setAdapterData(data)
            } else {
                Toast.makeText(requireContext(), errorText, Toast.LENGTH_LONG).show()
            }
        }
    }
}