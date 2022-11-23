package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.os.Bundle
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


class backgroundFragment : Fragment() {
    lateinit var alcholFragment: AlcholFragment
    lateinit var drinkFragment: DrinkFragment
    lateinit var garnishFragment: GarnishFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alcholFragment = AlcholFragment()
        drinkFragment = DrinkFragment()
        garnishFragment = GarnishFragment()


    }

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

        var target_glass = root_view.findViewById<ImageView>(R.id.blank_glass)

        target_glass.setOnDragListener { v, e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    // Determines if this View can accept the dragged data.
                    if (e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        // As an example of what your application might do, applies a blue color tint
                        // to the View to indicate that it can accept data.
                        (v as? ImageView)?.setColorFilter(Color.BLUE)
                        Toast.makeText(this.context, "ACTION STARTED", Toast.LENGTH_LONG)
                        // Invalidate the view to force a redraw in the new tint.
                        v.invalidate()

                        // Returns true to indicate that the View can accept the dragged data.
                        true
                    } else {
                        // Returns false to indicate that, during the current drag and drop operation,
                        // this View will not receive events again until ACTION_DRAG_ENDED is sent.
                        false
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Applies a green tint to the View.
                    (v as? ImageView)?.setColorFilter(Color.GREEN)
                    Toast.makeText(this.context, "Drag Entered", Toast.LENGTH_LONG)

                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate()

                    // Returns true; the value is ignored.
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION ->
                    // Ignore the event.
                    true

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Resets the color tint to blue.
                    (v as? ImageView)?.setColorFilter(Color.BLUE)
                    Toast.makeText(this.context, "Drag Exit", Toast.LENGTH_LONG)

                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate()

                    // Returns true; the value is ignored.
                    true
                }
                DragEvent.ACTION_DROP -> {
                    // Gets the item containing the dragged data.
                    val item: ClipData.Item = e.clipData.getItemAt(0)

                    // Gets the text data from the item.
                    val dragData = item.text

                    // Displays a message containing the dragged data.
                    Toast.makeText(this.context, "Dragged data $dragData", Toast.LENGTH_LONG).show()

                    // Turns off any color tints.
                    (v as? ImageView)?.clearColorFilter()

                    (v as? ImageView)?.setImageResource(R.drawable.bloodycocktail)

                    // Invalidates the view to force a redraw.
                    v.invalidate()

                    // Returns true. DragEvent.getResult() will return true.
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    // Turns off any color tinting.
                    (v as? ImageView)?.clearColorFilter()

                    // Invalidates the view to force a redraw.
                    v.invalidate()

                    // Does a getResult(), and displays what happened.
                    when(e.result) {
                        true ->
                            Toast.makeText(this.context, "The drop was handled.", Toast.LENGTH_LONG)
                        else ->
                            Toast.makeText(this.context, "The drop didn't work.", Toast.LENGTH_LONG)
                    }.show()

                    // Returns true; the value is ignored.
                    true
                }
                else -> {
                    // An unknown action type was received.
                    Log.e("DragDrop Example", "Unknown action type received by View.OnDragListener.")
                    false
                }
            }
        }
        // Inflate the layout for this fragment
        return root_view
    }
}
