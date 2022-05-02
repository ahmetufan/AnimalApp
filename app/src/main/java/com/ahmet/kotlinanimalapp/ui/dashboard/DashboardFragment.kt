package com.ahmet.kotlinanimalapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ahmet.kotlinanimalapp.R
import com.ahmet.kotlinanimalapp.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = com.ahmet.kotlinanimalapp.databinding.FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.text.observe(viewLifecycleOwner) {
        }
        return root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val gelenisim=DashboardFragmentArgs.fromBundle(it).isim

            if (gelenisim != null) {
                imagetext.setImageResource(gelenisim.image)
                textveteriner.text=gelenisim.veteriner
                textmama.text=gelenisim.yemek
                textemizlik.text=gelenisim.temizlik
                textsevgi.text=gelenisim.sevgi

                imageView2.setImageResource(R.drawable.veteriner)
                imageView3.setImageResource(R.drawable.sevgi)
                imageView4.setImageResource(R.drawable.temizlik)
                imageView5.setImageResource(R.drawable.mamama)
                imageView6.setImageResource(R.drawable.kalp)
            }


        }





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}