package com.printf.kidsteacher.fragment

import android.app.Dialog
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.printf.kidsteacher.R
import com.printf.kidsteacher.been.ReadBeen
import com.printf.kidsteacher.common.PrintfGlobal
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.fragment_drawing.*
import top.defaults.colorpicker.ColorPickerPopup
import top.defaults.colorpicker.ColorPickerPopup.ColorPickerObserver
import java.util.*

class WriteDetailFragment : BaseFragment(), View.OnClickListener {

    var list = ArrayList<ReadBeen>()
    var smallBrush = 0f
    var mediumBrush = 0f
    var largeBrush = 0f
    var currPaint: ImageView? = null
    var isEraser = false
    var type = ""
    var position = 0;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drawing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.IsBrush = false

        //get the palette and first color button

        smallBtn.setOnClickListener{
            brushType(4)
            isEraser = false
            MainActivity.IsBrush = false
            smallBtn.setBackgroundResource(R.drawable.slected_tool_bg)
            mediumBtn.setBackgroundResource(R.color.mediumBrusg)
            largeBtn.setBackgroundResource(R.color.largeBrusg)
            eraseBtn.setBackgroundResource(R.color.app_color)
            btn_brush.setBackgroundResource(R.color.colorAccent)
        }
        mediumBtn.setOnClickListener{
            brushType(6)
            isEraser = false
            MainActivity.IsBrush = false
            smallBtn.setBackgroundResource(R.color.smallBrusg)
            mediumBtn.setBackgroundResource(R.drawable.slected_tool_bg)
            largeBtn.setBackgroundResource(R.color.largeBrusg)
            eraseBtn.setBackgroundResource(R.color.app_color)
            btn_brush.setBackgroundResource(R.color.colorAccent)
        }
        largeBtn.setOnClickListener{
            brushType(5)
            isEraser = false
            MainActivity.IsBrush = false
            smallBtn.setBackgroundResource(R.color.smallBrusg)
            mediumBtn.setBackgroundResource(R.color.mediumBrusg)
            largeBtn.setBackgroundResource(R.drawable.slected_tool_bg)
            eraseBtn.setBackgroundResource(R.color.app_color)
            btn_brush.setBackgroundResource(R.color.colorAccent)
        }

        drawBtn.setOnClickListener {
            MainActivity.IsBrush = false
            //draw button clicked
            val brushDialog = Dialog(requireContext())
            brushDialog.setTitle("Brush size:")
            brushDialog.setContentView(R.layout.brush_chooser)
            //listen for clicks on size buttons
            val smallBtn = brushDialog.findViewById<ImageView>(R.id.small_brush)
            smallBtn.setOnClickListener { brushDialog.dismiss() }
            val mediumBtn = brushDialog.findViewById<ImageView>(R.id.medium_brush)
            mediumBtn.setOnClickListener { brushDialog.dismiss() }
            val largeBtn = brushDialog.findViewById<ImageView>(R.id.large_brush)
            largeBtn.setOnClickListener { brushDialog.dismiss() }
            //show and wait for user interaction
            brushDialog.show()
        }

        iv_picker.setOnClickListener{

            ColorPickerPopup.Builder(requireContext())
                    .initialColor(Color.RED) // Set initial color
                    .enableBrightness(false) // Enable brightness slider or not
                    .enableAlpha(false) // Enable alpha slider or not
                    .okTitle(getString(R.string.done))
                    .cancelTitle("Cancel")
                    .showIndicator(false)
                    .showValue(false)
                    .build()
                    .show(object : ColorPickerObserver() {
                        override fun onColorPicked(color: Int) {
                            Log.e("TAG", "color = $color")
                            isEraser = false
                            val strColor = String.format("#%06X", 0xFFFFFF and color)
                            Log.e("TAG", "strColor = $strColor")
                            drawingView.setColor(color)
                            currPaint!!.setImageDrawable(resources.getDrawable(R.drawable.paint))
                        }
                    })
        }
        eraseBtn.setOnClickListener{
            brushType(1)
            isEraser = true
            MainActivity.IsBrush = false
            smallBtn.setBackgroundResource(R.color.smallBrusg)
            mediumBtn.setBackgroundResource(R.color.mediumBrusg)
            largeBtn.setBackgroundResource(R.color.largeBrusg)
            eraseBtn.setBackgroundResource(R.drawable.slected_eraser_bg)
            btn_brush.setBackgroundResource(R.color.colorAccent)
        }
        btn_brush.setOnClickListener {
            brushType(7)
            isEraser = false
            MainActivity.IsBrush = true
            smallBtn.setBackgroundResource(R.color.smallBrusg)
            mediumBtn.setBackgroundResource(R.color.mediumBrusg)
            largeBtn.setBackgroundResource(R.color.largeBrusg)
            eraseBtn.setBackgroundResource(R.color.app_color)
            btn_brush.setBackgroundResource(R.drawable.slected_fill_bg)
        }

