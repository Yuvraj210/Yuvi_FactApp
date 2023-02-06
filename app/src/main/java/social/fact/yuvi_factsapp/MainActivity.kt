package social.fact.yuvi_factsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    lateinit var db:FirebaseFirestore
//      lateinit var arr:ArrayList<FactModal>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val arr= ArrayList<FactModal>()

        val imgref= Firebase.storage.reference.child("yuvi")

        imgref.listAll().addOnSuccessListener {

            for (result in it.items){
                result.downloadUrl.addOnCompleteListener {
                    Log.d("url",it.result.toString())
                    arr.add(FactModal(it.result.toString()))
                }

            }


        }
    RecyclerImage.layoutManager= LinearLayoutManager(this)
    RecyclerImage.adapter=factAdepter(this,arr)


    }}
