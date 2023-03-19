package com.example.myattemptlabb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Button
import androidx.navigation.Navigation
import android.widget.Toast
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar


class NewsletterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val sharedModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val newsView = inflater.inflate(R.layout.fragment_newsletter, container, false)

        val theHouse: Button = newsView.findViewById(R.id.oneClicker)
        val moveOn: Button = newsView.findViewById(R.id.otherClicker)

        val firstN: EditText = newsView.findViewById(R.id.editFirstName)
        var valueOne: Int = 0

        val lastN: EditText = newsView.findViewById(R.id.editLastName)
        var valueTwo: Int = 0

        val changeTxt: TextView = newsView.findViewById(R.id.textView11)

        val forMail: EditText = newsView.findViewById(R.id.emailsTexts)
        val listEmails: ArrayList<String> = ArrayList(arrayListOf())
        var valueThree: Int = 0

        val listOfNames: ArrayList<String> = ArrayList(arrayListOf())
        var listCount:Int = -1


val firstLogo: ImageView = newsView.findViewById(R.id.logoForBackwardsOne)
        firstLogo.setOnClickListener{
            Navigation.findNavController(newsView).navigate(R.id.action_restartingPartOne)
        }





        theHouse.setOnClickListener{
            if(firstN.text.toString() == "First Name" || firstN.text.toString() == ""){
                valueOne = 0
            }
            else{
                valueOne = 5
            }

            if(lastN.text.toString() == "Sirname" || lastN.text.toString() == ""){
                valueTwo = 0
            }
            else{
                valueTwo = 15
            }

            if(forMail.text.toString() == "Email"){
                valueThree = 0
            }
            else{
                valueThree = 25
            }

            if(valueOne == 5 && valueTwo == 15 && valueThree == 25){
                val savedMail: String = forMail.text.toString()
                listEmails.add(savedMail)
//I never got my snackbar to work and I may have understood why, but I didn´t know what to do. The same was for my toasts
                //val snack = Snackbar.make(this, newsView, "Your email has been added. ", Snackbar.LENGTH_LONG)

                val namePartOne: String = firstN.text.toString()
                val namePartTwo: String = lastN.text.toString()
                val nameTogether: String = "$namePartOne $namePartTwo"

                listOfNames.add(nameTogether)
                listCount++
                println("Welcome $nameTogether")
                println("Rounding up all students...")
                for(i in 0 .. listCount){
                    println(listOfNames[i])
                } //I am aware that this doesn´t work as planned, probably because it´s scoped only to this fragment

                //Toast.makeText(this, "Welcome, $nameTogether", Toast.LENGTH_LONG).show()
                sharedModel.enteredName = nameTogether
            }
            else{
                //Change this to a toast later
                changeTxt.text = "You cannot enter before you have typed in your first name and your sirname in the fields!(As well as your emails)"

            //Toast.makeText(this, "You must write in both your first name and last name", Toast.LENGTH_SHORT).show()
            }


        }
        moveOn.setOnClickListener{
            if(sharedModel.enteredName == "Name?"){
                changeTxt.text = "YOU SHALL NOT PASS! You must press on Register first"
            }
            else{
                    Navigation.findNavController(newsView).navigate(R.id.action_namesTowardsBlank)
            }

        }

        return newsView
    }



}