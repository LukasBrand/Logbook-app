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

    lateinit var binding: TripFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        return binding.root
    }

}