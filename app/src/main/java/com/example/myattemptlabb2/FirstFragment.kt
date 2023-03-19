package com.example.myattemptlabb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import android.widget.Button
import androidx.fragment.app.activityViewModels


class FirstFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val sharedModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val firstView = inflater.inflate(R.layout.fragment_first, container, false)

        val firstButton:Button  = firstView.findViewById(R.id.toGreatHall)
        firstButton.setOnClickListener{
            Navigation.findNavController(firstView).navigate(R.id.action_enterGreatHall)
        }

        val secondButton: Button = firstView.findViewById(R.id.toRegister)
        secondButton.setOnClickListener{
            Navigation.findNavController(firstView).navigate(R.id.action_directlyToNames)
        }

        return firstView
    }


}