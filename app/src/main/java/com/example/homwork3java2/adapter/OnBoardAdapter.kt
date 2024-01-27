package com.example.homwork3java2.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homwork3java2.fragment.onboard.OnBoardPageFirst
import com.example.homwork3java2.fragment.onboard.OnBoardPageSecond
import com.example.homwork3java2.fragment.onboard.OnBoardPageThird

class OnBoardAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardPageFirst()
            1 -> OnBoardPageSecond()
            else -> OnBoardPageThird()
        }
    }
}