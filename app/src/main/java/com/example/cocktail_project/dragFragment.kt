package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [dragFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private class MyDragShadowBuilder1(v: View) : View.DragShadowBuilder(v) {

    private val shadow = ColorDrawable(Color.LTGRAY)

    //드래그 그림자 크기 정하기
    override fun onProvideShadowMetrics(size: Point, touch: Point) {

        val width: Int = view.width / 2

        val height: Int = view.height / 2

        // 드래그 섀도우는 ColorDrawable
        // 캔버스 채우기
        shadow.setBounds(0, 0, width, height)

        // 크기 매개변수의 너비와 높이 값을 설정
        size.set(width, height)

        // 터치 포인트의 위치를 드래그 그림자의 중앙으로 설정
        touch.set(width / 2, height / 2)
    }

    // 시스템이 캔버스에 끌기 그림자를 그리기
    // onProvideShadowMetrics()에 전달된 rht==에서 구성
    override fun onDrawShadow(canvas: Canvas) {

        //canvasa에 ColorDrawable을 그립니다.
        shadow.draw(canvas)
    }
}

class dragFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root_view = inflater.inflate(R.layout.fragment_drag, container, false)
        var img_view = root_view.findViewById<ImageView>(R.id.iv_move)
        var img_view2 = root_view.findViewById<ImageView>(R.id.target_glass)
        img_view2.setOnDragListener { v, e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED -> {

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
        img_view.apply{
            setOnLongClickListener { v ->
                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the ImageView object's tag.
                val item = ClipData.Item(v.tag as? CharSequence)

                // Create a new ClipData using the tag as a label, the plain text MIME type, and
                // the already-created item. This creates a new ClipDescription object within the
                // ClipData and sets its MIME type to "text/plain".
                val dragData = ClipData(
                    v.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item)

                // Instantiate the drag shadow builder.
                val myShadow = MyDragShadowBuilder1(this)

                // Start the drag.
                v.startDragAndDrop(dragData,  // The data to be dragged
                    myShadow,  // The drag shadow builder
                    null,      // No need to use local data
                    0          // Flags (not currently used, set to 0)
                )

                // Indicate that the long-click was handled.
                true
            }

        }
        // Inflate the layout for this fragment
        return root_view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment dragFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            dragFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

