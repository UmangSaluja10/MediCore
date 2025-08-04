package com.example.medicore.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.medicore.R
import com.example.medicore.EyeRiskActivity
import com.example.medicore.dietEye
import com.example.medicore.exerciseEye

class eyeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eye, container, false)

        // Button 1: Open dietEye activity
        val button1: Button = view.findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(requireContext(), dietEye::class.java)
            startActivity(intent)
        }

        // Button 2: Open exerciseEye activity
        val button2: Button = view.findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(requireContext(), exerciseEye::class.java)
            startActivity(intent)
        }

        // Button 3: Open Google Form
        val button3: Button = view.findViewById(R.id.button3)
        button3.setOnClickListener {
            val url = "https://forms.gle/VgDK6yM7hNSmTid39"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val predictEyeBtn: Button = view.findViewById(R.id.button4)
        predictEyeBtn.setOnClickListener {
            // Open Eye Risk ML activity or fragment
            val intent = Intent(requireContext(), EyeRiskActivity::class.java)
            startActivity(intent)
        }


        return view
    }
}
