package com.example.akujuga.splash.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.akujuga.R
import com.example.akujuga.splash.onboarding.screens.FirstScreen
import com.example.akujuga.splash.onboarding.screens.LastScreen
import com.example.akujuga.splash.onboarding.screens.WelcomeScreen

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        val fragmentList = arrayListOf<Fragment>(
            WelcomeScreen(),
            FirstScreen(),
            LastScreen()
        )

        val adapter = ViewPagerAdapter (
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter

        return view
    }

}