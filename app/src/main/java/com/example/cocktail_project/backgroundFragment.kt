package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.content.IntentSender.OnFinished
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils.replace
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.fragment_background.*
import android.os.Handler
import android.os.Looper


class backgroundFragment : Fragment() {

    lateinit var alcholFragment: AlcholFragment
    lateinit var drinkFragment: DrinkFragment
    lateinit var garnishFragment: GarnishFragment

    //힌트 기능 구현
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            recipe.visibility = View.INVISIBLE
            recipea.visibility = View.INVISIBLE
            recipeb.visibility = View.INVISIBLE
            recipec.visibility = View.INVISIBLE
            reciped.visibility = View.INVISIBLE
        },0L) // 처음에는 안뜨게 하기

        Handler(Looper.getMainLooper()).postDelayed({
            recipe.visibility = View.VISIBLE
            recipea.visibility = View.VISIBLE
            recipeb.visibility = View.VISIBLE
            recipec.visibility = View.VISIBLE
            reciped.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                recipe.visibility = View.INVISIBLE
                recipea.visibility = View.INVISIBLE
                recipeb.visibility = View.INVISIBLE
                recipec.visibility = View.INVISIBLE
                reciped.visibility = View.INVISIBLE
            },2500L) // 텍스트뷰 잠시 뜨는 시간
        },10000L) // 지연시간

        Handler(Looper.getMainLooper()).postDelayed({
            timerTxt.visibility = View.INVISIBLE
        },10000L)

        val countDown = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerTxt.setText("힌트 등장 " +millisUntilFinished / 1000 + "초 전" ).toString()
            }
            override fun onFinish() {
                timerTxt.setText("힌트 없음").toString()
                Handler(Looper.getMainLooper()).postDelayed({
                    timerTxt.visibility = View.VISIBLE
                },2500L)
            }
        }.start()

        alcholFragment = AlcholFragment()
        drinkFragment = DrinkFragment()
        garnishFragment = GarnishFragment()
    }

    //탭 레이아웃 구현
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root_view = inflater.inflate(R.layout.fragment_background, container, false)
        var tab_layout = root_view.findViewById<TabLayout>(R.id.tab_layout)
        parentFragmentManager.beginTransaction().replace(R.id.frame_layout, alcholFragment).commit() //첫 Fragment

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        replaceView(alcholFragment)
                    }
                    1 -> {
                        replaceView(drinkFragment)
                    }
                    else -> {
                        replaceView(garnishFragment)
                    }
                }
            }

            private fun replaceView(tab: Fragment) {
//                var selectedFragment: Fragment? = null
//                selectedFragment = tab
//                selectedFragment?.let {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, tab)
                    .commit()

                //}
            }
        })

        //드래그 앤 드롭 기능
        var target_glass = root_view.findViewById<ImageView>(R.id.glass1)

        target_glass.setOnDragListener { v, e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED -> { //드래그 시작 (이미지를 끌었을 때)
                    // 드래그된 데이터를 accept 할 수 있는지 결정
                    if (e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        //드래그 되었을 때 확인하기 위해서 넣은 배경 색
                        (v as? ImageView)?.setColorFilter(Color.BLUE)
                        Toast.makeText(this.context, "ACTION STARTED", Toast.LENGTH_LONG)
                        // 다시 그리기 , 화면 갱신
                        v.invalidate()

                        //드래그 된 데이터 받았을 때 True
                        true
                    } else {
                        //끄는중 false, END가 될 때까지 이벤트 다시 수신 X
                        false
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    (v as? ImageView)?.setColorFilter(Color.GREEN)
                    Toast.makeText(this.context, "Drag Entered", Toast.LENGTH_LONG)

                    // 다시 그리기
                    v.invalidate()

                    // Returns true; the value is ignored.
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION ->
                    //이벤트 무시
                    true

                DragEvent.ACTION_DRAG_EXITED -> {
                    //파란색으로 재설정
                    (v as? ImageView)?.setColorFilter(Color.BLUE)
                    Toast.makeText(this.context, "Drag Exit", Toast.LENGTH_LONG)

                    //뷰 리셋
                    v.invalidate()

                    true
                }
                DragEvent.ACTION_DROP -> { //드랍했을 때
                    //드래그 된 데이터가..포함한? 항목을 가져옴
                    val item: ClipData.Item = e.clipData.getItemAt(0)

                    //텍스트 데이터 갖고오기
                    val dragData = item.text

                    // 드래그한 데이터가 포함된 메시지를 표시
                    Toast.makeText(this.context, "Dragged data $dragData", Toast.LENGTH_LONG).show()

                    // 색조 끄끼
                    (v as? ImageView)?.clearColorFilter()

                    (v as? ImageView)?.setImageResource(R.drawable.glass2)

                    v.invalidate()

                    //DragEvent.getResult()는 true를 반환
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    //색조 clear
                    (v as? ImageView)?.clearColorFilter()

                    //리셋
                    v.invalidate()

                    //getResult() 수행, 발생한 상황 표시
                    when(e.result) {
                        true ->
                            Toast.makeText(this.context, "The drop was handled.", Toast.LENGTH_LONG)
                        else ->
                            Toast.makeText(this.context, "The drop didn't work.", Toast.LENGTH_LONG)
                    }.show()

                //true 반환
                    true
                }
                else -> {
                    Log.e("DragDrop Example", "Unknown action type received by View.OnDragListener.")
                    false
                }
            }
        }
        //프래그먼트 레이아웃 확장
        return root_view
    }
}
