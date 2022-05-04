package com.ahmet.kotlinanimalapp.ui.bilgi

import android.content.Intent
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ahmet.kotlinanimalapp.databinding.FragmentBilgiBinding
import kotlinx.android.synthetic.main.fragment_bilgi.*

class BilgiFragment : Fragment() {

    private var _binding: FragmentBilgiBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




            val bilgiViewModel = ViewModelProvider(this).get(BilgiViewModel::class.java)

            _binding = FragmentBilgiBinding.inflate(inflater, container, false)
            val root: View = binding.root

            bilgiViewModel.text.observe(viewLifecycleOwner) {

            }
            return root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      /*
        btnExpand.setOnClickListener {
            if (expandableLayout.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout.visibility = View.VISIBLE
                btnExpand.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout.visibility = View.GONE
                btnExpand.text = "OKU"
            }
        }

       */
    }


        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }


}