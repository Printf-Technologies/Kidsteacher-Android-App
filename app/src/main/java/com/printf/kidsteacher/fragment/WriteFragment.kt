package com.printf.kidsteacher.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.WriteDetailActivity
import com.printf.kidsteacher.adapter.ReadAdapter
import com.printf.kidsteacher.been.ReadBeen
import com.printf.kidsteacher.other.RecyclerViewClick
import kotlinx.android.synthetic.main.fragment_write.*
import java.util.*

class WriteFragment : BaseFragment(), RecyclerViewClick {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        var list = ArrayList<ReadBeen>()
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

        val gridLayoutManager = GridLayoutManager(getActivity(), 4)
        rv_write.layoutManager = gridLayoutManager
        rv_write.adapter = ReadAdapter(list, this)
    }


    override fun OnClick(img: Int, name: String?, position: Int) {
        if (isVisible && isAdded) {
            val intent = Intent(getActivity(), WriteDetailActivity::class.java)
            intent.putExtra("type", name)
            startActivity(intent)
            getActivity()!!.overridePendingTransition(R.anim.enter_left, R.anim.exit_right)
        }
    }
}