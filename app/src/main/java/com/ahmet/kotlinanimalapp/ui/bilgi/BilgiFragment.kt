package com.ahmet.kotlinanimalapp.ui.bilgi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ahmet.kotlinanimalapp.databinding.FragmentBilgiBinding

class BilgiFragment : Fragment() {

    private var _binding: FragmentBilgiBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bilgiViewModel= ViewModelProvider(this).get(BilgiViewModel::class.java)

        _binding= FragmentBilgiBinding.inflate(inflater,container,false)
        val root:View=binding.root


        bilgiViewModel.text.observe(viewLifecycleOwner) {

        }
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}