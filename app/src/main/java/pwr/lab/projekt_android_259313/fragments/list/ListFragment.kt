package pwr.lab.projekt_android_259313.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pwr.lab.projekt_android_259313.R
import pwr.lab.projekt_android_259313.data.EventViewModel

class ListFragment : Fragment() {
        private lateinit var addButton: FloatingActionButton;
        private lateinit var mEventViewModel: EventViewModel;
        private lateinit var recyclerViewview: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        addButton = view.findViewById(R.id.floatingActionButton)
        recyclerViewview = view.findViewById(R.id.recyclerView)

        val adapter = ListAdapter()
        val recyclerView = recyclerViewview

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mEventViewModel = ViewModelProvider(this)[EventViewModel::class.java]
        mEventViewModel.readAllData.observe(viewLifecycleOwner, Observer {event ->
            adapter.setData(event)
        })


        addButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }
}