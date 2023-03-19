package com.example.myattemptlabb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation




class SecondFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val secondView = inflater.inflate(R.layout.fragment_second, container, false)

        val fragTextOne: TextView = secondView.findViewById(R.id.textView3)
        val stringOne: String = fragTextOne.text.toString()

        val fragTextTwo: TextView = secondView.findViewById(R.id.textView6)
        val stringTwo:  String = fragTextTwo.text.toString()

        val reStartTwo: ImageView = secondView.findViewById(R.id.logoForBackwardsTwo)
        reStartTwo.setOnClickListener{
            Navigation.findNavController(secondView).navigate(R.id.action_restartingPartTwo)
        }



        //All FirstQuestion Options
        val firstClickOne: TextView = secondView.findViewById(R.id.textView7)
        val firstClickTwo: TextView = secondView.findViewById(R.id.textView8)
        val firstClickThree: TextView = secondView.findViewById(R.id.textView9)
        val firstClickFour: TextView = secondView.findViewById(R.id.textView10)

        firstClickOne.setOnClickListener{
            if(firstClickOne.text == "1. Gryffindor"){
                firstClickOne.text = "Continue"
                firstClickTwo.text = ""
                firstClickThree.text = ""
                firstClickFour.text = "Change"

                fragTextOne.text = "So you want to be in Gryffindor?"
                fragTextTwo.text = "If you are unsure you can press the lowest text to go back, or you can press the higher text to continue"
            }
            else if(firstClickOne.text == "Continue"){
                Navigation.findNavController(secondView).navigate(R.id.action_whenChosenHouse)
            }

        }

        firstClickTwo.setOnClickListener{
            firstClickOne.text = "Continue"
            firstClickTwo.text = ""
            firstClickThree.text = ""
            firstClickFour.text = "Change"

            fragTextOne.text = "So you want to be in Hufflepuff?"
            fragTextTwo.text = "If you are unsure you can press the lowest text to go back, or you can press the higher text to continue"

        }

        firstClickThree.setOnClickListener{
            firstClickOne.text = "Continue"
            firstClickTwo.text = ""
            firstClickThree.text = ""
            firstClickFour.text = "Change"

            fragTextOne.text = "So you want to be in Slytherin?"
            fragTextTwo.text = "If you are unsure you can press the lowest text to go back, or you can press the higher text to continue"

        }

        firstClickFour.setOnClickListener{
            if(firstClickFour.text == "4. Ravenclaw"){
                firstClickOne.text = "Continue"
                firstClickTwo.text = ""
                firstClickThree.text = ""
                firstClickFour.text = "Change"

                fragTextOne.text = "So you want to be in Ravenclaw?"
                fragTextTwo.text = "If you are unsure you can press the lowest text to go back, or you can press the higher text to continue"
            }
            else if(firstClickFour.text == "Change"){
                fragTextOne.text = stringOne
                fragTextTwo.text = stringTwo

                firstClickOne.text = "1. Gryffindor"
                firstClickTwo.text = "2. Hufflepuff"
                firstClickThree.text = "3. Slytherin"
                firstClickFour.text = "4. Ravenclaw"
            }


        }



        return secondView
    }


}