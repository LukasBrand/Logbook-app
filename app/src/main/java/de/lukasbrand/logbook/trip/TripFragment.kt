package de.lukasbrand.logbook.trip

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import de.lukasbrand.logbook.R
import de.lukasbrand.logbook.databinding.TripFragmentBinding

class TripFragment : Fragment() {

    lateinit var viewModel: TripViewModel
    lateinit var binding: TripFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(TripViewModel::class.java)

        binding = TripFragmentBinding.inflate(inflater, container, false)

        binding.acceptButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_tripFragment_to_tripListFragment)
        )

        binding.currentLocationButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:latitude,longitude")
            }
            startActivity(intent)
        }

        setTripObserver()

        return binding.root
    }

    private fun setTripObserver() {
        viewModel.trip.observe(viewLifecycleOwner, { newTrip ->
            binding.kmBeginTextInput.setText(newTrip.kmBegin.toString())
            binding.kmEndTextInput.setText(newTrip.kmEnd.toString())
            binding.departureTextInput.setText(newTrip.departureLocation)
            binding.arrivalTextInput.setText(newTrip.arrivalLocation)
            binding.startTimeButton.text = newTrip.startTime.toString()
            binding.endTimeButton.text = newTrip.endTime.toString()
        })


    }

}