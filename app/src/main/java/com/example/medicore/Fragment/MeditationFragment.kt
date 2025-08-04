package com.example.medicore.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.medicore.R
import com.example.medicore.yoga
import com.example.medicore.bodyweight

class meditationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meditation, container, false)

        // Start yoga activity
        val button1: Button = view.findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(requireContext(), yoga::class.java)
            startActivity(intent)
        }

        // Start bodyweight activity
        val button2: Button = view.findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(requireContext(), bodyweight::class.java)
            startActivity(intent)
        }

        return view
    }
}
