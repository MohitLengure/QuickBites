package com.example.quickbites

import adapter.CartAdapter
import adapter.MenuAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbites.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val MenuFoodName= listOf("Burger","Sandwich","Momo","Roll")
        val MenuItemPrice= listOf("99Rs","101Rs","89Rs","99Rs")
        val MenuImage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momos,
            R.drawable.roll
        )
        val adapter= MenuAdapter(
            ArrayList(MenuFoodName),
            ArrayList(MenuItemPrice),
            ArrayList(MenuImage))
        binding.menuRecycleView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter=adapter
        return binding.root
    }


    companion object {

    }
}