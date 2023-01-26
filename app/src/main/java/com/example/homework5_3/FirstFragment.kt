package com.example.homework5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework5_3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var countTen = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root

        plusAndMinus()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun editText() {


        val bundle = Bundle()
        bundle.putString("aixend", binding.etData.text.toString())
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment).commit()
    }

    private fun plusAndMinus() {
        var count = binding.tvResult.text.toString().toInt().plus(1)
        binding.btnPlus.setOnClickListener {
            when (countTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            binding.tvResult.text = count++.toString()
                        }
                        true -> {
                            countTen = true
                            binding.tvResult.text = count--.toString()
                            binding.btnPlus.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            binding.tvResult.text = count--.toString()
                        true -> editText()
                    }
                }
            }
        }
    }
}
