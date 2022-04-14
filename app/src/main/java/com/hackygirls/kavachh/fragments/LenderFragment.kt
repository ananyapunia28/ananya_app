package com.hackygirls.kavachh.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.adapters.TransactionsHCAdapter
import com.hackygirls.kavachh.couroutines.MainViewModelFactory
import com.hackygirls.kavachh.couroutines.ProfileViewModel
import com.hackygirls.kavachh.couroutines.ProfileViewModelFactory
import com.hackygirls.kavachh.couroutines.Repository
import com.hackygirls.kavachh.dataClass.recenctTrans
import com.hackygirls.kavachh.databinding.FragmentLenderBinding
import com.hackygirls.kavachh.transactions.TransacViewModel
import com.hackygirls.kavachh.transactions.TransacViewModelFactory
import com.hackygirls.kavachh.transactions.TrnsacRepo
import kotlinx.android.synthetic.main.fragment_lender.*

class LenderFragment : Fragment(), View.OnClickListener {
   private lateinit var binding : FragmentLenderBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var viewMModelll: TransacViewModel

//    private lateinit var rView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLenderBinding.inflate(layoutInflater)
        val repository = Repository()
        val viewModelFactory = ProfileViewModelFactory(repository)
//        rView.layoutManager = LinearLayoutManager(activity)
////        val data = ArrayList<recenctTrans>()
////
////        data.add(
////            recenctTrans("AmexDemo_Borrower", "2022-04-05T22:40:43.995", 300, "A")
////        )
//        val adapter = TransactionsHCAdapter(data)
//        rView.adapter = adapter
//        val postList = arrayListOf(recenctTrans("AmexDemo_Borrower", "2022-04-05T22:40:43.995", 300, "A"))
//
//        val postAdapter = TransactionsHCAdapter(postList)
////        rView = binding.recenctTrans
//        rView.setHasFixedSize(true)
//        rView.layoutManager = LinearLayoutManager(activity)
//        rView.adapter = postAdapter

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(ProfileViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(requireActivity(), Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
                binding.acname.text = response.body()?.first_name.toString()
                binding.acno.text = response.body()?.account_number.toString()
                binding.upi.text = response.body()?.upi_id.toString()
                binding.email.text = response.body()?.email.toString()
            }else {
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
//        val repo = TrnsacRepo()
//        val modelFactory = TransacViewModelFactory(repo)
//        viewMModelll.getPost()
//        viewMModelll.myResponse.observe(requireActivity(),{
//           if (it != null){
//               Log.d("Main", it.body().toString())
//           }
//        })


        binding.ic1.setOnClickListener {
            findNavController().navigate(R.id.action_lenderFragment_to_suspectListFragment)
        }
        binding.ic2.setOnClickListener {
            findNavController().navigate(R.id.action_lenderFragment_to_allBorrowersFragment)
        }
        binding.ic3.setOnClickListener {
            findNavController().navigate(R.id.action_lenderFragment_to_pendingReqFragment)
        }
        binding.rtr.setOnClickListener {
            binding.notifi.visibility = if (notifi.visibility == View.VISIBLE){
                View.INVISIBLE
            } else{
                View.VISIBLE
            }
        }

        return binding.root
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}