package com.example.nativeandroid.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.nativeandroid.R
import com.example.nativeandroid.data.DataRepository

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val errorText = "Error Fetching Data"

    private var messageView: TextView? = null

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel(repository = DataRepository(), context = context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        messageView = view.findViewById(R.id.message)

        initObserver()

        return view
    }

    private fun initObserver() {
        viewModel.responseData.observe(viewLifecycleOwner) {
            if (it != null) {
                for (item in it) {
                    if (messageView == null) {
                        continue
                    }

                    messageView?.text = buildString {
                        append(messageView?.text?.toString())
                        append("\n\n")
                        append(item.toString())
                    }
                }
            } else {
                Toast.makeText(requireContext(), errorText, Toast.LENGTH_LONG).show()
            }
        }
    }
}