package com.ahmet.kotlinanimalapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahmet.kotlinanimalapp.R
import com.ahmet.kotlinanimalapp.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {
    private lateinit var viewModel:DashboardViewModel
    private var detailsid=0


    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = com.ahmet.kotlinanimalapp.databinding.FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            detailsid= DashboardFragmentArgs.fromBundle(it).uId

        }

        viewModel=ViewModelProvider(this).get(DashboardViewModel::class.java)

        viewModel.getDetailRoom(detailsid)

        observeRoomData()

    }
    private fun observeRoomData(){

        viewModel.details.observe(viewLifecycleOwner, Observer { haber ->
            haber?.let {

                if (haber == null) {

                    textveteriner.text=""
                    textmama.text=""
                    textemizlik.text=""
                    textsevgi.text=""
                    imageView2.setImageResource(R.drawable.veteriner)
                    imageView5.setImageResource(R.drawable.mamama)
                    imageView4.setImageResource(R.drawable.temizlik)
                    imageView3.setImageResource(R.drawable.sevgi)
                    imagetext.setImageResource(R.drawable.hayvan6)
                } else {
                    textveteriner.text=haber.veteriner
                    textmama.text=haber.yemek
                    textemizlik.text=haber.temizlik
                    textsevgi.text=haber.sevgi
                    imageView2.setImageResource(R.drawable.veteriner)
                    imageView5.setImageResource(R.drawable.mamama)
                    imageView4.setImageResource(R.drawable.temizlik)
                    imageView3.setImageResource(R.drawable.sevgi)

                }

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}