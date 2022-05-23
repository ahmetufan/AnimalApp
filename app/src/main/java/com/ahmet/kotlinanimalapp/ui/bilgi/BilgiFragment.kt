package com.ahmet.kotlinanimalapp.ui.bilgi

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

        expandable()
    }
    private fun expandable(){
        btnExpand.setOnClickListener {
            if (expandableLayout.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout.visibility = View.VISIBLE
                btnExpand.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout.visibility = View.GONE
                btnExpand.text = "OKU"
            }
        }
        btnExpand2.setOnClickListener {
            if (expandableLayout2.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout2.visibility = View.VISIBLE
                btnExpand2.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout2.visibility = View.GONE
                btnExpand2.text = "OKU"
            }
        }
        btnExpand3.setOnClickListener {
            if (expandableLayout3.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout3.visibility = View.VISIBLE
                btnExpand3.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout3.visibility = View.GONE
                btnExpand3.text = "OKU"
            }
        }
        btnExpand4.setOnClickListener {
            if (expandableLayout4.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout4.visibility = View.VISIBLE
                btnExpand4.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout4.visibility = View.GONE
                btnExpand4.text = "OKU"
            }
        }
        btnExpand5.setOnClickListener {
            if (expandableLayout5.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout5.visibility = View.VISIBLE
                btnExpand5.text = "KAPAT"
            } else {
                TransitionManager.beginDelayedTransition(cardview, AutoTransition())
                expandableLayout5.visibility = View.GONE
                btnExpand5.text = "OKU"
            }
        }

    }


        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }


}