        //get the palette and first color button
        currPaint = paint_colors.getChildAt(0) as ImageButton
        currPaint?.setImageDrawable(resources.getDrawable(R.drawable.paint_pressed))

        //sizes from dimensions

        //sizes from dimensions
        smallBrush = resources.getInteger(R.integer.small_size).toFloat()
        mediumBrush = resources.getInteger(R.integer.medium_size).toFloat()
        largeBrush = resources.getInteger(R.integer.large_size).toFloat()


        type = arguments?.getString("SubCategory").toString()
        position = arguments?.getInt("Position")!!

        if (type.equals(getString(R.string.alphabets), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getAlphabet_())
        } else if (type.equals(getString(R.string.numbers), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromNumbers_())
        } else if (type.equals(getString(R.string.shapes), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromShape_())
        } else if (type.equals(getString(R.string.colors), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromColors_())
        } else if (type.equals(getString(R.string.days), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromDays_())
        } else if (type.equals(getString(R.string.months), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromMonths_())
        } else if (type.equals(getString(R.string.animals), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromAnimals_())
        } else if (type.equals(getString(R.string.body_parts), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromBodyParts_())
        } else if (type.equals(getString(R.string.fruits), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromFruits_())
        } else if (type.equals(getString(R.string.transport), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromTransport_())
        } else if (type.equals(getString(R.string.proffesion), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromProfession_())
        } else if (type.equals(getString(R.string.sport), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromSports_())
        } else if (type.equals(getString(R.string.bird), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromBirds_())
        } else if (type.equals(getString(R.string.building), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromBuilding_())
        } else if (type.equals(getString(R.string.flower), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromFlower_())
        } else if (type.equals(getString(R.string.fruit_tree), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromFruitTree_())
        } else if (type.equals(getString(R.string.vegetable), ignoreCase = true)) {
            list.clear()
            list.addAll(PrintfGlobal.getFromVegetable_())
        }


        smallBtn.setBackgroundResource(R.drawable.slected_tool_bg)
        val icon = BitmapFactory.decodeResource(activity!!.resources, list[position].img)
        drawingView.setForeGroundBitmap(icon)
        drawingView.setBackGroundBitmap(icon)

        drawingView.setColor(Color.parseColor("#FF660000"))
        drawingView.setBrushMode(4)

        iv_clear.setOnClickListener {
            drawingView.clearCanvas()
            drawingView.resetView()
            val icon = BitmapFactory.decodeResource(activity!!.resources, list[position].img)
            drawingView.setForeGroundBitmap(icon)
            drawingView.setBackGroundBitmap(icon)
        }


        colorOne.setOnClickListener(this)
        colorTwo.setOnClickListener (this)
        colorThree.setOnClickListener (this)
        colorFour.setOnClickListener (this)
        colorFive.setOnClickListener (this)
        colorSix.setOnClickListener (this)
        colorSeven.setOnClickListener (this)
        colorEight.setOnClickListener (this)

    }


    fun brushType(type: Int) {
        drawingView.setBrushMode(type)
    }

    fun paintClicked(view: View) {
        //use chosen color
        if (isEraser) {
            Toast.makeText(activity, "Eraser is selected. You can not select color.", Toast.LENGTH_LONG).show()
            return
        }
        if (view !== currPaint) {
            val imgView = view as ImageButton
            val color = view.getTag().toString()
            //update ui
            imgView.setImageDrawable(resources.getDrawable(R.drawable.paint_pressed))
            currPaint!!.setImageDrawable(resources.getDrawable(R.drawable.paint))
            currPaint = view
            drawingView.setColor(Color.parseColor(color))
        }
    }

    override fun onClick(v: View?) {
        paintClicked(v!!)
    }
}