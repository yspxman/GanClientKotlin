package com.example.syan.ganclientkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
    }

    fun changeFragment(f: Fragment, clearnStack: Boolean =false){
        val ft  = supportFragmentManager.beginTransaction();
        if (clearnStack){
            clearBackStack()
        }
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit);
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null);
        ft.commit();
    }

    fun clearBackStack(){
        val fm = supportFragmentManager;
        if (fm.backStackEntryCount > 0){
            fm.popBackStack(fm.getBackStackEntryAt(0).id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val fm =supportFragmentManager
        if (fm.backStackEntryCount > 1){
            fm.popBackStack()
        }
        else {
            finish()
        }
    }
}
