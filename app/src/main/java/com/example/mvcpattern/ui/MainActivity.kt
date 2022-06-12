package com.example.mvcpattern.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvcpattern.util.MyModel
import com.example.mvcpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , AppView{

    //MVP Pattern
    // 1. Let's organize the packages
    // 2. implementing MVP Pattern

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var appPresenter: AppPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        //Instantiating the presenter
        appPresenter = AppPresenter()
        appPresenter.AppPresenter(this)

        mBinding.button.setOnClickListener{
            //calling the Presenter to get data from DB
            //No linkage between Activity and Model
            //Our MainActivity is Handling UI Only!
            //All Logic occurs at the presenter
            appPresenter.getAppName()
        }
        setContentView(mBinding.root)
    }

    override fun onGetAppName(name: String) {
        mBinding.textView.setText(name)
    }

}

//MVP
//View : Activity with Textview & Button
//Model : My Model
//Presenter : AppPresenter