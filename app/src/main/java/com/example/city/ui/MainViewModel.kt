package com.example.city.ui

import androidx.lifecycle.ViewModel
import com.example.city.model.City

class MainViewModel : ViewModel() {

    var cityList = arrayListOf(
        City(1, "Tehran", "Iran", false),
        City(2, "shiraz", "Iran", false),
        City(3, "Beijing", "China", false),
        City(4, "landon", "England", false),
        City(5, "paris", "French", false),
        City(6, "San Jose", "Costa Rica", false),
        City(7, "Nicosia", "the Republic of Cyprus", false),
        City(8, "Berlin", "Germany", false),
        City(9, "Dublin", "Ireland", false),
        City(10, "Tokyo", "Japan", false),
        City(11, "baghdad", "Iraq", false),
        City(12, "dubai", "Emirate", false),
        City(13, "tabriz", "Iran", false),
        City(14, "kabul", "Afghanistan", false),
        City(15, "madrid", "Spain", false),
        City(16, "new york", "Usa", false),
        City(17, "Luanda", "Angola", false),
        City(18, "Buenos Aires", "Argentina", false),
        City(19, "Brasilia", "Brazil", false),
        City(20, "Ottawa", "Canada", false)
    )


    fun favorite(): ArrayList<City> {
        var favoriteCityList = arrayListOf<City>()
        for (city in cityList) {
            if (city.favorite == true) {
                favoriteCityList.add(city)
            }
        }
        return favoriteCityList
    }

}