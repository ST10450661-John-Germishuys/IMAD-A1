import android.accounts.AuthenticatorDescription
import android.os.Bundle
package com.example.historicalevents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

}
   ///list of historical events along the years
   enum class HistoricalEvent(val year: Int, val description: String) {
   Event_1(1776, "Declaration of Independence in the United States"),
   Event_2(1969, "First moon landing by Apollo 11"),
   Event_3(1945, "End of World War II with surrender of Japan"),
   Event_4(1989, "Fall of the Berlin wall"),

       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           enableEdgeToEdge()
           setContentView(R.layout.activity_main)
           ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
               val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
               v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
               insets

   // Getting layout components
   val edtBirthYear = findViewById<EditText>(R.id.edtYear)
   val btnResult = findViewId<Button>(R.id.btnResults)
   val btnClear = findViewByid<Button>(R.id.btnClear)
   val txtResult = findViewBYid<TextView>(R.id.txtResults)

   //If user presses Display Results button
   btnResult?.setOnClickListener()
   {
       val birthYear = edtBirthYear.text.toString().toInt()


       if (birthYear != null && birthYear in 1500 .. 2024) {
           // Grabbing the values of the years in the list of Historical Events
           val eventYears = HistoricalEvent.values().map { it.year }


           val events = when (birthYear)

           {

           // This statement will run if the birth year matches yhe year of
           in eventYears -> {

               val event = HistoricalEvent.values().find { it.year == birthYear }
               listOf("in $birthYear: ${event?.description ?: "event"}")
           }
           // Map function will transform each enum constant into its corresponding year value
           // This statement will run if the birth year is one year after the historical event
           in eventYears.map { it - 1 } -> {
              val event = HistoricalEvent.values().find { it.year == + 1 }
              listOf("Your birth year is one year before the historical event of " +
                     "${event?.description ?: "event"}")

           }
            // This statement will be run if the birth year is one year after the historical event

            in eventYears.map { it + 1 } -> {
               val event = HistoricalEvent.values().find { it.year == birthYear - 1 }
               listOf("Your birth year is one year after the historical event of " +
                      "${event?.description ?: "event"}")

            }
            // This statement will be run if the birth year is not the same or is close to the year of the historical event

            else -> listOf("No historical events found for $birthYear.")

           }

           txtResult.text = events.joinToString("\n")
       }
       else
       {
           txtResult.text = "No event has been found from the input of your birth year."
       }

       // If user presses the clear button
       btnClear?.setOnClickListener() {
           edtBirthYear.text.clear()
           txtResult.text =""
       }
   }
}