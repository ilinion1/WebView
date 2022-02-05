package com.example.webview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webview.R
import com.example.webview.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    private val imageList = listOf(
        R.drawable.telefon,
        R.drawable.pulesos,
        R.drawable.proig1,
        R.drawable.pristavka,
        R.drawable.proig2,
        R.drawable.chaynik,
        R.drawable.proig3,
        R.drawable.fen,
        R.drawable.proig4,
        R.drawable.proig5,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btGame.setOnClickListener {
            binding.imGame.setImageResource(imageList[random()])
        }
    }


    private fun random(): Int {
        val imageSize = imageList.size -1
        return (0..imageSize).random()
    }

}