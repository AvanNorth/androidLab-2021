package com.pskda.androidlab

class Raven: Animal(), Birds {

    override var age = 1
    override var animalVoice = "kar-kar!"

    override fun fly() {
       println(String.format("%d years ols raven flew away!",age))
    }

    override fun voice() {
        println(animalVoice)
    }

}