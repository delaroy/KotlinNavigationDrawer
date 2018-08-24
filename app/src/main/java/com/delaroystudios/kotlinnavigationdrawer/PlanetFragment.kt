package com.delaroystudios.kotlinnavigationdrawer


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.Locale

/**
 * Created by delaroy on 8/22/18.
 */
class PlanetFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val planetNumber = arguments.getInt(ARG_PLANET_NUMBER)
        val planet = resources.getStringArray(R.array.planets_array)[planetNumber]
        val imageId = resources.getIdentifier(planet.toLowerCase(Locale.getDefault()),
                "drawable", activity.packageName)
        activity.title = planet

        return inflater.inflate(R.layout.fragment_planet, container, false).apply {
            findViewById<ImageView>(R.id.image).setImageResource(imageId)
        }
    }

    companion object {
        private val ARG_PLANET_NUMBER = "planet_number"

        fun newInstance(position: Int) = PlanetFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_PLANET_NUMBER, position)
            }
        }
    }
}