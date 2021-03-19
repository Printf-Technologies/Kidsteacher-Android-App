package com.printf.kidsteacher.fragment

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.DetailViewModel
import com.printf.kidsteacher.adapter.ViewPagerAdapter
import com.printf.kidsteacher.been.ViewModel
import com.printf.kidsteacher.common.PrintfGlobal
import com.printf.kidsteacher.dialog.CompleteDialog
import com.printf.kidsteacher.other.OnListItemClick
import com.printf.kidsteacher.view.SwiperViewPager.SwiperListener
import kotlinx.android.synthetic.main.fragment_read_detail.*
import java.util.*
import kotlin.collections.ArrayList

class ReadDetailFragment : BaseFragment(), View.OnClickListener, MediaPlayer.OnCompletionListener {

    private lateinit var viewModel: DetailViewModel
    var viewModels = ArrayList<ViewModel>()

    private var isAutoSouffle = false
    private var isSpeakerOn = true
    var currentPage = 0

    private var mp: MediaPlayer? = null
    private var audioManager: AudioManager? = null
    var viewPagerAdapter: ViewPagerAdapter? = null

    var timer: Timer? = null
    val DELAY_MS: Long = 2200
    val PERIOD_MS: Long = 2200
    var handler: Handler? = null

    var type = ""
    var reads: Array<String>? = null

    var completeDialog: CompleteDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[DetailViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.repeatPlayObservable.observe(this, Observer<Boolean> { item ->
            if (viewModels[currentPage].music != -1) {
                stopAutoSouffle()
                playMusic(viewModels[currentPage].music)
            }
        })

        viewModel.isSpeakerOnObservable.observe(this, Observer<Boolean> { item ->
            isSpeakerOn = item
            if (isSpeakerOn == false) {
                stopMusic()
            }
            if (isAutoSouffle && isSpeakerOn == false) {
                callMuteinAutoSuffle()
            } else {
                if (timer != null) {
                    timer!!.cancel()
                    val runnable = Runnable { nextMusic() }
                    handler = Handler()
                    handler!!.postDelayed(runnable, 300)
                }
            }
        })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_read_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reads = arrayOf(getString(R.string.alphabets), getString(R.string.numbers), getString(R.string.shapes), getString(R.string.colors),
                getString(R.string.days), getString(R.string.months), getString(R.string.animals), getString(R.string.body_parts),
                getString(R.string.fruits), getString(R.string.transport), getString(R.string.proffesion), getString(R.string.sport),
                getString(R.string.bird), getString(R.string.building), getString(R.string.flower), getString(R.string.fruit_tree),
                getString(R.string.vegetable))

        completeDialog = object : CompleteDialog(requireContext()) {
            override fun onStartAgain() {
                currentPage = -1
                autoSouffle()

            }

            override fun onGoToNext() {
                currentPage = 0;
                for (i in reads?.indices!!) {
                    if (reads?.get(i).equals(type, ignoreCase = true)) {
                        type = if (i == reads?.size!! - 1) {
                            reads?.get(0)!!
                        } else {
                            reads?.get(i + 1)!!
                        }
                        break
                    }
                }

                viewModel.setPosition(currentPage)
                viewModel.setSubCategory(type)

                startInit()
            }

        }

        /*ll_repeat.setOnClickListener(this)
        ripple_repeat.setOnClickListener(this)
        ripple_sound.setOnClickListener(this)
        */

        imgBack.setOnClickListener {
            if (currentPage > 0) {
                currentPage--
            }
            viewPager.currentItem = currentPage
            viewModel.setPosition(currentPage)
            stopAutoSouffle()
        }
        ivStarAutoSlide.setOnClickListener {
            if (isAutoSouffle) {
                stopAutoSouffle()
            } else {
                if (currentPage == viewModels.size - 1) {
                    currentPage = -1
                }
                autoSouffle()
            }
        }
        imgPrevious.setOnClickListener {
            if (currentPage == viewModels.size - 1) {
                completeDialog?.show()
                return@setOnClickListener
            }
            if (currentPage < viewModels.size - 1) {
                currentPage++
            }
            viewPager.currentItem = currentPage
            viewModel.setPosition(currentPage)
            stopAutoSouffle()
        }

        type = arguments?.getString("SubCategory").toString()
        currentPage = arguments?.getInt("Position")!!

        mp = MediaPlayer()
        mp?.isLooping = false
        mp?.setVolume(100f, 100f)
        audioManager = requireActivity().getSystemService(Context.AUDIO_SERVICE) as AudioManager?
        setAdapter()
        startInit()
    }

