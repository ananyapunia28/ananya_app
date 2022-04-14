package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.databinding.FragmentEnterRangeBinding
import kotlinx.android.synthetic.main.fragment_enter_range.*
import kotlinx.android.synthetic.main.fragment_lender.*
import kotlinx.coroutines.*

class EnterRangeFragment : Fragment() {

    private lateinit var binding: FragmentEnterRangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEnterRangeBinding.inflate(layoutInflater)
        binding.register.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                for (i in 0..100) {
                    delay(8)
                    withContext(Dispatchers.Main) {
                        binding.progressBar44.visibility = if (progressBar44.visibility == View.VISIBLE){
                            View.INVISIBLE
                        } else{
                            View.VISIBLE
                        }
                        binding.progressBar44.progress = i
                    }
                }
                //Navigate to next fragment using nav contorller or with Intents for next Activity
                findNavController().navigate(R.id.action_enterRangeFragment_to_decencyScoreFragment)
            }

        }
        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_enterRangeFragment_to_pendingReqFragment)
        }
        return binding.root
    }


}