package org.nunocky.android_sharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.nunocky.android_sharedviewmodel.databinding.FragmentRightBinding

class RightFragment : Fragment() {
    companion object {
        @JvmStatic
        fun createInstance(): RightFragment {
            return RightFragment()
        }
    }

    private lateinit var binding: FragmentRightBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRightBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}