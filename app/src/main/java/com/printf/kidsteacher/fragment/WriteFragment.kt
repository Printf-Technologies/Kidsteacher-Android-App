package com.printf.kidsteacher.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.DrawingActivity
import com.printf.kidsteacher.activity.WriteDetailActivity
import com.printf.kidsteacher.adapter.ReadAdapter
import com.printf.kidsteacher.been.ReadBeen
import com.printf.kidsteacher.common.PrintfGlobal
import com.printf.kidsteacher.other.RecyclerViewClick
import com.printf.kidsteacher.subcategory.SubCategoryActivity
import kotlinx.android.synthetic.main.fragment_write.*
import java.util.*

class WriteFragment : BaseFragment(), RecyclerViewClick {

    var mainCategory = ""
    var subCategory = ""
    var fragmentType = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainCategory = arguments?.getString("MainCategory").toString()
        subCategory = arguments?.getString("SubCategory").toString()
        fragmentType = arguments?.getString("FragmentType").toString()

        setAdapter()
    }

    private fun setAdapter() {
        var list = ArrayList<ReadBeen>()
        if (subCategory.isNullOrEmpty()) {
            list.add(ReadBeen(getString(R.string.alphabets), R.drawable.tile_alphabets))
            list.add(ReadBeen(getString(R.string.numbers), R.drawable.tile_number))
            list.add(ReadBeen(getString(R.string.shapes), R.drawable.tile_shape))
            list.add(ReadBeen(getString(R.string.colors), R.drawable.tile_color))
            list.add(ReadBeen(getString(R.string.days), R.drawable.tile_day))
            list.add(ReadBeen(getString(R.string.months), R.drawable.tile_month))
            list.add(ReadBeen(getString(R.string.animals), R.drawable.tile_animals))
            list.add(ReadBeen(getString(R.string.body_parts), R.drawable.tile_bodyparts))
            list.add(ReadBeen(getString(R.string.fruits), R.drawable.tile_fruits))
            list.add(ReadBeen(getString(R.string.transport), R.drawable.tile_transport))
            list.add(ReadBeen(getString(R.string.proffesion), R.drawable.tile_profession))
            list.add(ReadBeen(getString(R.string.sport), R.drawable.tile_sport))
            list.add(ReadBeen(getString(R.string.bird), R.drawable.tile_bird))
            list.add(ReadBeen(getString(R.string.building), R.drawable.tile_bulding))
            list.add(ReadBeen(getString(R.string.flower), R.drawable.tile_flowers))
            list.add(ReadBeen(getString(R.string.fruit_tree), R.drawable.tile_fruits_tree))
            list.add(ReadBeen(getString(R.string.vegetable), R.drawable.tile_vegetable))
        } else {
            if (subCategory.equals(getString(R.string.alphabets), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getAlphabet_())
            } else if (subCategory.equals(getString(R.string.numbers), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromNumbers_())
            } else if (subCategory.equals(getString(R.string.shapes), ignoreCase = true)) {
                list.addAll(PrintfGlobal.getFromShape_())
            } else if (subCategory.equals(getString(R.string.colors), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromColors_())
            } else if (subCategory.equals(getString(R.string.days), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromDays_())
            } else if (subCategory.equals(getString(R.string.months), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromMonths_())
            } else if (subCategory.equals(getString(R.string.animals), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromAnimals_())
            } else if (subCategory.equals(getString(R.string.body_parts), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromBodyParts_())
            } else if (subCategory.equals(getString(R.string.fruits), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromFruits_())
            } else if (subCategory.equals(getString(R.string.transport), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromTransport_())
            } else if (subCategory.equals(getString(R.string.proffesion), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromProfession_())
            } else if (subCategory.equals(getString(R.string.sport), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromSports_())
            } else if (subCategory.equals(getString(R.string.bird), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromBirds_())
            } else if (subCategory.equals(getString(R.string.building), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromBuilding_())
            } else if (subCategory.equals(getString(R.string.flower), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromFlower_())
            } else if (subCategory.equals(getString(R.string.fruit_tree), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromFruitTree_())
            } else if (subCategory.equals(getString(R.string.vegetable), ignoreCase = true)) {
                list.clear()
                list.addAll(PrintfGlobal.getFromVegetable_())
            }
        }

        val gridLayoutManager = GridLayoutManager(requireContext(), 4)
        rv_write.layoutManager = gridLayoutManager
        rv_write.adapter = ReadAdapter(list, this)
    }


    override fun OnClick(img: Int, name: String?, position: Int) {
        if (isVisible && isAdded) {
            if (subCategory.isNullOrEmpty()) {
                val intent = Intent(requireContext(), SubCategoryActivity::class.java)
                intent.putExtra("MainCategory", mainCategory)
                intent.putExtra("SubCategory", name)
                intent.putExtra("FragmentType", fragmentType)
                startActivity(intent)
                requireActivity().overridePendingTransition(R.anim.enter_left, R.anim.exit_right)
            } else {

                val intent = Intent(activity, DrawingActivity::class.java)
                intent.putExtra("type", name)
                intent.putExtra("title", name)
                intent.putExtra("position", position)
                startActivity(intent)
                requireActivity().overridePendingTransition(R.anim.enter_left, R.anim.exit_right)

                /*val intent = Intent(requireContext(), WriteDetailActivity::class.java)
                intent.putExtra("type", name)
                startActivity(intent)
                requireActivity().overridePendingTransition(R.anim.enter_left, R.anim.exit_right)*/
            }
        }
    }
}