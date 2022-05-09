package com.example.lifecyclefragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecyclefragment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
private var _binding: FragmentFirstBinding? = null
private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("myLogs", "onAttach FirstFragment")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myLogs", "onCreate FirstFragment")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("myLogs", "onCreateView FirstFragment")
        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToSecondFragment.setOnClickListener {
            val fragmentManager =  activity?.supportFragmentManager

            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, SecondFragment.newInstance())
                ?.commitAllowingStateLoss()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("myLogs", "onStart FirstFragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myLogs", "onResume FirstFragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d("myLogs", "onPause FirstFragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("myLogs", "onSaveInstanceState FirstFragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d("myLogs", "onStop FirstFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("myLogs", "onDestroyView FirstFragment")
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.d("myLogs", "onDestroy FirstFragment")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("myLogs", "onDetach FirstFragment")
    }
    companion object {

        fun newInstance():FirstFragment{
return FirstFragment()
            }
    }
}