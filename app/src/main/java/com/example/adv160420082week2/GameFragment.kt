package com.example.adv160420082week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class GameFragment : Fragment() {
    private lateinit var view: View;
    private lateinit var btnBack: Button;
    private lateinit var txtTurn: TextView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_game, container, false)

        btnBack = view.findViewById(R.id.btnBack)
        txtTurn = view.findViewById(R.id.txtTurn)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

//        arguments?.let {
//            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
//            txtTurn.text = "$playerName's Turn"
//        }

        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}