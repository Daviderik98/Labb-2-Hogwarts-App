package com.example.myattemptlabb2
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    //general data
    var houseChecked: String = "Checked?"
    var enteredName: String = "Name?"

    //For Fragment_3 or ThirdFragment
    var gryf: Int = 0
    var sly: Int = 0
    var rave: Int = 0
    var huff: Int = 0

    fun compareHouses(){
        val first: Int
        var firstHouse: String
        val second: Int
        var secondHouse: String
        if(gryf > huff){
            first = gryf
            firstHouse = "Gryffindor"
        }
        else{
            first = huff
            firstHouse = "Hufflepuff"
        }
        if(rave > sly){
            second = rave
            secondHouse = "Ravenclaw"
        }
        else{
            second = sly
            secondHouse = "Slytherin"
        }


        if(first > second){
            houseChecked = firstHouse
        }
        else{
            houseChecked = secondHouse
        }

    }

}