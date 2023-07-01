package com.calmsleep.layers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calmsleep.layers.databinding.ActivityMainBinding
import com.calmsleep.layers.databinding.Layer1BottomSheetBinding
import com.calmsleep.layers.databinding.Layer2BottomSheetBinding
import com.calmsleep.layers.databinding.Layer3BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layer1 = BottomSheetDialog(this)
        val layer2 = BottomSheetDialog(this)
        val layer3 = BottomSheetDialog(this)

        layer1.setContentView(Layer1BottomSheetBinding.inflate(layoutInflater,binding.root,false).root)

        binding.mainBottomSheet.setOnClickListener {
            layer1.show()
            layer2.setContentView(Layer2BottomSheetBinding.inflate(layoutInflater,binding.root,false).root)
            val openLayer2btn = layer1.findViewById<MaterialButton>(R.id.layer1_bottom_sheet)
            openLayer2btn?.setOnClickListener {
                layer2.show()
                layer3.setContentView(Layer3BottomSheetBinding.inflate(layoutInflater,binding.root,false).root)
                val openLayer3btn = layer2.findViewById<MaterialButton>(R.id.layer2_bottom_sheet)
                openLayer3btn?.setOnClickListener {
                    layer3.show()
                    val closeLayer3btn = layer3.findViewById<MaterialButton>(R.id.layer3_bottom_sheet)
                    closeLayer3btn?.setOnClickListener {
                        layer3.hide()
                    }
                }
            }
        }
    }
}