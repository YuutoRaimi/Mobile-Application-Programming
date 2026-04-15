package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the ViewPager2 and TabLayout from the layout
        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)

        // Create an instance of our updated CafeAdapter
        val cafeAdapter = CafeAdapter(this)
        viewPager.adapter = cafeAdapter

        // Use TabLayoutMediator to link the TabLayout with the ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set the text for each tab based on its position
            tab.text = when (position) {
                0 -> getString(R.string.starbucks_title)
                1 -> getString(R.string.janjijiwa_title)
                2 -> getString(R.string.kopikenangan_title)
                else -> "" // Default case
            }
        }.attach() // This is crucial to connect the two components
    }
}
