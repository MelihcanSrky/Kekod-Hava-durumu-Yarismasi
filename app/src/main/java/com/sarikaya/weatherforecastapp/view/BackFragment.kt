package com.sarikaya.weatherforecastapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sarikaya.weatherforecastapp.databinding.FragmentBackBinding
import com.sarikaya.weatherforecastapp.model.Sehir

class BackFragment(val sehirPosList: Sehir) : Fragment() {

    private var _binding: FragmentBackBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBackBinding.inflate(inflater, container, false)
        binding.backgroundImage.setImageResource(sehirPosList.image)
        binding.cityName.text = sehirPosList.sehir
        binding.saat.text = sehirPosList.weather+"," +sehirPosList.saat
        binding.derece.text = sehirPosList.derece
        binding.iconImage.setBackgroundResource(sehirPosList.icon)
        binding.rain.text = sehirPosList.yagis
        binding.mois.text = sehirPosList.nem
        binding.wind.text = sehirPosList.ruzgar
        binding.tomorrow.text = "Yarın: "+sehirPosList.tomorrow+"°"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}