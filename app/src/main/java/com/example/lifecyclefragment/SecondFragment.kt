package com.example.lifecyclefragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lifecyclefragment.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("myLogs", "onAttach SecondFragment")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myLogs", "onCreate SecondFragment")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("myLogs", "onCreateView SecondFragment")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openAlertDialog()
        OpenMultiAlertDialog()
        Log.d("myLogs", "onViewCreated SecondFragment")

    }

    private fun openAlertDialog() {
        binding.buttonOpenAlertDialog.setOnClickListener {
            val alertDialog = AlertDialog.Builder(activity)
            alertDialog.setTitle("Пример AlertDialog")
                .setCancelable(false)
                .setMessage("вы открыли Алерт Диалог")
                .setPositiveButton("Принято") { dialogInterface, i ->
                    Toast.makeText(activity, "нажата кнопка Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Отмена") { dialogInteface, i ->
                    Toast.makeText(activity, "нажата кнопка Negative", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Дополнительно") { dialog, i ->
                    Toast.makeText(activity, "нажата кнопка Neutral", Toast.LENGTH_SHORT).show()
                }
                .show()

        }
    }

    private fun OpenMultiAlertDialog() {
        binding.buttonOpenMultiAlertDialog.setOnClickListener {
            val alertDialog = AlertDialog.Builder(activity)
                .setCancelable(false)
            alertDialog.setTitle("Мульти Алерт Диалог")
                .setMultiChoiceItems(
                    R.array.multiChoice,
                    null,
                    DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                        Log.d("myLogs", "мой любимый цвет:" + i + "/ is " + b)
                    })
                .setPositiveButton("Принято") { dialogInterface, i ->
                    Toast.makeText(activity, "нажата кнопка Positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Отмена") { dialogInteface, i ->
                    Toast.makeText(activity, "нажата кнопка Negative", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Дополнительно") { dialog, i ->
                    Toast.makeText(activity, "нажата кнопка Neutral", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("myLogs", "onStart SecondFragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myLogs", "onResume SecondFragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d("myLogs", "onPause SecondFragment")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("myLogs", "onSaveInstanceState SecondFragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d("myLogs", "onStop SecondFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("myLogs", "onDestroyView SecondFragment")
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.d("myLogs", "onDestroy SecondFragment")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("myLogs", "onDetach SecondFragment")
    }

    companion object {

        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}