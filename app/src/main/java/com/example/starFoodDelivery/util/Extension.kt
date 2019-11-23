package com.example.starFoodDelivery.util

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Activity.toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()
fun Activity.toast(id: Int) = Toast.makeText(this, getText(id), Toast.LENGTH_LONG).show()
fun Fragment.toast(text: String) = Toast.makeText(context, text, Toast.LENGTH_LONG).show()
fun Fragment.toast(id: Int) = Toast.makeText(context, getText(id), Toast.LENGTH_LONG).show()

fun Any.showELog(log: String) = Log.e(this::class.java.simpleName, log)
fun Any.showELog(log: Throwable) = Log.e(this::class.java.simpleName, log.message)

fun Any.TAG() = this::class.java.simpleName

var Any.TAG: String
    get() = this::class.java.simpleName
    set(value) {
        TAG = value
    }


fun MutableList<View?>.visibility(visibility: Int) = this.forEach { it?.visibility = visibility }

infix fun <T> Boolean.then(param: T): T? = if (this) param else null

fun TextView.formatText(id: Int, vararg args: Any?){
    this.text = String.format(context.getString(id), *args)
}

fun TextView.text(text: String){ this.text = text }

fun EditText.text() = this.text.toString()

fun Fragment.getSimpleName(): String = this::class.java.simpleName

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
