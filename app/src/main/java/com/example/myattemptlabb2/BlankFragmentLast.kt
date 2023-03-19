package com.example.myattemptlabb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation

import android.widget.Button
import android.widget.TextView


class BlankFragmentLast : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val sharedModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val maybeLastView =  inflater.inflate(R.layout.fragment_blank_last, container, false)

        val textOpts: TextView = maybeLastView.findViewById(R.id.possibleWelcoming)
        val btnOpts: Button = maybeLastView.findViewById(R.id.optionsButton)



        if(sharedModel.houseChecked != "Checked?" && sharedModel.enteredName != "Name?"){
            val yourHouse = sharedModel.houseChecked
            val yourName = sharedModel.enteredName
            textOpts.text = "Welcome into the School of Witchcraft and Wizardry, $yourName of house $yourHouse"
            btnOpts.text = "Restart"
            btnOpts.setOnClickListener{
                sharedModel.gryf = 0
                sharedModel.sly = 0
                sharedModel.rave = 0
                sharedModel.huff = 0
                sharedModel.houseChecked = "Checked?"
                sharedModel.enteredName = "Name?"
                Navigation.findNavController(maybeLastView).navigate(R.id.action_BlankToRestart)
            }
        }
        else{
            textOpts.text = "Now you have one more task before you can stay in Hogwarts. This button will take you to your next task"
            btnOpts.setOnClickListener{ //Change Content for this later
                if(sharedModel.houseChecked == "Checked?"){
                    Navigation.findNavController(maybeLastView).navigate(R.id.action_backToHousing)
                }
                else{
                    Navigation.findNavController(maybeLastView).navigate(R.id.action_backToNaming)
                }




            }
        }



        val godric: Int = sharedModel.gryf
        val salazar: Int = sharedModel.sly
        val helga: Int = sharedModel.huff
        val rowena: Int = sharedModel.rave


        println("Gryffindor points : $godric")
        println("Slytherin points : $salazar")
        println("Ravenclaw points : $rowena")
        println("Hufflepuff points : $helga")


        return maybeLastView
    }


}