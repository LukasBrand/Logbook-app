package de.lukasbrand.logbook.trip

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import de.lukasbrand.logbook.R
import de.lukasbrand.logbook.databinding.TripListFragmentBinding

class TripListFragment : Fragment() {

    private lateinit var viewModel: TripListViewModel
    private lateinit var binding: TripListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(TripListViewModel::class.java)

        binding = TripListFragmentBinding.inflate(inflater, container, false)

        binding.addTripButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_tripListFragment_to_tripFragment)
        )

        binding.exportButton.visibility = View.INVISIBLE
        binding.exportButton.setOnClickListener {

        }

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, viewModel.trips)

        binding.tripRecyclerView.adapter = adapter

        return binding.root
    }

}