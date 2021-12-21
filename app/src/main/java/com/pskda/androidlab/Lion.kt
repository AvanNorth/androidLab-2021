package com.pskda.androidlab

class Lion: Animal(), Cats {
    override var age = 10;
    override var animalVoice = "ROAR!";

    override fun voice() {
        println(animalVoice)
    }

    override fun beCute() {
        println(String.format("%d years old Lion is cute!",age))
    }
}