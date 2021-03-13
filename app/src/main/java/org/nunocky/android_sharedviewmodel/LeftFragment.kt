package org.nunocky.android_sharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.nunocky.android_sharedviewmodel.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {
    companion object {
        @JvmStatic
        fun createInstance(): LeftFragment {
            return LeftFragment()
        }
    }

    private lateinit var binding: FragmentLeftBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLeftBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            viewModel.incrementCounter()
        }
        return binding.root
    }

}