package com.example.myattemptlabb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView
import androidx.navigation.Navigation


class ThirdFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

private val sharedModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val thirdView = inflater.inflate(R.layout.fragment_third, container, false)

        //single variables
        val optOne: TextView = thirdView.findViewById(R.id.optionOne)
        val optTwo: TextView = thirdView.findViewById(R.id.optionTwo)
        val optTre: TextView = thirdView.findViewById(R.id.optionThree)
        val optFor: TextView = thirdView.findViewById(R.id.optionFour)

        //arrays of questions & answers
        val questionList: Array<String> = arrayOf(
            "1. What would you pick as your spirit animal?",
            "2. You are stuck in a dark cave, cornered by a dangerous monster. What will you do?",
            "3. You and your friend have both become poisoned, but there is only antidote for one of you. What will you do?",
            "4. You walk on the road on the countryside and suddenly find a dead body. What comes to your mind?",
            "5. What would you be doing with your life if you were a muggle?"
        )

        val forGryf: Array<String> = arrayOf(
            "A furry Quadrupedal mammal",
            "Show no fear and scare it away",
        "Give the antidote to your friend",
        "Burying the body",
            "Acting & Stuntwork, or other esthetics"
        )

        val forSly: Array<String> = arrayOf(
            "A lizard or other reptile",
            "Kill it to survive",
        "Take the antidote for yourself",
        "Running away before you get killed next",
        "Work in the military, or with fitness")

        val forRaven: Array<String> = arrayOf(
            "A bird, large or small",
        "Outsmart it to escape",
            "Only take half the antidote",
            "Investigate what happened",
            "Study science or politics"

        )

        val forHuff: Array<String> = arrayOf(
            "Neither",
        "Run and hide",
            "Let your friend choose",
            "Leaving the body and moving on",
            "Other kinds of work"
        )




        var questioning: TextView = thirdView.findViewById(R.id.overhangingQuestion)
        var questionIndex: Int = 0

        questioning.text = questionList[questionIndex].toString()
        optOne.text = forGryf[questionIndex]
        optTwo.text = forSly[questionIndex]
        optTre.text = forRaven[questionIndex]
        optFor.text = forHuff[questionIndex]




        //setOnClickListeners
        optOne.setOnClickListener{
            sharedModel.gryf++
            questionIndex++
            if(questionIndex >= questionList.size){
                sharedModel.compareHouses()
                Navigation.findNavController(thirdView).navigate(R.id.action_houseTowardsBlank)
            }
            else{

                questioning.text = questionList[questionIndex]
                optOne.text = forGryf[questionIndex]
                optTwo.text = forSly[questionIndex]
                optTre.text = forRaven[questionIndex]
                optFor.text = forHuff[questionIndex]
            }
        }
        optTwo.setOnClickListener{
            sharedModel.sly++
            questionIndex++
            if(questionIndex >= questionList.size){
                sharedModel.compareHouses()
                Navigation.findNavController(thirdView).navigate(R.id.action_houseTowardsBlank)
            }
            else{
                questioning.text = questionList[questionIndex]
                optOne.text = forGryf[questionIndex]
                optTwo.text = forSly[questionIndex]
                optTre.text = forRaven[questionIndex]
                optFor.text = forHuff[questionIndex]
            }
        }

        optTre.setOnClickListener{
            sharedModel.rave++
            questionIndex++
            if(questionIndex >= questionList.size){
                sharedModel.compareHouses()
                Navigation.findNavController(thirdView).navigate(R.id.action_houseTowardsBlank)
            }
            else{
                questioning.text = questionList[questionIndex]
                optOne.text = forGryf[questionIndex]
                optTwo.text = forSly[questionIndex]
                optTre.text = forRaven[questionIndex]
                optFor.text = forHuff[questionIndex]
            }
        }

        optFor.setOnClickListener{
            sharedModel.huff++
            questionIndex++
            if(questionIndex >= questionList.size){
                sharedModel.compareHouses()
                Navigation.findNavController(thirdView).navigate(R.id.action_houseTowardsBlank)
            }
            else{
                questioning.text = questionList[questionIndex]
                optOne.text = forGryf[questionIndex]
                optTwo.text = forSly[questionIndex]
                optTre.text = forRaven[questionIndex]
                optFor.text = forHuff[questionIndex]
            }
        }

        return thirdView
    }

}