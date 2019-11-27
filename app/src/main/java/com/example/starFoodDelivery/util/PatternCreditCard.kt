package com.example.starFoodDelivery.util

import java.util.regex.Pattern

object PatternCreditCard {

    val PATTERNCARD = Pattern.compile("\\b([0-9]{4})[0-9]{0,9}([0-9]{4})\\b")
    val MASKCARD = "$1-XXXX-XXXX-$2"

}