package Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tikicloneapp.R
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    lateinit var viewFlipper : ViewFlipper
//    var arrayHinh= intArrayOf(R.drawable.viewflipper1, R.drawable.viewflipper3,R.drawable.viewflipper4, R.drawable.viewflipper5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
//            viewFlipper= findViewById(R.id.viewFlipper)
//            for (i in 0 until arrayHinh.size ){
//            var view = ImageView(this)
//            view.setBackgroundResource(i)
//            viewFlipper.addView(view)
//            viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
//            viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
//                        viewFlipper.setFlipInterval(300)
//                        viewFlipper.setAutoStart(true)
////            }
            viewFlipper.setFlipInterval(1500)
            viewFlipper.isAutoStart =true
            viewFlipper.startFlipping()



        }



    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}


