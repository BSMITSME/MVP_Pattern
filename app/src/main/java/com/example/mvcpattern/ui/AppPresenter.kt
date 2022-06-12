package com.example.mvcpattern.ui

import com.example.mvcpattern.util.MyModel


//This will act as Presenter [The waiter]
class AppPresenter {
    //The link between Presenter and the view(MainAcitivity) is done by Interface
    lateinit var appView : AppView

    fun AppPresenter(appView : AppView){
        this.appView = appView
    }

    //2. Linkage between presenter and Model
    fun getAppFromModel() : MyModel{
        return MyModel("MVP pattern is coded by Baek with Master Coding",900000,2 )
    }

    //3. Linkage between presenter and MainActivity (Calling the interface)
    fun getAppName(){
         appView.onGetAppName(getAppFromModel().appName)/**** passing here the result from DB (Model)****/
    }

}