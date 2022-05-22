package com.ahmet.kotlinanimalapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmet.kotlinanimalapp.Adaptery
import com.ahmet.kotlinanimalapp.databinding.FragmentHomeBinding
import com.ahmet.kotlinanimalapp.interfaces.HomeClick
import com.ahmet.kotlinanimalapp.model.Model2

class HomeFragment : Fragment(), HomeClick {
    private lateinit var viewModel:HomeViewModel
    private lateinit var adaptery: Adaptery


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.refreshData()


        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        adaptery = Adaptery(arrayListOf(), this)
        binding.recyclerView.adapter = adaptery

        observeLiveData()


    }
    private fun observeLiveData() {

        viewModel.animals.observe(viewLifecycleOwner, Observer { animals->

            animals?.let {
                adaptery.updateAnimalList(animals)

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemCLickListener(model: Model2) {
        val action=HomeFragmentDirections.actionNavigationHomeToNavigationDashboard()
        findNavController(this).navigate(action)
    }
}