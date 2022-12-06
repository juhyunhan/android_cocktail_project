package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.cocktail_project.databinding.ItemBaseBinding
import com.example.cocktail_project.repository.Item

//val context: Context, val datalist: ArrayList<Item>
class Adapter(val nameArray: ArrayList<Item>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    //val databas = Firebase.database
    //val itemRef = databas.reference
    //val arraylist = ArrayList<Item>()
    class ViewHolder(private val binding: ItemBaseBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item){

            Glide.with(itemView.context)
                .load(item.profile)
                .into(binding.drinkimage)
            binding.drinkname.text = item.name

            binding.itemCard.apply{
                setOnLongClickListener { v ->
                    // Create a new ClipData.
                    // This is done in two steps to provide clarity. The convenience method
                    // ClipData.newPlainText() can create a plain text ClipData in one step.

                    // Create a new ClipData.Item from the ImageView object's tag.
                    val item = ClipData.Item(binding.drinkname.text)

                    // Create a new ClipData using the tag as a label, the plain text MIME type, and
                    // the already-created item. This creates a new ClipDescription object within the
                    // ClipData and sets its MIME type to "text/plain".
                    val dragData = ClipData(
                        binding.drinkname.text,
                        arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                        item)

                    // Instantiate the drag shadow builder.
                    val myShadow = MyDragShadowBuilder(this)

                    // Start the drag.
                    // Drag Event 발생, Data를 넘김
                    v.startDragAndDrop(dragData,  // The data to be dragged
                        myShadow,  // The drag shadow builder
                        null,      // No need to use local data
                        0          // Flags (not currently used, set to 0)
                    )

                    // Indicate that the long-click was handled.
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBaseBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nameArray[position])
        //glide 사용
    }

    override fun getItemCount(): Int = nameArray.size
}



