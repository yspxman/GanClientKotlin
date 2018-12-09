package com.example.syan.ganclientkotlin.Common
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.syan.ganclientkotlin.R
import com.squareup.picasso.Picasso

fun ViewGroup.inflate (id : Int, attachToRoot: Boolean = false): View{
    return LayoutInflater.from(context).inflate(id, this, attachToRoot)
}

fun ImageView.loadImg(url: String){
    Picasso.with(context).load(R.mipmap.ic_launcher).into(this)

    /*
    if (TextUtils.isEmpty(url)){
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    }
    else
    {
        Picasso.with(context).load(url).into(this)
    }
*/
}



var a = 1
val s1 = "s1 is $a"
val exp = "${s1.replace("is", "was")}, but now is $a"


fun maxof(a:Int, b:Int) = if (a > b) a else b

var items = listOf("a", "bc", "test", 3)


class Person (var A1:String, var A2:String){

    var P1:Int = 0
    var IsActive: Boolean = false
    var Address: String = ""



    var Name : String = "mike"
    get() = field.toUpperCase()

    set(value) {
        field = value.toLowerCase()
        A1 = "so"
    }

    val Age: String = "yong"
        get() = field.toUpperCase()


    var Title: String = "title"
    get() = field.capitalize()
    private set


    fun dosth() {
        print(A1 + A2)

    }
}