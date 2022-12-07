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

            //리사이클러뷰에 리니어뷰를 드래그 하도록 할 것
            binding.itemCard.apply{
                setOnLongClickListener { v -> //길게 누르기

                    // ImageView 객체의 태그에서 새로운 ClipData.Item을 생성
                    val item = ClipData.Item(binding.drinkname.text)



                    val dragData = ClipData(
                        binding.drinkname.text,
                        arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                        item)


                    //그림자 생성
                    val myShadow = MyDragShadowBuilder(this)

                    // 드래그 시작
                    // Drag Event 발생, Data를 넘김
                    v.startDragAndDrop(dragData,  // 드래그 시작
                        myShadow,  // 그림자 만들기
                        null,
                        0
                    )

                    // 롱 클릭 처리
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



