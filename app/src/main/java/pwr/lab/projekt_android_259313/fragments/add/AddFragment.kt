package pwr.lab.projekt_android_259313.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import pwr.lab.projekt_android_259313.R
import pwr.lab.projekt_android_259313.data.Event
import pwr.lab.projekt_android_259313.data.EventViewModel

class AddFragment : Fragment() {

    private lateinit var mEventViewModel: EventViewModel
    lateinit var saveButton: Button
    lateinit var descriptionPlace: EditText
    lateinit var eventNamePlace: EditText
    lateinit var eventDate: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        saveButton = view.findViewById(R.id.button)
        eventDate = view.findViewById(R.id.calendar)
        mEventViewModel = ViewModelProvider(this)[EventViewModel::class.java]
        saveButton.setOnClickListener {
            insertDataToDatabase()
        }


        /*val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MONTH, 1)
        val currentDate: Date = cal.time*/

        return view
    }

    private fun insertDataToDatabase() {

        val eventDate = eventDate.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val Date = (dayOfMonth.toString() + '/'
                    + (month + 1) + '/' + year)
            //eventDate.setDate(Date.toLong())
            //Toast.makeText(requireContext(), Date, Toast.LENGTH_SHORT).show()
            eventDate.date
        }

        descriptionPlace = view!!.findViewById(R.id.opis)
        eventNamePlace = view!!.findViewById(R.id.nazwaWydarzenia)
        //eventDate = view!!.findViewById(R.id.calendar)


        val eventName = eventNamePlace.text.toString()
        val eventDescription = descriptionPlace.text.toString()
        //val eventDate = eventDate.date

        if (inputCheck(eventName, eventDescription, eventDate.toString()) {
                // Create Event Object
                val event = Event(0, eventName, eventDescription, eventDate.toString())
                // Add Data to Database
                mEventViewModel.addEvent(event)
                Toast.makeText(
                    requireContext(),
                    " Udało się dodać nowe wydarzenie!",
                    Toast.LENGTH_LONG
                ).show()
                // Navigate Back
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }) else {
            Toast.makeText(requireContext(), "Uzupełnij wszystkie pola.", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(
        eventName: String,
        eventDescription: String,
        eventDate: String,
        function: () -> Unit
    ): Boolean{
        return !(TextUtils.isEmpty(eventName) || TextUtils.isEmpty(eventDescription) || TextUtils.isEmpty(eventDate))
    }
}