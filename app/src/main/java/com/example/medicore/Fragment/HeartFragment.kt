package com.example.medicore.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.medicore.HeartRiskActivity
import com.example.medicore.R
import com.example.medicore.dietHeart
import com.example.medicore.exerciseHeart

class heartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_heart, container, false)

        // Button 1: Open dietHeart activity
        val button1: Button = view.findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(requireContext(), dietHeart::class.java)
            startActivity(intent)
        }

        // Button 2: Open exerciseHeart activity
        val button2: Button = view.findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(requireContext(), exerciseHeart::class.java)
            startActivity(intent)
        }

        // Button 3: Open Google Form in browser
        val button3: Button = view.findViewById(R.id.button3)
        button3.setOnClickListener {
            val url = "https://forms.gle/VgDK6yM7hNSmTid39"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val heartRiskBtn = view.findViewById<Button>(R.id.button4)
        heartRiskBtn.setOnClickListener {
            val intent = Intent(requireContext(), HeartRiskActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
