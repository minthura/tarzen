package tech.min.tarzen.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import tech.min.tarzen.databinding.FragmentMainBinding
import tech.min.tarzen.extension.toast

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object{
        fun newInstance() = MainFragment()
    }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = this@MainFragment.viewModel.apply {
                showToast.onEach {
                    toast(it)
                }.launchIn(viewLifecycleOwner.lifecycleScope)
            }
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

}