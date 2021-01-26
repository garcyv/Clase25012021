package com.example.clase25012021

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.clase25012021.databinding.FragmentFirstBinding

private const val mFileNameSHP = "com_example_clase25012021"
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding :FragmentFirstBinding
    private lateinit var mSharedPreferences: SharedPreferences
    var mNumkey:String = "0"
    var mNumero: String = "0"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         mSharedPreferences =
             requireActivity()!!.getSharedPreferences(mFileNameSHP, Context.MODE_PRIVATE)


         mBinding.buttonFirst.setOnClickListener {view ->
             Log.d("btnsig", "Selected")
             findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

         mBinding.btGuardar.setOnClickListener { view ->
             mNumkey = "1"
             mNumero = mBinding.edtNumero.text.toString()
            GrabarPreference(mNumkey, mNumero.toInt())
             Log.d("btnguardar", "Selected")
             mBinding.tventero.text = "Se guardó: " + mSharedPreferences.getInt("1",0).toString()
                }


        mBinding.btBorrar.setOnClickListener {
            BorrarPreference(mNumkey,mNumero.toInt())
            Toast.makeText(this.activity,"Botonb ${mNumkey}",Toast.LENGTH_LONG).show()
            Log.d("btnborrar", "Selected")
        }

    }

    private fun BorrarPreference(mNumkey: String, mNumero: Int) {

    }

    fun GrabarPreference(pClave: String, pValor: Int) {
        Log.d("btnguardar", "Guardar")
        mSharedPreferences.edit().putInt(pClave, pValor).apply()
        Toast.makeText(this.activity,"Botong ${pValor}",Toast.LENGTH_LONG).show()
        Log.d("btnguardar", "Guardado")

    }

}
