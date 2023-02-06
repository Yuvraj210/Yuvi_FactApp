package social.fact.yuvi_factsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fact_row.view.*

class factAdepter(private val context: Context, val imageUrls: ArrayList<FactModal>):RecyclerView.Adapter<factAdepter.ViewHolder>() {
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val factImage=item.factImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fact_row,parent,false))
    }

    override fun getItemCount(): Int {
     return imageUrls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val imageUrl = imageUrls[position]
//
//        Glide.with(context)
//            .load(imageUrl)
//            .into(holder.factImage)
//
//       Glide.with(context).load("https://redwerk.com/wp-content/uploads/2020/07/Picasso_logo.png").into(holder.factImage)
       Glide.with(context).load(imageUrls[position].url).into(holder.factImage)


    }
}