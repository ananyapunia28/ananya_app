package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.adapters.BorrowersAdapter
import com.hackygirls.kavachh.adapters.SuspectAdapter
import com.hackygirls.kavachh.dataClass.Brrwrs
import com.hackygirls.kavachh.dataClass.Suspect
import com.hackygirls.kavachh.databinding.FragmentSuspectListBinding
import kotlinx.android.synthetic.main.fragment_suspect_list.*

class SuspectListFragment : Fragment() {

    private lateinit var binding : FragmentSuspectListBinding
   // val rView : RecyclerView = trview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSuspectListBinding.inflate(layoutInflater)
//        rView.layoutManager = LinearLayoutManager(context)
//        val data = ArrayList<Suspect>()
//        data.add(
//            Suspect( "200", "AmexDemo_Borrower", "2022-04-06T00:07:52.478", "A")
//        )
//        val adapter = SuspectAdapter(data)
//        rView.adapter = adapter
        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_suspectListFragment_to_lenderFragment)
        }
        return binding.root

    }


}