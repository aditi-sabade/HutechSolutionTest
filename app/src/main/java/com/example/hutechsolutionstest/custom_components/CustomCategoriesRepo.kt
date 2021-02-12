package com.example.hutechsolutionstest.custom_components

class CustomCategoriesRepo {
    companion object {
        fun getDailyDealsList() : ArrayList<CustomCategory> {
            val categoryListData = ArrayList<CustomCategory> ()
            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/tomato/6-tomato-png-image.png",
                "Tomato", "12.50", "12.50"))

            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/potato/11-potato-png-images-pictures-download.png",
                "Ooty Potato", "32.50", "32.50"))

            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/eggplant/2-2-eggplant-png-clipart.png",
                "Organic Brinjal", "64.00", "64.00"))

            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/tomato/6-tomato-png-image.png",
                "Tomato", "12.50", "12.50"))

            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/potato/11-potato-png-images-pictures-download.png",
                "Ooty Potato", "32.50", "32.50"))

            categoryListData.add(CustomCategory("https://freepngimg.com/thumb/eggplant/2-2-eggplant-png-clipart.png",
                "Organic Brinjal", "64.00", "64.00"))

            return categoryListData
        }

        fun getNewArrivalsList() : ArrayList<CustomCategory> {
            val newArrivalListData = ArrayList<CustomCategory> ()

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/grape/5-2-grape-png.png",
                "Denmark Grapes", "625.00", ""))

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/orange/3-2-orange-png-image.png",
                "Nagpur Orange", "65.00", ""))

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/eggplant/2-2-eggplant-png-clipart.png",
                "Organic Brinjal", "64.00", ""))

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/grape/5-2-grape-png.png",
                "Denmark Grapes", "625.00", ""))

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/orange/3-2-orange-png-image.png",
                "Nagpur Orange", "65.00", ""))

            newArrivalListData.add(CustomCategory("https://freepngimg.com/thumb/eggplant/2-2-eggplant-png-clipart.png",
                "Organic Brinjal", "64.00", ""))

            return newArrivalListData
        }
    }
}