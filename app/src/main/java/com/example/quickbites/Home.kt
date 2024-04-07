package com.example.quickbites


import adapter.PopularAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.quickbites.databinding.FragmentHomeBinding


class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)

        binding.ViewAllMenu.setOnClickListener{
            val bottomSheetDialog =MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist,ScaleTypes.FIT)



        imageSlider.setItemClickListener(object:ItemClickListener{
            override fun doubleClick(position: Int) {

            }

            override fun onItemSelected(position: Int) {
              // val itemPosition = imagelist[position]
                val itemMessage="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName =listOf("Burger")
        val price = listOf("99Rs")
        val popularFoodImages= listOf(
            R.drawable.burger,
         )

        val adapter= PopularAdapter(foodName,price,popularFoodImages)
        binding.popularrecyleView.layoutManager=LinearLayoutManager(requireContext())
        binding.popularrecyleView.adapter =adapter


    }

}