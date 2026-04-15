package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    // This method returns the total number of tabs/fragments
    override fun getItemCount(): Int = 3

    /**
     * This method is called by the ViewPager2 to get the fragment for a specific position.
     * We use a 'when' statement to determine which fragment to create.
     */
    override fun createFragment(position: Int): Fragment {
        // Get the description string based on the tab position
        val description = when (position) {
            0 -> fragment.getString(R.string.starbucks_desc)
            1 -> fragment.getString(R.string.janjijiwa_desc)
            2 -> fragment.getString(R.string.kopikenangan_desc)
            else -> "" // Default case
        }

        // Create a new instance of CafeDetailFragment and pass the description
        return CafeDetailFragment.newInstance(description)
    }
}