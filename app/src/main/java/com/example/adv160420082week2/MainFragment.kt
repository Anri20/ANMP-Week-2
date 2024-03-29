package com.example.adv160420082week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainFragment : Fragment() {
    private lateinit var view: View;
    private lateinit var btnStart: Button;
    private lateinit var txtName: TextInputEditText;
    private lateinit var btnOption: Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false)

        btnStart = view.findViewById(R.id.btnStart)
        txtName = view.findViewById(R.id.txtName)
        btnOption = view.findViewById(R.id.btnOption)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart.setOnClickListener {
            val playerName = txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(playerName)
            Navigation.findNavController(it).navigate(action)
        }

//        untuk memunculkan dialog
        btnOption.setOnClickListener {
            val action = MainFragmentDirections.actionOptionFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}