    fun startInit() {
        viewModels.clear()
        if (type.equals(getString(R.string.alphabets), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromAlphabets())
        } else if (type.equals(getString(R.string.numbers), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromNumbers())
        } else if (type.equals(getString(R.string.shapes), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromShape())
        } else if (type.equals(getString(R.string.colors), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromColors())
        } else if (type.equals(getString(R.string.days), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromDays())
        } else if (type.equals(getString(R.string.months), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromMonths())
        } else if (type.equals(getString(R.string.animals), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromAnimals())
        } else if (type.equals(getString(R.string.body_parts), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromBodyParts())
        } else if (type.equals(getString(R.string.fruits), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromFruits())
        } else if (type.equals(getString(R.string.transport), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromTransport())
        } else if (type.equals(getString(R.string.proffesion), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromProfession())
        } else if (type.equals(getString(R.string.sport), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromSports())
        } else if (type.equals(getString(R.string.bird), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromBirds())
        } else if (type.equals(getString(R.string.building), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromBuilding())
        } else if (type.equals(getString(R.string.flower), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromFlower())
        } else if (type.equals(getString(R.string.fruit_tree), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromFruitTree())
        } else if (type.equals(getString(R.string.vegetable), ignoreCase = true)) {
            viewModels.addAll(PrintfGlobal.getFromVegetable())
        }

        viewPagerAdapter?.updateData(viewModels, type)
        viewPager.currentItem = currentPage
        setProgress()

        if (viewModels[currentPage].music != -1) {
            playMusic(viewModels[currentPage].music)
        }

    }

    override fun onClick(v: View?) {
    }

    private fun setAdapter() {
        viewPagerAdapter = ViewPagerAdapter(requireContext(), object : OnListItemClick {
            override fun playThisMusic(music: Int) {
                if (music != -1) {
                    stopAutoSouffle()
                    playMusic(music)
                }
            }

            override fun playThisMusic(music: ByteArray) {}
        })
        viewPager.adapter = viewPagerAdapter

        viewPager.setmSwiperListener(object : SwiperListener {
            override fun onLeftSwipe(): Boolean {
                stopAutoSouffle()
                return false
            }

            override fun onRightSwipe(): Boolean {
                if (currentPage == viewModels.size - 1) {
                    if (completeDialog != null && !completeDialog?.isShowing!!) completeDialog?.show()
                }
                stopAutoSouffle()
                return false
            }
        })
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                currentPage = position
                if (viewModels[currentPage].music != -1) {
                    playMusic(viewModels[currentPage].music)
                    setProgress()
                }
                viewModel.setPosition(currentPage)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setProgress() {
        tv_count.text = (currentPage + 1).toString() + " / " + viewModels.size
    }

    private fun playMusic(music: Int) {
        if (!isSpeakerOn) return
        if (viewPager == null) return
        if (viewModels == null || viewModels.size == 0) return
        if (mp == null) {
            mp = MediaPlayer()
        }
        mp!!.reset() // stops any current playing song
        mp = MediaPlayer.create(requireContext(), music)
        mp?.start() // starting mediaplayer
        mp?.setOnCompletionListener(this)
    }

    private fun stopAutoSouffle() {
        ivStarAutoSlide.setImageResource(R.drawable.ic_play)
        isAutoSouffle = false
        if (timer != null) {
            timer!!.cancel()
        }
    }


    override fun onCompletion(mp: MediaPlayer?) {
        if (isSpeakerOn && isAutoSouffle) {
            Handler().postDelayed({
                if (isSpeakerOn && isAutoSouffle) {
                    nextMusic()
                }
            }, 800)
        }
    }

    private fun nextMusic() {
        if (currentPage == viewModels.size - 1) {
            stopAutoSouffle()
            completeDialog?.show()
        } else {
            currentPage++
        }
        viewPager.setCurrentItem(currentPage, true)
    }

    private fun autoSouffle() {
        ivStarAutoSlide.setImageResource(R.drawable.ic_musicstop)
        isAutoSouffle = true
        nextMusic()
        if (!isSpeakerOn) {
            handler = Handler()
            val Update = Runnable { if (!isSpeakerOn) nextMusic() }
            timer = Timer()
            timer!!.schedule(object : TimerTask() {
                override fun run() {
                    handler!!.post(Update)
                }
            }, DELAY_MS, PERIOD_MS)
        }
    }

    private fun callMuteinAutoSuffle() {
        handler = Handler()
        val Update = Runnable { if (!isSpeakerOn) nextMusic() }
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler!!.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
    }

    private fun stopMusic() {
        mp!!.stop()
    }

    override fun onPause() {
        if (mp != null) {
            mp!!.pause()
        }
        stopAutoSouffle()
        super.onPause()
    }

    override fun onDestroy() {

        if (mp != null) {
            mp!!.release()
        }
        super.onDestroy()
    }

}